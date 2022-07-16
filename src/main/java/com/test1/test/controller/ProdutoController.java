package com.test1.test.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test1.test.model.Produto;
import com.test1.test.services.ProdutoService;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<Produto> obterTodos(){
        return produtoService.obterTodos();
    }
    @GetMapping("/{id}")
    public Optional <Produto> obterPorId(@PathVariable Integer id){
        return produtoService.obterPorId(id);
    }
    @PostMapping
    public Produto adicionar(@RequestBody Produto produto){
        return produtoService.adicinar(produto);
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id){
        produtoService.delete(id);
        return "Produto com id:" + id + " foi deletado com sucesso!";
    }
    @PutMapping("/{id}")
    public Produto Update(@RequestBody Produto produto,@PathVariable Integer id){
        return produtoService.Update(id, produto);
    }
}
