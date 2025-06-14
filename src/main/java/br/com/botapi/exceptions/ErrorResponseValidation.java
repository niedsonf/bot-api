package br.com.botapi.exceptions;

import lombok.Getter;

@Getter
public class ErrorResponseValidation extends ErrorResponse {
    private final Object validation;

    public ErrorResponseValidation(int code, String message, Object validation) {
        super(code, message);
        this.validation = validation;
    }
}