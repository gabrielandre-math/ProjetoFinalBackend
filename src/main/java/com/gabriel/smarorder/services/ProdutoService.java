package com.gabriel.smarorder.services;

import com.gabriel.smarorder.domain.models.Produto;
import com.gabriel.smarorder.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto findById(Integer id) {
        Optional<Produto> obj = produtoRepository.findById(id);
        return obj.orElseThrow(() -> new RuntimeException("Produto não encontrado! ID: " + id));
    }

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public Produto create(Produto obj) {
        obj.setId(null);
        return produtoRepository.save(obj);
    }

    public Produto update(Integer id, Produto obj) {
        Produto newObj = findById(id);
        updateData(newObj, obj);
        return produtoRepository.save(newObj);
    }

    public void delete(Integer id) {
        findById(id);
        produtoRepository.deleteById(id);
    }

    private void updateData(Produto newObj, Produto obj) {
        newObj.setNome(obj.getNome());
        newObj.setPreco(obj.getPreco());
        newObj.setDescricao(obj.getDescricao());
        newObj.setImagem(obj.getImagem());
    }
}
