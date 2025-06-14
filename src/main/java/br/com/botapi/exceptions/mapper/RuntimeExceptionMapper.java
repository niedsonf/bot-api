package br.com.botapi.exceptions.mapper;

import br.com.botapi.exceptions.ErrorResponse;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class RuntimeExceptionMapper implements ExceptionMapper<RuntimeException> {

    @Override
    public Response toResponse(RuntimeException e) {
        ErrorResponse error = new ErrorResponse(400, e.getMessage());
        return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
    }
}
