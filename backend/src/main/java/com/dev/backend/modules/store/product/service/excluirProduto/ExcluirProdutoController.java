package com.dev.backend.modules.store.product.service.excluirProduto;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/produto")
public class ExcluirProdutoController {

    @Autowired
    private ExcluirProdutoService excluirProdutoService;


    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Void> handle(@PathVariable("id") Long id){
        excluirProdutoService.execute(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
