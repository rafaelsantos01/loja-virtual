package com.dev.backend.modules.categoria.service.listarCategoria;


import com.dev.backend.modules.categoria.dto.ListCategoriaResponseDTO;
import com.dev.backend.modules.marca.dto.ListMarcaResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categoria")
public class ListarTodasCategoriaController {


    @Autowired
    private ListarTodasCategoriaService listarTodasCategoriaService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<ListCategoriaResponseDTO>> handle(){
       List<ListCategoriaResponseDTO> list = listarTodasCategoriaService.execute();

       return  new ResponseEntity<>(list, HttpStatus.ACCEPTED);
    }
}
