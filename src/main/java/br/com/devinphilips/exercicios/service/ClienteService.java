package br.com.devinphilips.exercicios.service;

import br.com.devinphilips.exercicios.model.Cliente;
import br.com.devinphilips.exercicios.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {

        this.clienteRepository = clienteRepository;
    }

    public boolean addCliente(Cliente cliente) {
        return clienteRepository.addCliente(cliente);
    }

    public List<Cliente> getAllClientes() {
        return clienteRepository.getAllClientes();
    }

    public Cliente getClienteById(Integer id) {
        return clienteRepository.getClienteById(id);
    }

    public List<Cliente> updateCliente(Integer id, Cliente updatedCliente) {
        clienteRepository.updateCliente(id, updatedCliente);
        return getAllClientes();
    }

    public boolean deleteCliente(Integer id) {
        return clienteRepository.deleteClienteById(id);
    }


}
