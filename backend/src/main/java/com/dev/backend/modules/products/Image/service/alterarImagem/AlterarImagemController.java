package com.dev.backend.modules.products.Image.service.alterarImagem;

import com.dev.backend.modules.products.Image.dto.CreateImageRequestDTO;
import com.dev.backend.modules.products.Image.dto.ProductImageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/imagem")
public class AlterarImagemController {


    @Autowired
    private AlterarImagemService alterarImagemService;


    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<ProductImageDto> handle(@PathVariable("id") Long id, @RequestBody CreateImageRequestDTO data){
        ProductImageDto response =  alterarImagemService.execute(id,data);

        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

}
