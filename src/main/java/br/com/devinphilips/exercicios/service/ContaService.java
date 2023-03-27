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

    public List<Conta> updateConta(Integer id, Conta updatedConta) {
        contaRepository.updateConta(id, updatedConta);
        return getAllContas();
    }

    public boolean deleteConta(Integer id) {
        return contaRepository.deleteContaById(id);
    }
}
