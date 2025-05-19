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
import com.itb.inf3bn.pizzariacurso25.model.entity.Produto;
import com.itb.inf3bn.pizzariacurso25.model.services.CategoriaService;
import com.itb.inf3bn.pizzariacurso25.model.services.ProdutoService;

@RestController
@RequestMapping("/api/v1/funcionario")
public class FuncionarioController {

    private final ProdutoService produtoService;
    private final CategoriaService categoriaService;

    public FuncionarioController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping("/produto")
    public ResponseEntity <Produto> saveProduto(@RequestBody Produto produto){
     URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/produto").toUriString());
     return ResponseEntity.created(uri).body(produtoService.save(produto));

    }


    @GetMapping("/produto/{id}")
    public ResponseEntity<Produto> findProdudoById(@PathVariable(value = "id") String id) {
       try {
        Long idLong = Long.parseLong(id);
        return ResponseEntity.ok().body(produtoService.findById(idLong));

       } catch (NumberFormatException ex) {
          throw new BadRequest("'"+ id + "' não é um número inteiro válido. Por favor, forneça um valor inteiro, como 10." );
       }
    }


    @GetMapping("/produto")
    public ResponseEntity<List<Produto>> findAllProdutos(){
       return ResponseEntity.ok().body(produtoService.findAll());

    }

    // Exclusão Física (Eliminação total do banco de dados)
    @DeleteMapping("/produto/{id}")
    public ResponseEntity<Object> deleteProdudoById(@PathVariable(value = "id") String id) {
       try {
        Long idLong = Long.parseLong(id);
        if(produtoService.delete(idLong)){
           return ResponseEntity.ok().body("Produto com o id " + id + " excluído com sucesso");
        } 

       } catch (NumberFormatException ex) {
          throw new BadRequest("'"+ id + "' não é um número inteiro válido. Por favor, forneça um valor inteiro, como 10." );
       }
      return ResponseEntity.ok().body("Não foi possível a exclusão do produto com o id " + id);
    }

}
