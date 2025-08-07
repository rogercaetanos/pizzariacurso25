package com.itb.inf3bn.pizzariacurso25.model.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;


@Entity
@DiscriminatorValue(value = "ADMIN")
@NoArgsConstructor
public class Admin extends Usuario {

}
