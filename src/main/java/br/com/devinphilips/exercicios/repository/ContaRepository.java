package br.com.devinphilips.exercicios.repository;

import br.com.devinphilips.exercicios.model.Conta;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ContaRepository {
    private static final List<Conta>
            contas = new ArrayList<Conta>();

    public boolean addConta(Conta conta) {
        return contas.add(conta);
    }

    public List<Conta> getAllContas() {
        return contas;
    }

    public Conta getContaById(Integer id) {
        return contas.get(id);
    }

    public boolean deleteContaById(Integer id) {
        return contas.remove(getContaById(id));
    }

    public void updateConta(Integer id, Conta updatedConta) {
        contas.set(id, updatedConta);
    }
}
