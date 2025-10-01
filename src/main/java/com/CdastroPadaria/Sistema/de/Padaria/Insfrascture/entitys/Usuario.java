package com.CdastroPadaria.Sistema.de.Padaria.Insfrascture.entitys;

        import jakarta.persistence.*;
        import lombok.*;
        import org.springframework.data.mongodb.core.mapping.Document;

        import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "usuario")
public class Usuario {
    @Id
    private String id;
    private String nome;
    private String cpf;
    private Integer telefone;
    private String email;
    private LocalDate datanascimento;

}
