package br.com.devinphilips.exercicios.service;

import br.com.devinphilips.exercicios.model.Cliente;
import br.com.devinphilips.exercicios.model.Conta;
import br.com.devinphilips.exercicios.repository.ClienteRepository;
import br.com.devinphilips.exercicios.repository.ContaRepository;
import org.springframework.stereotype.Service;

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
            return false;
        }
    }

    public List<Conta> getAllContas() {
        return contaRepository.getAllContas();
    }

    public Conta getContaById(Integer id) {
        return contaRepository.getContaById(id);
    }

    public List<Conta> updateConta(Integer id, Double novoSaldo) {
        Conta conta = contaRepository.getContaById(id);
        conta.setSaldo(novoSaldo);
        contaRepository.updateConta(id, conta);
        return getAllContas();
    }

    public boolean deleteConta(Integer id) {
        return contaRepository.deleteContaById(id);
    }

    public String tranferirValor(Integer idRemetente, Integer idReceptor, Double valor) {
        Conta conta = contaRepository.getContaById(idRemetente);
        Conta contaReceptora = contaRepository.getContaById(idReceptor);

        if (conta.sacar(valor)) {
            contaReceptora.depositar(valor);
            return ("{\"saldoContaRemetente\": " + conta.getSaldo() + ", \"saldoContaReceptora\": " + contaReceptora.getSaldo() + "}");
        } else {
            return "Saldo insuficiente";
        }

    }
}
