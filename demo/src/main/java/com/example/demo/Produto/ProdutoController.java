package com.example.demo.Produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> findAll () {
        List<ProdutoDTO> list = produtoService.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> findById (@PathVariable Long id) {
        ProdutoDTO produto = produtoService.findById(id);
        return ResponseEntity.ok().body(produto);
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> create (@RequestBody  ProdutoForm obj) {
        return ResponseEntity.ok(produtoService.create(obj));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoDTO> update (@PathVariable Long id, @RequestBody ProdutoForm obj) {
        return ResponseEntity.ok(produtoService.update(id, obj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id) {
        produtoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
