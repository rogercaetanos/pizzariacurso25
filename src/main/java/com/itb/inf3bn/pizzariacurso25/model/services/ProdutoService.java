package com.itb.inf3bn.pizzariacurso25.model.services;

import com.itb.inf3bn.pizzariacurso25.model.entity.Produto;

public interface ProdutoService {

    public Produto findById(Long id);
    public Produto save(Produto produto);

}
