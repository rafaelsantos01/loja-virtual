package com.dev.backend.modules.products.category.service.excluirCategoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categoria")
public class DeleteCategoryController {

    @Autowired
    private DeleteCategoryService deleteCategoryService;

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Void> handle(@PathVariable("id") Long id){
        deleteCategoryService.execute(id);

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
