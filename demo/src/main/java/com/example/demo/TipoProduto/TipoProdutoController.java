package com.example.demo.TipoProduto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipoproduto")
public class TipoProdutoController {

    @Autowired
    private TipoProdutoService service;

    @GetMapping
    public ResponseEntity<List<TipoProdutoDTO>> findAll () {
        List<TipoProdutoDTO> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoProdutoDTO> findById (@PathVariable Long id) {
        TipoProdutoDTO tipoProduto = service.findById(id);
        return ResponseEntity.ok().body(tipoProduto);
    }

    @PostMapping
    public ResponseEntity<TipoProdutoDTO> create (@RequestBody TipoProdutoForm obj) {
        return ResponseEntity.ok(service.create(obj));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoProdutoDTO> update (@PathVariable Long id, @RequestBody TipoProdutoForm obj) {
        return ResponseEntity.ok(service.update(id, obj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
