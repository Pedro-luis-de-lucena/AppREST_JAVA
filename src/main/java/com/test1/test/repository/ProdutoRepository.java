package com.test1.test.repository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import com.test1.test.model.Produto;
import org.springframework.stereotype.Repository;

@Repository
public class ProdutoRepository {

    private List<Produto> produtos = new ArrayList<Produto>();
    private Integer FinalId = 0;
    /**
     * Metodo para retorna uma lista de produtos
     * @return lista de produtos.
     */
    public List<Produto> obterTodos(){
        return produtos;
    }
    /**
     * metodo que retorna o produto encontrado pelo seu id.
     * @param id do produto que sera localizado.
     * @return retorna um produto caso tenha encontrado
     */
    public Optional <Produto> obterPorId(Integer id){
        return produtos
                .stream()
                .filter(produto -> produto.getId() == id)
                .findFirst();
    }
    /**
     * metodo para adicionar produto na lista.
     * @param produto produto sendo adicionado.
     * @return retorna o produto adicionado na lista.
     */
    public Produto adicinar(Produto produto){
        FinalId++;

        produto.setId(FinalId);
        produtos.add(produto);

        return produto;
    }
    /**
     * metodo para deletar o produto por id.
     * @param id do produto a ser deletado
     */
    public void delete(Integer id){
        produtos.removeIf(produto -> produto.getId() == id);
    }
    /**
     * metodo para atualizar o produto na lista
     * @param produto que sera atualizado
     * @return o produto que sera
     */
    public Produto Update(Produto produto){
        Optional<Produto> produtoEncontrado  = obterPorId(produto.getId());

        if(produtoEncontrado.isEmpty()){
            throw new InputMismatchException("produto nao encontrado");
        }
        delete(produto.getId());

        produtos.add(produto);

        return produto;
    }

}
