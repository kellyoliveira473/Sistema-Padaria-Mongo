package com.CdastroPadaria.Sistema.de.Padaria.Insfrascture.repository;

import com.CdastroPadaria.Sistema.de.Padaria.Insfrascture.entitys.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {
    User findByUsername(String username);

}
