package com.CdastroPadaria.Sistema.de.Padaria.Insfrascture.repository;

import com.CdastroPadaria.Sistema.de.Padaria.Insfrascture.entitys.Compra;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface CompraRepository extends MongoRepository<Compra, String> {

}
