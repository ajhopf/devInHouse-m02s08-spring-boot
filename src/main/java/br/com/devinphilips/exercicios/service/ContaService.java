package br.com.devinphilips.exercicios.service;

import br.com.devinphilips.exercicios.model.Cliente;
import br.com.devinphilips.exercicios.model.Conta;
import br.com.devinphilips.exercicios.repository.ClienteRepository;
import br.com.devinphilips.exercicios.repository.ContaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerErrorException;

import java.util.List;

@Service
public class ContaService {
    private final ContaRepository contaRepository;
    private final ClienteRepository clienteRepository;

    public ContaService(ContaRepository contaRepository, ClienteRepository clienteRepository) {
        this.contaRepository = contaRepository;
        this.clienteRepository = clienteRepository;
    }

    public boolean addConta(Integer clienteId) {
        try {
            Cliente cliente = clienteRepository.getClienteById(clienteId);
            Conta conta = new Conta(cliente);
            return contaRepository.addConta(conta);
        } catch (Exception e) {
            throw new ServerErrorException("Erro no método addConta da classe ContaService.", e);
        }
    }

    public List<Conta> getAllContas() {
        try {
            return contaRepository.getAllContas();
        } catch (Exception e) {
            throw new ServerErrorException("Erro no método getAllContas da classe ContaService.", e);
        }
    }

    public Conta getContaById(Integer id) {
        try{
            return contaRepository.getContaById(id);
        } catch (Exception e) {
            throw new ServerErrorException("Erro no método getContaById da classe ContaService.", e);
        }
    }

    public List<Conta> updateConta(Integer id, Double novoSaldo) {
        try {
            Conta conta = contaRepository.getContaById(id);
            conta.setSaldo(novoSaldo);
            contaRepository.updateConta(id, conta);
            return getAllContas();
        } catch (Exception e) {
            throw new ServerErrorException("Erro no método updateConta da classe ContaService.", e);
        }

    }

    public boolean deleteConta(Integer id) {
        try {
            return contaRepository.deleteContaById(id);
        } catch (Exception e) {
            throw new ServerErrorException("Erro no método deleteConta da classe ContaService.", e);
        }
    }

    public String tranferirValor(Integer idRemetente, Integer idReceptor, Double valor) {
        try {
            Conta conta = contaRepository.getContaById(idRemetente);
            Conta contaReceptora = contaRepository.getContaById(idReceptor);

            if (conta.sacar(valor)) {
                contaReceptora.depositar(valor);
                return ("{\"saldoContaRemetente\": " + conta.getSaldo() + ", \"saldoContaReceptora\": " + contaReceptora.getSaldo() + "}");
            } else {
                return "Saldo insuficiente";
            }
        } catch (Exception e) {
            throw new ServerErrorException("Erro no método tranferirValor da classe ContaService.", e);
        }

    }
}
