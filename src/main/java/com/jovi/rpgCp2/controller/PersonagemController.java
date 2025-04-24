package com.jovi.rpgCp2.controller;

import com.jovi.rpgCp2.character.CharacterData;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("characters")
public class CharacterController {


    @PostMapping
    public void create(CharacterData character){
        System.out.println(character);
    }
}
