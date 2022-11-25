package com.dev.backend.modules.products.category.service.listarCategoria;


import com.dev.backend.modules.products.category.dto.ListCategoriaResponseDTO;
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
public class ListAllCategoryController {


    @Autowired
    private ListAllCategoryService listAllCategoryService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<ListCategoriaResponseDTO>> handle(){
       List<ListCategoriaResponseDTO> list = listAllCategoryService.execute();

       return  new ResponseEntity<>(list, HttpStatus.ACCEPTED);
    }
}
