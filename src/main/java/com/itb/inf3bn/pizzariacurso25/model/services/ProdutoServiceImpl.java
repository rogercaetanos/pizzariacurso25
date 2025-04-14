package com.itb.inf3bn.pizzariacurso25.model.services;

import org.springframework.stereotype.Service;

import com.itb.inf3bn.pizzariacurso25.exceptions.BadRequest;
import com.itb.inf3bn.pizzariacurso25.exceptions.NotFound;
import com.itb.inf3bn.pizzariacurso25.model.entity.Categoria;
import com.itb.inf3bn.pizzariacurso25.model.entity.Produto;
import com.itb.inf3bn.pizzariacurso25.model.repository.ProdutoRepository;

import jakarta.transaction.Transactional;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    // final: significa que uma vez atribuído o valor não pode ser alterado

    private final ProdutoRepository produtoRepository;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }

    @Override
    public Produto findById(Long id) {
        try {
            Produto produto = produtoRepository.findById(id).get();
            return produto;
        } catch (Exception e) {
           throw new NotFound("Produto não encontradao com o id " + id);
        }
        
    }
    @Override
    @Transactional
    public Produto save(Produto produto) {
       produto.setCodStatus(true);
       if(!produto.validarProduto()){
        throw new BadRequest(produto.getMensagemErro());
       }
       // É possível salvar o produto sem categoria, pois a chave estrangeira é NULL
       if(produto.getCategoria() != null) {
        //Categoria categoria = categoriaService.findById(produto.getCategoria().getId());
        // if(categoria == null) 
        //   throw new BadRequest("Não foi encontrado a categoria com o id + " + produto.getCategoria().getId());
       }
       return produtoRepository.save(produto);
    }

  
}
