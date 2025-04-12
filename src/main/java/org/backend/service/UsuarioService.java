package org.backend.service;

//import io.quarkus.qute.i18n.Message;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import org.backend.enums.PermissaoEnum;
import org.backend.enums.StatusEnum;
import org.backend.model.dto.usuario.AtualizarStatusRoleDTO;
import org.backend.model.dto.usuario.AtualizarUsuarioDTO;
import org.backend.model.dto.usuario.CriarUsuarioDTO;
import org.backend.model.dto.usuario.UsuarioDTO;
import org.backend.model.entity.Usuario;
import org.backend.repositories.UsuarioRepository;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ApplicationScoped
public class UsuarioService {

    @Inject
    UsuarioRepository usuarioRepository;


    public UsuarioDTO create(CriarUsuarioDTO criarUsuario) {
        Usuario usuario = new Usuario();
        usuario.setNome(criarUsuario.nome);
        usuario.setEmail(criarUsuario.email);
        usuario.setTelefone(criarUsuario.telefone);
        usuario.setEndereco(criarUsuario.endereco);
        usuario.setCreatedAt(new Date());
        usuario.setPermissao(String.valueOf(PermissaoEnum.USER));
        usuario.setStatus(String.valueOf(StatusEnum.INATIVO));

        String salt = BCrypt.gensalt();
        String senha = BCrypt.hashpw(criarUsuario.senha, salt) ;
        usuario.setSenha(senha);

        Optional<Usuario> usuarioExiste = usuarioRepository.findByEmail(usuario.getEmail());

        usuarioRepository.persistAndFlush(usuario);

        return UsuarioDTO.entityToDTO(usuario);
    }

    public void delete(Long id) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByIdOptional(id);
        if (usuarioOpt.isEmpty()) {
            throw new WebApplicationException("Usuário não encontrado", Response.Status.NOT_FOUND);
        }
        usuarioRepository.delete(usuarioOpt.get());
    }


    public UsuarioDTO update(Long id, AtualizarUsuarioDTO atualizarUsuario) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByIdOptional(id);

        if (usuarioOpt.isEmpty()) {
            throw new WebApplicationException("Usuário não encontrado", Response.Status.NOT_FOUND);
        }

        Usuario usuario = usuarioOpt.get();

        if (atualizarUsuario.getNome() != null) {
            usuario.setNome(atualizarUsuario.getNome());
        }

        if (atualizarUsuario.getSenha() != null && !atualizarUsuario.getSenha().isBlank()) {
            String salt = BCrypt.gensalt();
            String novaSenha = BCrypt.hashpw(atualizarUsuario.getSenha(), salt);
            usuario.setSenha(novaSenha);
        }

        if (atualizarUsuario.getEmail() != null){
            usuario.setEmail(atualizarUsuario.getEmail());
        }
        if(atualizarUsuario.getEndereco() != null){
            usuario.setEndereco(atualizarUsuario.getEndereco());
        }
        if (atualizarUsuario.getTelefone() != null){
            usuario.setTelefone(atualizarUsuario.getTelefone());
        }

        usuarioRepository.persistAndFlush(usuario);

        return UsuarioDTO.entityToDTO(usuario);
    }

    public List<UsuarioDTO> listAll() {
        List<Usuario> usuarios = usuarioRepository.listAll();
        return usuarios.stream()
                .map(UsuarioDTO::entityToDTO)
                .collect(Collectors.toList());
    }

    public UsuarioDTO atualizarStatusRole(Long id, String statusParam, String roleParam) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByIdOptional(id);
        if (usuarioOpt.isEmpty()) {
            throw new WebApplicationException("Usuário não encontrado", Response.Status.NOT_FOUND);
        }

        Usuario usuario = usuarioOpt.get();

        StatusEnum statusEnum;
        try {
            statusEnum = StatusEnum.valueOf(statusParam);
        } catch (IllegalArgumentException e) {
            throw new WebApplicationException(
                    "Status inválido: " + statusParam,
                    Response.Status.BAD_REQUEST
            );
        }

        PermissaoEnum permissaoEnum;
        try {
            permissaoEnum = PermissaoEnum.valueOf(roleParam);
        } catch (IllegalArgumentException e) {
            throw new WebApplicationException(
                    "Role (permissão) inválida: " + roleParam,
                    Response.Status.BAD_REQUEST
            );
        }

        usuario.setStatus(statusEnum.name());
        usuario.setPermissao(permissaoEnum.name());

        usuarioRepository.persistAndFlush(usuario);

        return UsuarioDTO.entityToDTO(usuario);
    }





}

