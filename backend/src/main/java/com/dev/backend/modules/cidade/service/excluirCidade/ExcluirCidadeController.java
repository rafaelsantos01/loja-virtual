package com.dev.backend.modules.cidade.service.excluirCidade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cidade")
public class ExcluirCidadeController {

    @Autowired
    private ExcluirCidadeService excluirCidadeService;


    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Void> handle(@PathVariable("id") Long id) {
        excluirCidadeService.execute(id);

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
