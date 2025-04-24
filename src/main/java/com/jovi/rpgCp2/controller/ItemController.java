package com.jovi.rpgCp2.controller;

import com.jovi.rpgCp2.actions.GetbyAction;
import com.jovi.rpgCp2.item.Item;
import com.jovi.rpgCp2.personagem.Personagem;
import com.jovi.rpgCp2.repository.ItemRepository;
import jakarta.validation.Valid;
import org.hibernate.mapping.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("itens")
public class ItemController {
    public record ItemFilters (String nome, String tipo, BigDecimal preco, BigDecimal max, BigDecimal min, String raridade){}

    @Autowired
    GetbyAction gb;

    @Autowired
    ItemRepository repository;

    @GetMapping
    public List<Item> index() {
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Item create(@RequestBody @Valid Item item){
        var personagem = gb.getPersonagem(item.getDono().getId());
        item.setDono(personagem);
        personagem.setItem(item);
        return repository.save(item);
    }

    @PutMapping("{id}")
    public ResponseEntity<Item> update(@PathVariable Long id, @RequestBody @Valid Item item){
        gb.getItemById(id);
        item.setId(id);
        repository.save(item);
        return ResponseEntity.ok(item);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Item> destroy(@PathVariable Long id){
        repository.delete(gb.getItemById(id));
        return ResponseEntity.noContent().build();
    }

    private Item getItem(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item não encontrado"));
    }

}
