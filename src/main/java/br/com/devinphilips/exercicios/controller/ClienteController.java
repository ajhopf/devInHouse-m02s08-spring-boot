package br.com.devinphilips.exercicios.controller;

import br.com.devinphilips.exercicios.model.Cliente;
import br.com.devinphilips.exercicios.service.ClienteService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/cliente")
@RestController
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {

        this.service = service;
    }

    @GetMapping
    public List<Cliente> getAllClientes() {
        return service.getAllClientes();
    }

    @GetMapping(params = "id")
    public Cliente getClienteById(@RequestParam Integer id) {
        return service.getClienteById(id);
    }

    @PostMapping
    public boolean addCliente(@RequestBody @Validated Cliente cliente) {
        return service.addCliente(cliente);
    }

    @PutMapping
    public List<Cliente> atualizarCliente(
            @RequestParam Integer id,
            @RequestBody @Validated Cliente cliente) {
        return service.updateCliente(id, cliente);
    }

    @DeleteMapping("/{id}")
    public boolean deleteCliente(@PathVariable Integer id) {
        return service.deleteCliente(id);
    }

}
