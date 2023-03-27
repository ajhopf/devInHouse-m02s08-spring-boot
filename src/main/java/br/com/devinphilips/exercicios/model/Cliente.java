package br.com.devinphilips.exercicios.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

@Data
@AllArgsConstructor
public class Cliente {
    @CPF
    private String cpf;
    @NotBlank
    private String nome;
}
