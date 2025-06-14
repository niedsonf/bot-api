package br.com.botapi.rest;

import br.com.botapi.dto.UserCooldownsDTO;
import br.com.botapi.dto.UserJidNameDTO;
import br.com.botapi.model.User;
import br.com.botapi.usecase.UserUseCase;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/user")
public class UserRestController {

    @Inject
    UserUseCase userUseCase;

    @GET
    @Path("/{jid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(
            @PathParam("jid")
            String jid) {
        User user = userUseCase.getUserByJid(jid);
        return Response.ok(user).build();
    }

    @POST
    @Path("/")
    public Response createUser(@Valid UserJidNameDTO request) {
        userUseCase.createUser(request);
        return Response.created(null).build();
    }

    @POST
    @Path("/name")
    public Response updateUserName(@Valid UserJidNameDTO request) {
        userUseCase.updateUserName(request);
        return Response.ok().build();
    }

    @GET
    @Path("/cooldowns/{jid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserCooldowns(
            @PathParam("jid")
            String jid) {
        User user = userUseCase.getUserByJid(jid);
        UserCooldownsDTO cooldownsDTO = new UserCooldownsDTO(user.getName(), user.getCooldowns());
        return Response.ok(cooldownsDTO).build();
    }
}
