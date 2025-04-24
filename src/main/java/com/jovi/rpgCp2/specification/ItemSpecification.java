package com.jovi.rpgCp2.specification;


import com.jovi.rpgCp2.controller.ItemController;
import com.jovi.rpgCp2.item.Item;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;

public class ItemSpecification {

    public static Specification<Item> withFilters(ItemController.ItemFilters filters) {
        return (root, query, cb) -> {

            var predicates = new ArrayList<>();
            if (filters.nome() != null) {
                predicates.add(
                        cb.like(
                                cb.lower(root.get("nome")), "%" + filters.nome().toLowerCase() + "%"
                        )
                );
            }

            if (filters.tipo() != null) {
                predicates.add(
                        cb.equal(
                                cb.lower(root.get("tipo")), "%" + filters.tipo().toLowerCase() + "%"
                        )
                );
            }

            if (filters.precoMin() != null && filters.precoMax() != null) {
                predicates.add(
                        cb.between(root.get("preco"), filters.precoMin(), filters.precoMax())
                );
            }

            if (filters.raridade() != null) {
                predicates.add(
                        cb.equal(root.get("raridade"), "%" + filters.raridade().toLowerCase() + "%")
                );
            }

            var arrayPredicates = predicates.toArray(new Predicate[0]);
            return cb.and(arrayPredicates);
        };
    }
}

