package com.example.demo;

import com.example.demo.TipoProduto.TipoProdutoForm;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TipoProdutoTest {

    @Autowired
    private MockMvc mockMvc;


    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void incia() throws Exception {
        TipoProdutoForm tipoProdutoForm = new TipoProdutoForm("utensilho de casa");

        mockMvc.perform(post("/tipoproduto").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(tipoProdutoForm)))
                .andReturn();

    }

    @Test
    public void verificaSeAFoiCriado() throws Exception{
        TipoProdutoForm tipoProdutoForm = new TipoProdutoForm("utensilho de casa");


        mockMvc.perform(post("/tipoproduto").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(tipoProdutoForm)))
                .andExpect(status().isOk())
                .andReturn();
    }
}
