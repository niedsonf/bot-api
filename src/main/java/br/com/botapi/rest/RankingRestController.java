package br.com.botapi.rest;

import br.com.botapi.model.User;
import br.com.botapi.usecase.RankingUseCase;
import jakarta.inject.Inject;
import jakarta.validation.constraints.Pattern;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/ranking")
public class RankingRestController {
    @Inject
    RankingUseCase rankingUseCase;

    @GET
    @Path("/{type}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(
            @PathParam("type")
            @Pattern(regexp = "^[1-4]$", message = "Tipo de ranking inválido")
            Integer type) {

        return Response.ok().build();
    }
}
