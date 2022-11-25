package com.dev.backend.modules.products.category.service.excluirCategoria;

import com.dev.backend.modules.products.category.entity.Categoria;
import com.dev.backend.modules.products.category.repository.CategoriaRepositorty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteCategoryService {

    @Autowired
    private CategoriaRepositorty categoriaRepositorty;

    public void execute(Long id) {

       Optional<Categoria> categoria= categoriaRepositorty.findById(id);

       if(categoria.isPresent()){
           categoriaRepositorty.delete(categoria.get());
       }else{
           throw new Error("Id da categoria não encontrado");
       }

    }
}
