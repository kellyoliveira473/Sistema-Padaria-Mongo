package com.CdastroPadaria.Sistema.de.Padaria.Bunisess;

import com.CdastroPadaria.Sistema.de.Padaria.Insfrascture.entitys.Usuario;
import com.CdastroPadaria.Sistema.de.Padaria.Insfrascture.repository.UsuarioReposity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioReposity reposity;

    public UsuarioService(UsuarioReposity reposity) {
        this.reposity = reposity;
    }
    public Usuario salvarUsuario(Usuario usuario){
       return reposity.save(usuario);
    }
    public Usuario buscarPorCpf(String cpf){
        return reposity.findByCpf(cpf)
                .orElseThrow(()-> new RuntimeException("Cpf não encotrado"));
    }
    public void deletarPorCpf(String cpf){
        reposity.deleteBycpf(cpf);
    }
    public Usuario atualizarPorCpf(String cpf ,Usuario usuario){
            Usuario usuarioEntity=reposity.findById(cpf).orElseThrow(()->new RuntimeException("Usuario nao Encontrado"));

            if (usuario.getNome() != null) {
                usuarioEntity.setNome(usuario.getNome());
            }
            if (usuario.getTelefone() != null) {
                usuarioEntity.setTelefone(usuario.getTelefone());
            }

            if (usuario.getDatanascimento() != null) {
            usuarioEntity.setDatanascimento(usuario.getDatanascimento());
            }

            return reposity.save(usuarioEntity);
        }

}

