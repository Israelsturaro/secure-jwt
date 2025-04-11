package org.backend.model.dto.usuario;

import io.smallrye.common.constraint.NotNull;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.hibernate.validator.constraints.Length;

@Schema(name = "AtualizarUsuario", description = "DTO atualizar usuário")
public class AtualizarUsuarioDTO {

    @Schema(description = "Nome", example = "Fulano de Tal")
    @NotNull
    @Length(min = 6)
    public String nome;

    @Schema(description = "Sua senha", example = "suasenha")
    @NotNull
    @Length(min = 6)
    public String senha;
}
