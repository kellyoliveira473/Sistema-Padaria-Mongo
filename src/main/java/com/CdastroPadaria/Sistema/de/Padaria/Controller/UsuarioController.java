package com.CdastroPadaria.Sistema.de.Padaria.Controller;

import com.CdastroPadaria.Sistema.de.Padaria.Bunisess.PadariaService;
import com.CdastroPadaria.Sistema.de.Padaria.Bunisess.UsuarioService;
import com.CdastroPadaria.Sistema.de.Padaria.Insfrascture.entitys.Padaria;
import com.CdastroPadaria.Sistema.de.Padaria.Insfrascture.entitys.Usuario;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    private final UsuarioService usuarioService;




    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public Usuario cadastrar(@RequestBody Usuario usuario) {
        return usuarioService.salvarUsuario(usuario);
    }

    @GetMapping("/{id}")
    public Usuario BuscarPorId(@PathVariable String cpf) {
        return usuarioService.buscarPorCpf(cpf);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable String cpf) {
        usuarioService.deletarPorCpf(cpf);
    }
    @PutMapping("/{id}")
    public Usuario atualizar(@RequestBody Usuario usuario, @PathVariable String id){
        return usuarioService.atualizarPorCpf(id,usuario);
    }
}


