package br.com.devinphilips.exercicios.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class Conta {
    private Double saldo;
    @NotBlank
    private Cliente cliente;

    public Conta(Cliente cliente) {
        this.cliente = cliente;
        this.saldo = 0d;
    }

    public Double depositar(Double valor) {
        saldo += valor;
        return saldo;
    }

    public boolean sacar(Double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            return true;
        } else {
            return false;
        }
    }
}
