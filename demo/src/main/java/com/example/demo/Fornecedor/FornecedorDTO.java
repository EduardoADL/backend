package com.example.demo.Fornecedor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FornecedorDTO {

    private Long id;
    private String nomefornecedor;

    public static FornecedorDTO from (Fornecedor fornecedor) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(fornecedor, FornecedorDTO.class);
    }
    
}
