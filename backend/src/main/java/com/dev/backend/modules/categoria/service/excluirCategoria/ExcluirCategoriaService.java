package com.dev.backend.modules.categoria.service.excluirCategoria;

import com.dev.backend.modules.categoria.entity.Categoria;
import com.dev.backend.modules.categoria.repository.CategoriaRepositorty;
import com.dev.backend.modules.marca.entity.Marca;
import com.dev.backend.modules.marca.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExcluirCategoriaService {

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
