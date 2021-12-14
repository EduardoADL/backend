package com.example.demo.TipoProduto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoProdutoRepository extends JpaRepository<TipoProduto, Long> {
}
