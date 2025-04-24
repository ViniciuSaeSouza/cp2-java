package com.jovi.rpgCp2.controller;

import com.jovi.rpgCp2.personagem.Personagem;
import com.jovi.rpgCp2.repository.PersonagemRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("personagens")
@Slf4j
public class PersonagemController {


    @Autowired
    private PersonagemRepository repository;

    @GetMapping
    public List<Personagem> index(){
        return repository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Personagem> get(@PathVariable Long id){
        return ResponseEntity.ok(getPersonagem(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Personagem> destroy(Long id) {
        repository.delete(getPersonagem(id));
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Personagem> update(@PathVariable Long id, @RequestBody Personagem personagem){
        getPersonagem(id);
        personagem.setId(id);
        repository.save(personagem);
        return ResponseEntity.ok(personagem);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Personagem create(@RequestBody @Valid Personagem personagem){
        return repository.save(personagem);
    }

    private Personagem getPersonagem(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Personagem não encontrado"));
    }
}
