package com.CdastroPadaria.Sistema.de.Padaria.Insfrascture.repository;

import com.CdastroPadaria.Sistema.de.Padaria.Insfrascture.entitys.Padaria;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PadariaRepository extends MongoRepository<Padaria,String> {
}
