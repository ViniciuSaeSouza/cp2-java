package com.jovi.rpgCp2.repository;

import com.jovi.rpgCp2.personagem.Personagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PersonagemRepository extends JpaRepository<Personagem, Long>, JpaSpecificationExecutor<Personagem> {
}
