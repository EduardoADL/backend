package com.example.demo.TipoProduto;

import com.example.demo.Produto.Produto;
import com.example.demo.Produto.ProdutoDTO;
import com.example.demo.Produto.ProdutoForm;
import com.example.demo.Produto.ProdutoRepository;
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
public class TipoProdutoService {

    @Autowired
    private TipoProdutoRepository tipoProdutoRepository;

    @Autowired
    private ModelMapperConf modelMapper;


    public List<TipoProdutoDTO> findAll () {
        List<TipoProduto> result = tipoProdutoRepository.findAll();
        return result.stream().map(TipoProdutoDTO::from).collect(Collectors.toList());
    }

    public TipoProdutoDTO create (TipoProdutoForm obj) {
        TipoProduto tipoProduto = TipoProduto.from(obj);
        return TipoProdutoDTO.from(tipoProdutoRepository.save(tipoProduto));
    }

    public TipoProdutoDTO findById (Long id) {
        Optional<TipoProduto> obj = tipoProdutoRepository.findById(id);
        return TipoProdutoDTO.from(obj.get());
    }

    public TipoProdutoDTO update (Long id, TipoProdutoForm tipoProduto) {
        TipoProduto tipoProduto1 = tipoProdutoRepository.findById(id).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        });
        modelMapper.modelMapper().map(tipoProduto, tipoProduto1);
        return TipoProdutoDTO.from(tipoProdutoRepository.save(tipoProduto1));
    }

    public void delete (Long idTipoProduto) {
        findById(idTipoProduto);
        try {
            tipoProdutoRepository.deleteById(idTipoProduto);
        } catch (DataAccessException e) {
            throw new DataIntegrityViolationException("TipoProduto não pode ser deletado!");
        }

    }
    
}
