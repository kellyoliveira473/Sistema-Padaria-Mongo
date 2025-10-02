package com.CdastroPadaria.Sistema.de.Padaria.Bunisess;

import com.CdastroPadaria.Sistema.de.Padaria.Insfrascture.entitys.User;
import com.CdastroPadaria.Sistema.de.Padaria.Insfrascture.repository.UserRepository;
import com.CdastroPadaria.Sistema.de.Padaria.role.UserRole;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService {

    private final UserRepository repository;

    public AuthorizationService(UserRepository repository) {
        this.repository = repository;
    }

    public boolean userExists(String login) {
        return repository.findByUsername(login) != null;
    }

    public void registerUser(String login, String password, String roleStr) {
        if (userExists(login)) {
            throw new RuntimeException("Usuário já existe!");
        }

        // Senha em texto puro (não seguro)
        String rawPassword = password;

        // Converte string para enum de role
        UserRole roleEnum;
        try {
            roleEnum = UserRole.valueOf(roleStr.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Role inválida: " + roleStr);
        }

        // Cria novo usuário
        User newUser = new User(login, rawPassword, roleEnum);

        // Salva no banco
        repository.save(newUser);
    }

    public User findByLogin(String login) {
        return repository.findByUsername(login);
    }
}
