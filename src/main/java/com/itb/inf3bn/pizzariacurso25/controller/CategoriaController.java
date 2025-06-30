package com.itb.inf3bn.pizzariacurso25.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.itb.inf3bn.pizzariacurso25.exceptions.BadRequest;
import com.itb.inf3bn.pizzariacurso25.model.entity.Categoria;
import com.itb.inf3bn.pizzariacurso25.model.services.CategoriaService;


@RestController
@RequestMapping("/api/v1/funcionario")
public class CategoriaController {

    
    private final CategoriaService categoriaService;

    public CategoriaController (CategoriaService categoriaService) {
      
        this.categoriaService = categoriaService;
    }

    @PostMapping
    public ResponseEntity <Categoria> saveCategoria(@RequestBody Categoria categoria){
     URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/categoria").toUriString());
     return ResponseEntity.created(uri).body(categoriaService.save(categoria));

    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> findCategoriaById(@PathVariable(value = "id") String id) {
       try {
        Long idLong = Long.parseLong(id);
        return ResponseEntity.ok().body(categoriaService.findById(idLong));

       } catch (NumberFormatException ex) {
          throw new BadRequest("'"+ id + "' não é um número inteiro válido. Por favor, forneça um valor inteiro, como 10." );
       }
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> findAllCategorias(){
       return ResponseEntity.ok().body(categoriaService.findAll());

    }

    // Exclusão Física (Eliminação total do banco de dados)
    // OBS: SÓ SERÁ POSSÍVEL A EXCLUSÃO CASO NÃO TENHA PRODUTO RELACIONADO
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCategoriaById(@PathVariable(value = "id") String id) {
       try {
        Long idLong = Long.parseLong(id);
        if(categoriaService.delete(idLong)){
           return ResponseEntity.ok().body("categoria com o id " + id + " excluído com sucesso");
        } 

       } catch (NumberFormatException ex) {
          throw new BadRequest("'"+ id + "' não é um número inteiro válido. Por favor, forneça um valor inteiro, como 10." );
       }
      return ResponseEntity.ok().body("Não foi possível a exclusão do categoria com o id " + id);
    }

}
