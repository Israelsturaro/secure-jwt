package org.backend.model.dto.auth;

import io.smallrye.common.constraint.NotNull;
import jakarta.validation.constraints.Email;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

@Schema(name = "Login", description = "DTO Login")
public class LoginDTO implements Serializable {

    @Schema(description = "Email", example = "email@example.com")
    @NotNull
    @Email
    public String email;

    @Schema(description = "Sua senha", example = "suasenha")
    @NotNull
    @Length(min = 5)
    public String senha;
}