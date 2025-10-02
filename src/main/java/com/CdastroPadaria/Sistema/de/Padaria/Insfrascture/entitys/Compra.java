package com.CdastroPadaria.Sistema.de.Padaria.Insfrascture.entitys;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "compra")
public class Compra {

    @Id
    private String id;

    // Armazenando apenas o ID do usuário
    private String usuarioId;

    // Lista de IDs dos produtos (padarias)
    private List<String> produtosIds;

    private LocalDateTime dataCompra;

    private Double valorTotal;
}
