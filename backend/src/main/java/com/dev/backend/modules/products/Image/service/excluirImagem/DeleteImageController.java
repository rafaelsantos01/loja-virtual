package com.dev.backend.modules.products.Image.service.excluirImagem;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/imagem")
public class DeleteImageController {


    @Autowired
    private DeleteImageService deleteImageService;


    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Void> handle(@PathVariable("id") Long id){

        deleteImageService.execute(id);

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
