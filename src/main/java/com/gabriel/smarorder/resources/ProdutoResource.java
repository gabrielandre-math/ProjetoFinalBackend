package com.gabriel.smarorder.resources;

import com.gabriel.smarorder.domain.models.Produto;
import com.gabriel.smarorder.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/produtos")
public class ProdutoResource {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Integer id) {
        Produto obj = produtoService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<Produto>> findAll() {
        List<Produto> list = produtoService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<Produto> create(@RequestBody Produto obj) {
        Produto newObj = produtoService.create(obj);
        return ResponseEntity.ok().body(newObj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Produto> update(@PathVariable Integer id, @RequestBody Produto obj) {
        Produto newObj = produtoService.update(id, obj);
        return ResponseEntity.ok().body(newObj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        produtoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{id}/imagem", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> getImage(@PathVariable Integer id) {
        Produto produto = produtoService.findById(id);
        byte[] imagem = produto.getImagem();
        if (imagem == null || imagem.length == 0) {
            return ResponseEntity.notFound().build(); // Retorna 404 se a imagem não for encontrada
        }
        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(imagem);
    }


}
