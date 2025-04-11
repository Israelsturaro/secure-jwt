package org.backend.model.dto.usuario;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.backend.model.entity.Usuario;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.Date;


@Schema(name = "Usuario", description = "DTO usuário")
public class UsuarioDTO implements Serializable {

    @Schema(description = "Id usuário", example = "1", hidden = true)
    public Long id;

    @Schema(description = "Email", example = "email@example.com")
    public String email;

    @Schema(description = "Senha", example = "suasenha", hidden = true)
    @Length(min = 6)
    public String senha;

    @Schema(description = "Nome", example = "Fulano de Tal")
    @Length(min = 6)
    public String nome;

    @Schema(description = "Endereço", example = "Seu Endereço")
    public String endereco;

    @Schema(description = "Telefone", example = "00000000000")
    public String telefone;

    @Schema(description = "Status", example = "ATIVO")
    public String status;

    @Schema(description = "Criado em", example = "2022-03-13 19:21:37", hidden = true)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    public Date createdAt;

    @Schema(description = "Atualizado em", example = "2022-03-13 19:21:37", hidden = true)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    public Date updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    static public UsuarioDTO entityToDTO(Usuario usuario){
        UsuarioDTO response = new UsuarioDTO();
        response.id = usuario.getId();
        response.email = usuario.getEmail();
        response.senha = usuario.getSenha();
        response.endereco = usuario.getEndereco();
        response.nome = usuario.getNome();
        response.status = usuario.getStatus();
        response.updatedAt = usuario.getUpdatedAt();
        response.createdAt = usuario.getCreatedAt();
        response.telefone = usuario.getTelefone();
        return response;
    }
}