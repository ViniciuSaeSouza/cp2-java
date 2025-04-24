package com.jovi.rpgCp2.model.item;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jovi.rpgCp2.model.personagem.Personagem;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nome;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Tipo tipo;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Raridade raridade;

    @Min(1)
    private BigDecimal preco;

    @ManyToOne
    @JsonIgnoreProperties("itens")
    private Personagem dono;
}
