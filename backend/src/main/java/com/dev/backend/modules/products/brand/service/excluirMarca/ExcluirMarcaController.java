package com.dev.backend.modules.products.brand.service.excluirMarca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/marca")
public class ExcluirMarcaController {

    @Autowired
    private ExcluirMarcaService excluirMarcaService;

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Void> handle(@PathVariable("id") Long id){
        excluirMarcaService.execute(id);

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
