package com.itb.inf3bn.pizzariacurso25.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.itb.inf3bn.pizzariacurso25.model.entity.Produto;
import com.itb.inf3bn.pizzariacurso25.model.services.ProdutoService;

@RestController
@RequestMapping("/api/v1/funcionario")
public class FuncionarioController {

    private final ProdutoService produtoService;

    public FuncionarioController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping("/produto")
    public ResponseEntity <Produto> saveProduto(@RequestBody Produto produto){
     URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/produto").toUriString());
     return ResponseEntity.created(uri).body(produtoService.save(produto));

    }

}
