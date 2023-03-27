package br.com.devinphilips.exercicios.repository;

import br.com.devinphilips.exercicios.model.Cliente;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ClienteRepository {
    private static List<Cliente> clientes = new ArrayList<Cliente>();

    public boolean addCliente(Cliente cliente) {
        return clientes.add(cliente);
    }

    public List<Cliente> getAllClientes() {
        return clientes;
    }

    public Cliente getClienteById(Integer id) {
        return clientes.get(id);
    }

    public boolean deleteClienteById(Integer id) {
        return clientes.remove(getClienteById(id));
    }

    public void updateCliente(Integer id, Cliente updatedCliente) {
        clientes.set(id, updatedCliente);
    }
}
