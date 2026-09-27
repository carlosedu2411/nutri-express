package br.com.nutriexpress.demo.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "pratos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Prato {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;

    @Column(precision = 10, scale = 2)
    private BigDecimal valor;

    private String categoria;
    private Integer calorias;
    private Double quantidade;
    private String unidadeMedida;
}
