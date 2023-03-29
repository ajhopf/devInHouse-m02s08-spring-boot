package br.com.devinphilips.exercicios.controller.handler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespostaErro {
    private String mensagem;
    private String exception;

    public RespostaErro(String exception) {
        this.exception = exception;
    }
}
