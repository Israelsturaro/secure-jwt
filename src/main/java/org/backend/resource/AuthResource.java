package org.backend.resource;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.backend.model.dto.auth.LoginDTO;
import org.backend.model.dto.auth.TokenResponse;
import org.backend.service.AuthService;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/auth")
public class AuthResource {

    @Inject
    AuthService authService;


    @POST()
    @Path("login")
    public TokenResponse login(@Valid LoginDTO login) {
        return authService.login(login);
    }
}