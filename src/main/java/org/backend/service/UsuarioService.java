package org.backend.service;

//import io.quarkus.qute.i18n.Message;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import org.backend.enums.PermissaoEnum;
import org.backend.enums.StatusEnum;
import org.backend.model.dto.usuario.CriarUsuarioDTO;
import org.backend.model.dto.usuario.UsuarioDTO;
import org.backend.model.entity.Usuario;
import org.backend.repositories.UsuarioRepository;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.Date;
import java.util.Optional;

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
}
