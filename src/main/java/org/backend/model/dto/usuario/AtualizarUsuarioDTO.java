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

    @Schema(description = "Email", example = "email@example.com")
    @NotNull
    public String email;

    @Schema(description = "Sua senha", example = "suasenha")
    @NotNull
    @Length(min = 6)
    public String senha;

    @Schema(description = "Telefone", example = "85987086205")
    @Length(min = 11)
    public String telefone;

    @Schema(description = "Endereco", example = "rua a")
    @Length(min = 4)
    public String endereco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
