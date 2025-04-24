package com.jovi.rpgCp2.config;

import com.jovi.rpgCp2.actions.GetbyAction;
import com.jovi.rpgCp2.model.item.Item;
import com.jovi.rpgCp2.model.item.Raridade;
import com.jovi.rpgCp2.model.item.Tipo;
import com.jovi.rpgCp2.model.personagem.Classe;
import com.jovi.rpgCp2.model.personagem.Personagem;
import com.jovi.rpgCp2.repository.ItemRepository;
import com.jovi.rpgCp2.repository.PersonagemRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class DatabaseSeeder{

    @Autowired
    GetbyAction getbyAction;
    @Autowired
    private PersonagemRepository personagemRepository;

    @Autowired
    private ItemRepository itemRepository;

    @PostConstruct
    public void init() {
        var personagens = List.of(
                Personagem.builder()
                        .nome("Eldrin")
                        .classe(Classe.MAGO)
                        .nivel(53)
                        .moedas(BigDecimal.valueOf(1200)).build(),
                Personagem.builder()
                        .nome("Thalion")
                        .classe(Classe.ARQUEIRO)
                        .nivel(28)
                        .moedas(BigDecimal.valueOf(850)).build(),
                Personagem.builder()
                        .nome("Kaelar")
                        .classe(Classe.GUERREIRO)
                        .nivel(40)
                        .moedas(BigDecimal.valueOf(1500)).build(),
                Personagem.builder()
                        .nome("Lyra")
                        .classe(Classe.MAGO)
                        .nivel(32)
                        .moedas(BigDecimal.valueOf(1100)).build()
        );
        personagemRepository.saveAll(personagens);

        var itens = List.of(
                // id 1
                Item.builder()
                        .nome("Bastão Arcano")
                        .tipo(Tipo.ARMA)
                        .raridade(Raridade.EPICO)
                        .preco(BigDecimal.valueOf(699.99))
                        .dono(getbyAction.getPersonagem(Long.parseLong("1")))
                        .build(),
                Item.builder()
                        .nome("Robe Místico")
                        .tipo(Tipo.ARMADURA)
                        .raridade(Raridade.RARO)
                        .preco(BigDecimal.valueOf(399.99))
                        .dono(getbyAction.getPersonagem(Long.parseLong("1")))
                        .build(),
                Item.builder()
                        .nome("Amuleto do Poder")
                        .tipo(Tipo.ACESSORIO)
                        .raridade(Raridade.LENDARIO)
                        .preco(BigDecimal.valueOf(999.99))
                        .dono(getbyAction.getPersonagem(Long.parseLong("1")))
                        .build(),
                Item.builder()
                        .nome("Poção de Mana")
                        .tipo(Tipo.POCAO)
                        .raridade(Raridade.COMUM)
                        .preco(BigDecimal.valueOf(49.99))
                        .dono(getbyAction.getPersonagem(Long.parseLong("1")))
                        .build(),

                // id 2
                Item.builder()
                        .nome("Flechas Envenenadas")
                        .tipo(Tipo.ACESSORIO)
                        .raridade(Raridade.EPICO)
                        .preco(BigDecimal.valueOf(599.99))
                        .dono(getbyAction.getPersonagem(Long.parseLong("2")))
                        .build(),
                Item.builder()
                        .nome("Capa da Camuflagem")
                        .tipo(Tipo.ARMADURA)
                        .raridade(Raridade.RARO)
                        .preco(BigDecimal.valueOf(349.99))
                        .dono(getbyAction.getPersonagem(Long.parseLong("2")))
                        .build(),
                Item.builder()
                        .nome("Arco de Ébano")
                        .tipo(Tipo.ARMA)
                        .raridade(Raridade.LENDARIO)
                        .preco(BigDecimal.valueOf(899.99))
                        .dono(getbyAction.getPersonagem(Long.parseLong("2")))
                        .build(),
                Item.builder()
                        .nome("Poção de Velocidade")
                        .tipo(Tipo.POCAO)
                        .raridade(Raridade.COMUM)
                        .preco(BigDecimal.valueOf(59.99))
                        .dono(getbyAction.getPersonagem(Long.parseLong("2")))
                        .build(),

                // id 3
                Item.builder()
                        .nome("Espada do Dragão")
                        .tipo(Tipo.ARMA)
                        .raridade(Raridade.LENDARIO)
                        .preco(BigDecimal.valueOf(999.99))
                        .dono(getbyAction.getPersonagem(Long.parseLong("3")))
                        .build(),

                Item.builder()
                        .nome("Escudo de Ferro")
                        .tipo(Tipo.ARMADURA)
                        .raridade(Raridade.EPICO)
                        .preco(BigDecimal.valueOf(799.99))
                        .dono(getbyAction.getPersonagem(Long.parseLong("3")))
                        .build(),

                Item.builder()
                        .nome("Elmo do Guerreiro")
                        .tipo(Tipo.ARMADURA)
                        .raridade(Raridade.RARO)
                        .preco(BigDecimal.valueOf(499.99))
                        .dono(getbyAction.getPersonagem(Long.parseLong("3")))
                        .build(),

                Item.builder()
                        .nome("Poção de Força")
                        .tipo(Tipo.POCAO)
                        .raridade(Raridade.COMUM)
                        .preco(BigDecimal.valueOf(69.99))
                        .dono(getbyAction.getPersonagem(Long.parseLong("3")))
                        .build(),

                // id 4
                Item.builder()
                        .nome("Cetro de Cristal")
                        .tipo(Tipo.ARMA)
                        .raridade(Raridade.LENDARIO)
                        .preco(BigDecimal.valueOf(899.99))
                        .dono(getbyAction.getPersonagem(Long.parseLong("4")))
                        .build(),

                Item.builder()
                        .nome("Manto da Noite")
                        .tipo(Tipo.ARMADURA)
                        .raridade(Raridade.EPICO)
                        .preco(BigDecimal.valueOf(599.99))
                        .dono(getbyAction.getPersonagem(Long.parseLong("4")))
                        .build(),

                Item.builder()
                        .nome("Anel da Sabedoria")
                        .tipo(Tipo.ACESSORIO)
                        .raridade(Raridade.RARO)
                        .preco(BigDecimal.valueOf(399.99))
                        .dono(getbyAction.getPersonagem(Long.parseLong("4")))
                        .build(),

                Item.builder()
                        .nome("Poção de Regeneração")
                        .tipo(Tipo.POCAO)
                        .raridade(Raridade.COMUM)
                        .preco(BigDecimal.valueOf(79.99))
                        .dono(getbyAction.getPersonagem(Long.parseLong("4")))
                        .build()
        );

        itemRepository.saveAll(itens);
    }
}
