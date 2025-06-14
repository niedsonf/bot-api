package br.com.botapi.exceptions.mapper;

import br.com.botapi.exceptions.ErrorResponse;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class NotFoundExceptionMapper implements ExceptionMapper<NotFoundException> {

    @Override
    public Response toResponse(NotFoundException e) {
        ErrorResponse error = new ErrorResponse(404, e.getMessage());
        return Response.status(Response.Status.NOT_FOUND).entity(error).build();
    }
}
