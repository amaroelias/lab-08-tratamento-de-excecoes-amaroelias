package com.ufpb.GestorRepositorios.exception;

public class ValidationError {
    private final String mensagem;
    private final String field;

    ValidationError(String mensagem, String field) {
        this.mensagem = mensagem;
        this.field = field;
    }

    public String getMensagem() {
        return mensagem;
    }

    public String getField() {
        return field;
    }

}
