package com.dev.backend.modules.store.product.service.novoProduto;


import com.dev.backend.modules.store.product.dto.ProdutoDTO;
import com.dev.backend.modules.store.product.dto.NovoProdutoRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/produto")
public class NovoProdutoController {

    @Autowired
    private NovoProdutoService novoProdutoService;


    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<ProdutoDTO> handle(@RequestBody NovoProdutoRequestDTO data ){
        ProdutoDTO response = novoProdutoService.execute(data);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
