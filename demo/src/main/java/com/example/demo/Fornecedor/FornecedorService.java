package com.example.demo.Fornecedor;

import com.example.demo.Fornecedor.Fornecedor;
import com.example.demo.Fornecedor.FornecedorDTO;
import com.example.demo.Fornecedor.FornecedorForm;
import com.example.demo.Fornecedor.FornecedorRepository;
import com.example.demo.config.ModelMapperConf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Autowired
    private ModelMapperConf modelMapper;


    public List<FornecedorDTO> findAll () {
        List<Fornecedor> result = fornecedorRepository.findAll();
        return result.stream().map(FornecedorDTO::from).collect(Collectors.toList());
    }

    public FornecedorDTO create (FornecedorForm obj) {
        Fornecedor fornecedor = Fornecedor.from(obj);
        return FornecedorDTO.from(fornecedorRepository.save(fornecedor));
    }

    public FornecedorDTO findById (Long id) {
        Optional<Fornecedor> obj = fornecedorRepository.findById(id);
        return FornecedorDTO.from(obj.get());
    }

    public FornecedorDTO update (Long id, FornecedorForm fornecedor) {
        Fornecedor fornecedor1 = fornecedorRepository.findById(id).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        });
        modelMapper.modelMapper().map(fornecedor, fornecedor1);
        return FornecedorDTO.from(fornecedorRepository.save(fornecedor1));
    }

    public void delete (Long idFornecedor) {
        findById(idFornecedor);
        try {
            fornecedorRepository.deleteById(idFornecedor);
        } catch (DataAccessException e) {
            throw new DataIntegrityViolationException("Fornecedor não pode ser deletado!");
        }

    }
    
}
