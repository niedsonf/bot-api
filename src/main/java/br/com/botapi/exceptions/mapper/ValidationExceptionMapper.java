package br.com.botapi.exceptions.mapper;

import br.com.botapi.exceptions.ErrorResponse;
import br.com.botapi.exceptions.ErrorResponseValidation;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.util.Map;

@Provider
public class ValidationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(ConstraintViolationException e) {
        var errors = e.getConstraintViolations()
                .stream()
                .map(ConstraintViolation::getMessage)
                .toList();

        ErrorResponse error = new ErrorResponseValidation(400, "Erro de validação", errors);

        return Response.status(Response.Status.BAD_REQUEST)
                .entity(error)
                .build();
    }
}
