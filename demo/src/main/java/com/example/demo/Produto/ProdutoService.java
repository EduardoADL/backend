package com.example.demo.Produto;

import com.example.demo.config.ModelMapperConf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ModelMapperConf modelMapper;


    public List<ProdutoDTO> findAll () {
        List<Produto> result = produtoRepository.findAll();
        return result.stream().map(ProdutoDTO::from).collect(Collectors.toList());
    }

    public ProdutoDTO create (ProdutoForm obj) {
        Produto produto = Produto.from(obj);
        return ProdutoDTO.from(produtoRepository.save(produto));
    }

    public ProdutoDTO findById (Long id) {
        Optional<Produto> obj = produtoRepository.findById(id);
        return ProdutoDTO.from(obj.get());
    }

    public ProdutoDTO update (Long id, ProdutoForm produto) {
        Produto produto1 = produtoRepository.findById(id).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        });

        modelMapper.modelMapper().map(produto, produto1);
        return ProdutoDTO.from(produtoRepository.save(produto1));
    }

    public void delete (Long idProduto) {
        findById(idProduto);
        try {
            produtoRepository.deleteById(idProduto);
        } catch (DataAccessException e) {
            throw new DataIntegrityViolationException("Produto não pode ser deletado!");
        }

    }


}
