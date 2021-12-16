package com.example.demo.Produto;

import com.example.demo.Fornecedor.Fornecedor;
import com.example.demo.Fornecedor.FornecedorDTO;
import com.example.demo.TipoProduto.TipoProduto;
import com.example.demo.TipoProduto.TipoProdutoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDTO {

    private Long id;

    private String nome;
    private Integer quantidade;
    private Double precovenda;
    private Double precocompra;

    private TipoProduto tipoProduto;

    private Fornecedor fornecedor;

    public static  ProdutoDTO from(Produto produto){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return  modelMapper.map(produto, ProdutoDTO.class);
    }
}
