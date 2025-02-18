package com.itb.inf3bn.pizzariacurso25.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;


@Entity
@Data
@Table(name = "categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String nome;
    @Column(nullable = true, length = 255)
    private String descricao;
    private boolean codStatus;

     // Atributos de apoio

    @Transient
    private String mensagemErro = "";
    @Transient
    private boolean isValid = true;

}
