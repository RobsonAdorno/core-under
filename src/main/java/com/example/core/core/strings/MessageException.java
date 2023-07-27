package com.example.core.core.strings;

public enum MessageException {
    NULLOBJECT("Impossível gravar este item, está nulo!"),
    CLIENTWITHORDER("Error! Não é possível remover um cliente com pedido");

    private final String message;

    MessageException(String messageParams) {
        this.message = messageParams;
    }

    public String getMessage() {
        return message;
    }
}
