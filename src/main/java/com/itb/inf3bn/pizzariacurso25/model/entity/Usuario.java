package com.itb.inf3bn.pizzariacurso25.model.entity;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;


@Entity
@Table(name = "usuarios")
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="role", discriminatorType = DiscriminatorType.STRING)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "role")
@JsonSubTypes({
    @JsonSubTypes.Type(value = Admin.class, name = "ADMIN"),
    @JsonSubTypes.Type(value = Cliente.class, name = "CLIENTE"),
    @JsonSubTypes.Type(value = Funcionario.class, name = "FUNCIONARIO")
})
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = true, length = 100)
    private String nome;
    @Column(nullable = true, length = 20)
    private String cpf;
    @Column(nullable = false, length = 45)
    private String email;
    @Column(nullable = false, length = 250)
    private String password;
    @Column(nullable = true, length = 100)
    private String logradouro;
    @Column(nullable = true, length = 15)
    private String cep;
    @Column(nullable = true, length = 15)
    private String cidade;
    @Column(nullable = true, length = 2)
    private String uf;

    @Enumerated(EnumType.STRING)
    @Column(insertable = false, updatable = false)
    private Role role;

    private boolean codStatus; 

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Telefone> telefones = new ArrayList<>();

    @Transient           
    private String mensagemErro = "";
    @Transient
    private boolean isValid = true;


    public boolean validarUsuario() {

        return isValid;
    }
}
