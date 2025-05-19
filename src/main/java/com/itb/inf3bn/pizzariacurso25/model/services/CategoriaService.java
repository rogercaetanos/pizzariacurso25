package com.itb.inf3bn.pizzariacurso25.model.services;

import java.util.List;

import com.itb.inf3bn.pizzariacurso25.model.entity.Categoria;

public interface CategoriaService {

    public Categoria findById(Long id);
    public Categoria save(Categoria categoria);
    public List<Categoria> findAll();
    public boolean delete (Long id);

}
