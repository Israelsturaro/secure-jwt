package org.backend.resource;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.backend.model.dto.usuario.CriarUsuarioDTO;
import org.backend.model.dto.usuario.UsuarioDTO;
import org.backend.service.UsuarioService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/usuarios")
public class UsuarioResource {

    @Inject
    UsuarioService usuarioService;


    @Operation(summary = "Método para adicionar usuário")
    @APIResponse(responseCode = "201",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON,
                    schema = @Schema(implementation = CriarUsuarioDTO.class, type = SchemaType.OBJECT)))
    @Transactional
    @POST
    public Response add(@Valid CriarUsuarioDTO criarUsuario) {
        UsuarioDTO usuario = usuarioService.create(criarUsuario);
        return Response.status(Response.Status.CREATED)
                .entity(usuario).build();
    }
}
