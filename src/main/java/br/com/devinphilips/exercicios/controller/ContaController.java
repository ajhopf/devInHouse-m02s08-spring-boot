package br.com.devinphilips.exercicios.controller;

import br.com.devinphilips.exercicios.model.Conta;
import br.com.devinphilips.exercicios.service.ClienteService;
import br.com.devinphilips.exercicios.service.ContaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/conta")
@RestController
public class ContaController {
    private final ContaService service;
    private final ClienteService clienteService;

    public ContaController(ContaService service, ClienteService clienteService) {
        this.service = service;
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<Conta> getAllContas() {
        return service.getAllContas();
    }

    @GetMapping(params = "id")
    public Conta getContaById(@RequestParam Integer id) {
        return service.getContaById(id);
    }

    @PostMapping(params="clienteId")
    public boolean addConta(@RequestParam Integer clienteId) {
        return service.addConta(clienteId);
    }

    @PutMapping
    public List<Conta> atualizarConta(
            @RequestParam Integer id,
            @RequestBody Conta conta) {
        return service.updateConta(id, conta);
    }

    @DeleteMapping("/{id}")
    public boolean deleteConta(@PathVariable Integer id) {
        return service.deleteConta(id);
    }
}
