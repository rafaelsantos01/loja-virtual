package com.dev.backend.modules.categoria.service.excluirCategoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categoria")
public class ExcluirCategoriaController {

    @Autowired
    private ExcluirCategoriaService excluirCategoriaService;

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Void> handle(@PathVariable("id") Long id){
        excluirCategoriaService.execute(id);

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
