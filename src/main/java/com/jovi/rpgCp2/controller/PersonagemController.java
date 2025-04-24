package com.jovi.rpgCp2.controller;

import com.jovi.rpgCp2.actions.GetbyAction;
import com.jovi.rpgCp2.personagem.Personagem;
import com.jovi.rpgCp2.repository.PersonagemRepository;
import com.jovi.rpgCp2.specification.ItemSpecification;
import com.jovi.rpgCp2.specification.PersonagemSpecification;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("personagens")
@Slf4j
public class PersonagemController {


    public record PersonagemFilters (String nome, String classe){}

    @Autowired
    private GetbyAction gb;

    @Autowired
    private PersonagemRepository repository;

    @GetMapping
    public Page<Personagem> index(
            PersonagemFilters filter,
            @PageableDefault(size = 5, sort = "id", direction = Sort.Direction.DESC)Pageable pageable)
    {
        var specification = PersonagemSpecification.withFilters(filter);
        return repository.findAll(specification, pageable);
    }

    @GetMapping("{id}")
    public ResponseEntity<Personagem> get(@PathVariable Long id){
        return ResponseEntity.ok(gb.getPersonagem(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Personagem> destroy(Long id) {
        repository.delete(gb.getPersonagem(id));
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Personagem> update(@PathVariable Long id, @RequestBody Personagem personagem){
        gb.getPersonagem(id);
        personagem.setId(id);
        repository.save(personagem);
        return ResponseEntity.ok(personagem);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Personagem create(@RequestBody @Valid Personagem personagem){
        return repository.save(personagem);
    }

}
