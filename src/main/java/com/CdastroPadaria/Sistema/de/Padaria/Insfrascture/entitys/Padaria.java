package com.CdastroPadaria.Sistema.de.Padaria.Insfrascture.entitys;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Builder
@Document(collection = "padaria")
public class Padaria {

    @Id
    private String id;
    private String produtos;
    private Double valor;


}
