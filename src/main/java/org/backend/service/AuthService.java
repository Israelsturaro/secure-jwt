package org.backend.service;

import io.smallrye.jwt.build.Jwt;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotAuthorizedException;
import org.backend.model.dto.auth.LoginDTO;
import org.backend.model.dto.auth.TokenResponse;
import org.backend.model.entity.Usuario;
import org.backend.repositories.UsuarioRepository;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.jwt.Claims;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.time.Duration;
import java.time.Instant;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@ApplicationScoped
public class AuthService {

    @Inject
    UsuarioRepository usuarioRepository;

    @ConfigProperty(name = "mp.jwt.verify.issuer")
    String issuer;

    public TokenResponse login(LoginDTO login){
        TokenResponse tokenResponse = new TokenResponse();

        Optional<Usuario> usuario = usuarioRepository.findByEmail(login.email);

        if(usuario.isEmpty()){
            throw new NotAuthorizedException("Erro ao efetuar a autenticação");
        }

        if(!BCrypt.checkpw(login.senha, usuario.get().getSenha())){
            throw new NotAuthorizedException("Erro ao realizar o login, e-mail ou senha inválido!");
        }

        tokenResponse.token = gerarTokenJWT(usuario.get());

        return tokenResponse;
    }

    public String gerarTokenJWT(Usuario usuario){
        Set<String> groups = new HashSet<>();

        String token =
                Jwt.issuer(issuer)
                        .upn(usuario.getEmail())
                        .groups(groups)
                        .claim(Claims.full_name, usuario.getNome())
                        .expiresAt(Instant.now().plus(Duration.ofHours(1)))
                        .sign();
        return token;
    }

}
