package com.CdastroPadaria.Sistema.de.Padaria.DTO;

import lombok.Data;

import java.util.List;

@Data
public class CompraDTO {
    private String usuarioid;
    private List<String>produtosIds;

}
