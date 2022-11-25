package com.dev.backend.modules.products.brand.service.listarTodas;


import com.dev.backend.modules.products.brand.dto.ListMarcaResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/marca")
public class ListarTodasMarcasController {


    @Autowired
    private ListarTodasMarcasService listarTodasMarcasService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<ListMarcaResponseDTO>> handle(){
       List<ListMarcaResponseDTO> list = listarTodasMarcasService.execute();

       return  new ResponseEntity<>(list, HttpStatus.ACCEPTED);
    }
}
