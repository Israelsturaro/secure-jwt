package org.backend.service;

//import io.quarkus.qute.i18n.Message;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import org.backend.model.dto.usuario.CriarUsuarioDTO;
import org.backend.model.dto.usuario.UsuarioDTO;
import org.backend.model.entity.Usuario;
import org.backend.repositories.UsuarioRepository;
import org.springframework.security.crypto.bcrypt.BCrypt;

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

        String salt = BCrypt.gensalt();
        String senha = BCrypt.hashpw(criarUsuario.senha, salt) ;

        usuario.setSenha(senha);

        Optional<Usuario> usuarioExiste = usuarioRepository.findByEmail(usuario.getEmail());

//        if (usuarioExiste.isPresent()) {
//            throw new WebApplicationException(Response
//                    .status(Response.Status.CONFLICT)
//                    .entity(new Message("Usuário já existe!", Response.Status.CONFLICT.getStatusCode()))
//                    .build()
//            );
//        }

        usuarioRepository.persist(usuario);

        return UsuarioDTO.entityToDTO(usuario);
    }
}
