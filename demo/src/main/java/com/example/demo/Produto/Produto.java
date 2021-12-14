package com.example.demo.Produto;


import com.example.demo.Fornecedor.Fornecedor;
import com.example.demo.TipoProduto.TipoProduto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Integer quantidade;
    private Double precovenda;
    private Double precocompra;

    @ManyToOne
    private TipoProduto tipoProduto;

    @ManyToOne
    private Fornecedor fornecedor;

    public static Produto from (ProdutoForm produtoForm) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(produtoForm, Produto.class);
    }
}
