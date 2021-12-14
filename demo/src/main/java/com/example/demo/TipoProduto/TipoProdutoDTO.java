package com.example.demo.TipoProduto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoProdutoDTO {

    private Long id;
    private String tipoproduto;

    public static  TipoProdutoDTO from(TipoProduto tipoProduto){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return  modelMapper.map(tipoProduto, TipoProdutoDTO.class);
    }
}
