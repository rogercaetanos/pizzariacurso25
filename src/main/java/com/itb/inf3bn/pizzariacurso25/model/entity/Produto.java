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
@Table(name = "produtos")
@Data
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String nome;
    @Column(nullable = true, length = 255)
    private String descricao;
    @Column(nullable = true, length = 45)
    private String tipo;
    @Column(nullable = true)
    private int quantidadeEstoque;
    @Column(nullable = true, columnDefinition = "DECIMAL(5,2)")
    private double precoVenda;
    @Column(nullable = true, columnDefinition = "DECIMAL(5,2)")
    private double precoCompra;
    private boolean codStatus;

    // Atributos de apoio

    @Transient            // Anotação para atributos QUE NÃO REPRESENTAM COLUNAS NO BANCO DE DADOS
    private String mensagemErro = "";
    @Transient
    private boolean isValid = true;


    


}
