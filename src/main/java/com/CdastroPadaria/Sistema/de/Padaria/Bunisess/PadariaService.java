package com.CdastroPadaria.Sistema.de.Padaria.Bunisess;

import com.CdastroPadaria.Sistema.de.Padaria.Insfrascture.entitys.Padaria;
import com.CdastroPadaria.Sistema.de.Padaria.Insfrascture.repository.PadariaRepository;
import org.springframework.stereotype.Service;

@Service

public class PadariaService {
    private final PadariaRepository repository;

    public PadariaService(PadariaRepository repository) {
        this.repository = repository;
    }
    public Padaria  CadastrProduto(Padaria padaria){
         return repository.save(padaria);

    }
    public Padaria BuscaPadariaPorId(String id){
        return repository.findById(id).orElseThrow(
                ()->new RuntimeException("Produto nao encontrado ")
        );
    }
    public void  deletarProdutoPorId(String id){
        repository.deleteById(id);

    }
    public Padaria AtualizaProdutoPorid(String id, Padaria padaria){
        Padaria produtoEntity = repository.findById(id).orElseThrow(
                ()->new RuntimeException("Produto nao encontrado ")
        );
        if (padaria.getProdutos() != null) {
            produtoEntity.setProdutos(padaria.getProdutos());
        }
        if (padaria.getValor() != null) {
            padaria.setValor(padaria.getValor());
        }
        return repository.save(padaria);

    }

}
