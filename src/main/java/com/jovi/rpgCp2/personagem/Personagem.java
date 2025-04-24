package com.jovi.rpgCp2.personagem;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jovi.rpgCp2.item.Item;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@Entity
public class Personagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome não pode estar vazio")
    private String nome;

    @NotNull(message = "Classe não pode estar vazia")
    @Enumerated(EnumType.STRING)
    private Classe classe;

    @Range(min = 1, max = 99, message = "Nível deve estar entre 1 e 99")
    private Integer nivel;

    @Min(value = 0, message = "Não é possível ter menos de 0 moedas")
    private BigDecimal moedas;

    @OneToMany(mappedBy = "dono", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("dono")
    private List<Item> itens;

    public Personagem( String nome, Classe classe, Integer nivel, BigDecimal moedas){
        this.nome = nome;
        this.classe = classe;
        this.nivel = nivel;
        this.moedas = moedas;
    }

    public Personagem() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public BigDecimal getMoedas() {
        return moedas;
    }

    public void setMoedas(BigDecimal moedas) {
        this.moedas = moedas;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(Item itens) {
        this.itens.add(itens);
    }
}
