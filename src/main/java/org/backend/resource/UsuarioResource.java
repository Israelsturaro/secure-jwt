package org.backend.resource;

import jakarta.annotation.security.DenyAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.backend.model.dto.usuario.AtualizarStatusRoleDTO;
import org.backend.model.dto.usuario.AtualizarUsuarioDTO;
import org.backend.model.dto.usuario.CriarUsuarioDTO;
import org.backend.model.dto.usuario.UsuarioDTO;
import org.backend.service.UsuarioService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import java.util.List;

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


    @RolesAllowed("ADMIN")
    @Operation(summary = "Método para atualizar usuário")
    @APIResponse(responseCode = "200",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON,
                    schema = @Schema(implementation = AtualizarUsuarioDTO.class, type = SchemaType.OBJECT)))
    @Transactional
    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, @Valid AtualizarUsuarioDTO atualizarUsuario) {
        UsuarioDTO usuarioAtualizado = usuarioService.update(id, atualizarUsuario);
        return Response.ok(usuarioAtualizado).build();
    }

    @RolesAllowed("ADMIN")
    @Operation(summary = "Método para deletar usuário")
    @APIResponse(responseCode = "204", description = "Usuário deletado com sucesso")
    @Transactional
    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        usuarioService.delete(id);
        return Response.noContent().build();
    }

    @RolesAllowed({"USER","ADMIN"})
    @Operation(summary = "Método para listar todos os usuários")
    @APIResponse(responseCode = "200",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON,
                    schema = @Schema(type = SchemaType.ARRAY, implementation = UsuarioDTO.class)))
    @GET
    public Response listAll() {
        List<UsuarioDTO> usuarios = usuarioService.listAll();
        return Response.ok(usuarios).build();
    }


    @RolesAllowed("ADMIN")
    @Operation(summary = "Atualiza o status e a role do usuário via path param")
    @APIResponse(responseCode = "200", description = "Usuário atualizado com sucesso")
    @Transactional
    @PUT
    @Path("/{id}/atualizar-status-role/{status}/{role}")
    public Response atualizarStatusRole(
            @PathParam("id") Long id,
            @PathParam("status") String statusParam,
            @PathParam("role") String roleParam
    ) {
        UsuarioDTO usuarioAtualizado = usuarioService.atualizarStatusRole(id, statusParam, roleParam);
        return Response.ok(usuarioAtualizado).build();
    }




}
