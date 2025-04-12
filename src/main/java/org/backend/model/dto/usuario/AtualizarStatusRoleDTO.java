package org.backend.model.dto.usuario;

import io.smallrye.common.constraint.NotNull;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Schema(name = "AtualizarStatusRole", description = "DTO para atualizar status e role do usuário")
public class AtualizarStatusRoleDTO {

    @Schema(description = "Novo status do usuário", example = "ATIVO")
    @NotNull
    public String status;

    @Schema(description = "Nova role (permissão) do usuário", example = "ADMIN")
    @NotNull
    public String role;

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
}
