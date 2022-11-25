package com.dev.backend.modules.products.category.service.editarCategoria;

import com.dev.backend.modules.products.category.dto.NovaCategoriaRequestDTO;
import com.dev.backend.modules.products.category.dto.NovaCategoriaResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categoria")
public class EditCategoryController {

    @Autowired
    private EditCategoryService editCategoryService;

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<NovaCategoriaResponseDTO> handle(@PathVariable("id") Long id, @RequestBody NovaCategoriaRequestDTO data){
        NovaCategoriaResponseDTO response = editCategoryService.execute(id,data);

        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }
}
