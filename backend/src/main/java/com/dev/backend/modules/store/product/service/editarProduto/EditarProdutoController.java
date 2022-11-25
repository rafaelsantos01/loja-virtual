package com.dev.backend.modules.store.product.service.editarProduto;

import com.dev.backend.modules.store.product.dto.NovoProdutoRequestDTO;
import com.dev.backend.modules.store.product.dto.ProdutoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/produto")
public class EditarProdutoController {

    @Autowired
    private EditarProdutoService editarProdutoService;

    @PostMapping("/{id}")
    @ResponseBody
    public ResponseEntity<ProdutoDTO> handle(@PathVariable("id") Long id, @RequestBody NovoProdutoRequestDTO data){
        ProdutoDTO execute = editarProdutoService.execute(id, data);

        return new ResponseEntity<>(execute, HttpStatus.ACCEPTED);
    }
}
