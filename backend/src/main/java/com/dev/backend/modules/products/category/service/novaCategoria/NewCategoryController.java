package com.dev.backend.modules.products.category.service.novaCategoria;

import com.dev.backend.modules.products.category.dto.NovaCategoriaRequestDTO;
import com.dev.backend.modules.products.category.dto.NovaCategoriaResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/categoria")
public class NewCategoryController {

    @Autowired
    private NewCategoryService newCategoryService;


    @PostMapping
    @ResponseBody
    public ResponseEntity<NovaCategoriaResponseDTO> handle(@RequestBody @Valid NovaCategoriaRequestDTO data){
        NovaCategoriaResponseDTO response = newCategoryService.execute(data);

        return  new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
