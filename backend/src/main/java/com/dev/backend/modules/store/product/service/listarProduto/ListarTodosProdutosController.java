package com.dev.backend.modules.store.product.service.listarProduto;


import com.dev.backend.modules.store.product.dto.ProdutoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/produto")
public class ListarTodosProdutosController {

    @Autowired
    private ListarTodosProdutosService listarTodosProdutosService;


    @GetMapping("/")
    @ResponseBody
    public ResponseEntity<List<ProdutoDTO>> handle(){
        List<ProdutoDTO> list = listarTodosProdutosService.execute();

        return new ResponseEntity<>(list, HttpStatus.ACCEPTED);
    }
}
