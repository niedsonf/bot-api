package br.com.botapi.exceptions;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ErrorResponse {
    public int code;
    public String message;
}