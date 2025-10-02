package com.CdastroPadaria.Sistema.de.Padaria.Bunisess;

import com.CdastroPadaria.Sistema.de.Padaria.DTO.CompraDTO;
import com.CdastroPadaria.Sistema.de.Padaria.Insfrascture.entitys.Compra;
import com.CdastroPadaria.Sistema.de.Padaria.Insfrascture.entitys.Padaria;
import com.CdastroPadaria.Sistema.de.Padaria.Insfrascture.entitys.Usuario;
import com.CdastroPadaria.Sistema.de.Padaria.Insfrascture.repository.CompraRepository;
import com.CdastroPadaria.Sistema.de.Padaria.Insfrascture.repository.PadariaRepository;
import com.CdastroPadaria.Sistema.de.Padaria.Insfrascture.repository.UsuarioReposity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CompraService {

    private final UsuarioReposity usuarioReposity;
    private final CompraRepository compraRepository;
    private final UsuarioService usuarioService;
    private final PadariaRepository padariaRepository;

    private Double calcularValorTotal(List<Padaria> produtos) {
        return produtos.stream()
                .mapToDouble(Padaria::getValor)
                .sum();
    }

    public Compra criarCompraComDTO(CompraDTO dto) {
        Usuario usuario = usuarioReposity.findById(dto.getUsuarioid())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        List<Padaria> produtos = padariaRepository.findAllById(dto.getProdutosIds());

        Compra compra = Compra.builder()
                .usuarioId(usuario.getId())
                .produtosIds(dto.getProdutosIds())
                .dataCompra(LocalDateTime.now())
                .valorTotal(calcularValorTotal(produtos))
                .build();

        return compraRepository.save(compra);
    }


    public Compra criarCompraComDTO(String id, Compra compra) {
        compra.setId(id);
        return compraRepository.save(compra);
    }
}
