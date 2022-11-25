package com.dev.backend.modules.products.Image.service.novaImagem;


import com.dev.backend.modules.products.Image.dto.CreateImageRequestDTO;
import com.dev.backend.modules.products.Image.dto.ProductImageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/imagem")
public class CreateImageController {

    @Autowired
    private CreateImageService createImageService;



    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<ProductImageDto> handle(@RequestBody @Valid  CreateImageRequestDTO data){

        ProductImageDto response = createImageService.execute(data);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


}
