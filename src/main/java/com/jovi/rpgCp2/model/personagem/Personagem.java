package com.jovi.rpgCp2.model.personagem;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jovi.rpgCp2.model.item.Item;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import java.math.BigDecimal;
import java.util.List;


@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
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

}
