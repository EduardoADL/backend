package com.example.demo.Fornecedor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping
    public ResponseEntity<List<FornecedorDTO>> findAll () {
        List<FornecedorDTO> list = fornecedorService.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FornecedorDTO> findById (@PathVariable Long id) {
        FornecedorDTO fornecedor = fornecedorService.findById(id);
        return ResponseEntity.ok().body(fornecedor);
    }

    @PostMapping
    public ResponseEntity<FornecedorDTO> create (@RequestBody FornecedorForm obj) {
        return ResponseEntity.ok(fornecedorService.create(obj));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FornecedorDTO> update (@PathVariable Long id, @RequestBody FornecedorForm obj) {
        return ResponseEntity.ok(fornecedorService.update(id, obj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id) {
        fornecedorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
