package com.itb.inf3bn.pizzariacurso25.model.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.itb.inf3bn.pizzariacurso25.exceptions.BadRequest;
import com.itb.inf3bn.pizzariacurso25.exceptions.NotFound;

import com.itb.inf3bn.pizzariacurso25.model.entity.Categoria;
import com.itb.inf3bn.pizzariacurso25.model.repository.CategoriaRepository;

import jakarta.transaction.Transactional;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    // final: significa que uma vez atribuído o valor não pode ser alterado

    private final CategoriaRepository categoriaRepository;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository){
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public Categoria findById(Long id) {
        try {
            Categoria categoria = categoriaRepository.findById(id).get();
            return categoria;
        } catch (Exception e) {
           throw new NotFound("Categoria não encontrada com o id " + id);
        }
        
    }
    @Override
    @Transactional
    public Categoria save(Categoria categoria) {
       categoria.setCodStatus(true);
       if(!categoria.validarCategoria()){
        throw new BadRequest(categoria.getMensagemErro());
       }
       return categoriaRepository.save(categoria);
    }

    @Override
    public List<Categoria> findAll() {
      
        return categoriaRepository.findAll();
    }

    @Override
    @Transactional
    public boolean delete(Long id) {  
       if(!categoriaRepository.existsById(id)){
          throw new NotFound("Não foi encontrado a categoria com o id " + id );
       }
       categoriaRepository.deleteById(id);
       return true;
    } 
}
