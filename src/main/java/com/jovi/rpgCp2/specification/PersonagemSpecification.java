package com.jovi.rpgCp2.specification;

import com.jovi.rpgCp2.controller.PersonagemController;
import com.jovi.rpgCp2.personagem.Personagem;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;

public class PersonagemSpecification {

    public static Specification<Personagem> withFilters(PersonagemController.PersonagemFilters filters){
        return  (root, query, cb) -> {

            var predicates = new ArrayList<>();
            if(filters.nome() != null){
                predicates.add(
                        cb.like(
                                cb.lower(root.get("nome")), "%" + filters.nome().toLowerCase() + "%"
                        )
                );
            }

            if(filters.classe() != null){
                predicates.add(
                        cb.like(
                                cb.upper(root.get("classe")), "%" + filters.classe().toUpperCase() + "%")
                );
            }

            var arrayPredicates = predicates.toArray(new Predicate[0]);
            return cb.and(arrayPredicates);
        };

    }

}
