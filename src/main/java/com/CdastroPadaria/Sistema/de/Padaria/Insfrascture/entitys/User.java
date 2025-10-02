package com.CdastroPadaria.Sistema.de.Padaria.Insfrascture.entitys;

import com.CdastroPadaria.Sistema.de.Padaria.role.UserRole;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "user")
public class User {
    @Id
    private String id;

    private String username;
    private String password;

    private UserRole role;

    private boolean enabled = true;

    public User(String username, String password, UserRole role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
}
