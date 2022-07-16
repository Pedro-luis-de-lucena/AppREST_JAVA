package com.test1.test.services;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test1.test.repository.ProdutoRepository;
import com.test1.test.model.Produto;;
@Service
public class ProdutoService {
   @Autowired 
    private ProdutoRepository produtoRepository;

    public List<Produto> obterTodos(){
        return produtoRepository.obterTodos();
    }
        /**
     * metodo que retorna o produto encontrado pelo seu id.
     * @param id do produto que sera localizado.
     * @return retorna um produto caso tenha encontrado
     */
    public Optional <Produto> obterPorId(Integer id){
        return produtoRepository.obterPorId(id);
    } 
        /**
     * metodo para adicionar produto na lista.
     * @param produto produto sendo adicionado.
     * @return retorna o produto adicionado na lista.
     */
    public Produto adicinar(Produto produto){
 
        return produtoRepository.adicinar(produto);
    }
    public void delete(Integer id){
        produtoRepository.delete(id);
    }
    public Produto Update(Integer Id, Produto produto){
        produto.setId(Id);

        return produtoRepository.Update(produto);

    }

}      
