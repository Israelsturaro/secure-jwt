package org.backend.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.backend.model.entity.Usuario;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class UsuarioRepository implements PanacheRepository<Usuario> {

    public Usuario findByName(String nome){
        return find("nome", nome).firstResult();
    }

    public Usuario findUsuarioById(Integer id) {
        return find("id", id).firstResult();
    }

    public Optional<Usuario> findByEmail(String email){
        return find("email", email).firstResultOptional();
    }

    public List<Usuario> findAlive(){
        return list("status", true);
    }

    public void deleteByName(String nome){
        delete("nome", nome);
    }

    public List<Usuario> listAll() {
        return findAll().list();
    }
}
