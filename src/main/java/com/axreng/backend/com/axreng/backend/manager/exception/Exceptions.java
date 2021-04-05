package com.axreng.backend.com.axreng.backend.manager.exception;

import java.io.IOException;

public class Exceptions extends IOException {

    private static final long serialVersionUID = 1L;
    private static final String INVALID_URL_MESSAGE = "Base URL inválida: ";
    private static final String INVALID_KEYWORD_MESSAGE = "Keyword inválida! Necessário conter entre 4 e 20 caracteres!"
            + "caracteres: ";

    public Exceptions(String message) {
        super(message);
    }

    public Exceptions(String baseURL, Throwable cause) {
        super(INVALID_URL_MESSAGE + baseURL, cause);
    }

    public Exceptions(int keywordSize) {
        super(INVALID_KEYWORD_MESSAGE + keywordSize);
    }
}
