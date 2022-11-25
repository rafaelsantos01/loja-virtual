package com.dev.backend.modules.products.Image.service.ListarTodasImagens;


import com.dev.backend.modules.products.Image.dto.ProductImageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/imagem")
public class ListarTodasImagensController {

    @Autowired
    private ListarTodasImagensService listarTodasImagensService;



    @GetMapping("/")
    public ResponseEntity<List<ProductImageDto>> handle(){
       List<ProductImageDto> list = listarTodasImagensService.execute();

        return new ResponseEntity<>(list, HttpStatus.ACCEPTED);
    }
}
