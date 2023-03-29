package br.com.devinphilips.exercicios.service;

import br.com.devinphilips.exercicios.model.Cliente;
import br.com.devinphilips.exercicios.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerErrorException;

import java.util.List;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {

        this.clienteRepository = clienteRepository;
    }

    public boolean addCliente(Cliente cliente) {
        try {
            return clienteRepository.addCliente(cliente);
        } catch (Exception e) {
            throw new ServerErrorException("Erro no método addCliente da classe ClienteService.", e);
        }
    }

    public List<Cliente> getAllClientes() {
        try {
            return clienteRepository.getAllClientes();
        } catch (Exception e) {
            throw new ServerErrorException("Erro no método getAllClientes da classe ClienteService.", e);
        }
    }

    public Cliente getClienteById(Integer id) {
        try {
            return clienteRepository.getClienteById(id);
        } catch (Exception e) {
            throw new ServerErrorException("Erro no método getClienteById da classe ClienteService.", e);
        }
    }

    public List<Cliente> updateCliente(Integer id, Cliente updatedCliente) {
        try {
            clienteRepository.updateCliente(id, updatedCliente);
            return getAllClientes();
        } catch (Exception e) {
            throw new ServerErrorException("Erro no método updateCliente da classe ClienteService.", e);
        }

    }

    public boolean deleteCliente(Integer id) {
        try {
            return clienteRepository.deleteClienteById(id);
        } catch (Exception e) {
            throw new ServerErrorException("Erro no método deleteCliente da classe ClienteService.", e);
        }
    }

}
