package com.jovi.rpgCp2.actions;

import com.jovi.rpgCp2.item.Item;
import com.jovi.rpgCp2.personagem.Personagem;
import com.jovi.rpgCp2.repository.ItemRepository;
import com.jovi.rpgCp2.repository.PersonagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class GetbyAction {

    @Autowired
    private PersonagemRepository pr;
    @Autowired
    private  ItemRepository ir;

    public Item getItemById(Long id){
        return ir.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item não encontrado"));
    }

    public Personagem getPersonagem(Long id){
        return pr.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Personagem não encontrado"));
    }
}
