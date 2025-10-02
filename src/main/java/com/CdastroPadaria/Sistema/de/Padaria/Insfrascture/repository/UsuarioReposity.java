package com.CdastroPadaria.Sistema.de.Padaria.Insfrascture.repository;

import com.CdastroPadaria.Sistema.de.Padaria.Insfrascture.entitys.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UsuarioReposity extends MongoRepository<Usuario,String> {

    Optional<Usuario> findByCpf(String cpf);
    @Transactional
    void deleteBycpf(String cpf);
}
