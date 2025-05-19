package com.itb.inf3bn.pizzariacurso25.model.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
    @JsonIgnore
    private boolean codStatus;

    // Relacionamento entre entidades

    // @OneToMany:  Um para Muitos (Uma Categoria para Muitos Produtos)
    // mappedBy:    Representa o objeto relacionado na classe filha
    // @JsonIgnore: Não será montado o JSON referente a lista de produtos

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Produto> produtos = new ArrayList<>();

     // Atributos de apoio

    @Transient
    @JsonIgnore
    private String mensagemErro = "";
    @Transient
    @JsonIgnore
    private boolean isValid = true;

    public boolean validarCategoria() {

        if(nome == null || nome.isEmpty()){
            mensagemErro += "O nome da categoria é obrigatório:";
            isValid = false;
        } 
        return isValid;
    }

}
