package com.jovi.rpgCp2.repository;

import com.jovi.rpgCp2.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
