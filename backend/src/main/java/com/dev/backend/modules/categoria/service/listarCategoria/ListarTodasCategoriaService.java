package com.dev.backend.modules.categoria.service.listarCategoria;

import com.dev.backend.modules.categoria.dto.ListCategoriaResponseDTO;
import com.dev.backend.modules.categoria.entity.Categoria;
import com.dev.backend.modules.categoria.repository.CategoriaRepositorty;
import com.dev.backend.modules.marca.dto.ListMarcaResponseDTO;
import com.dev.backend.modules.marca.entity.Marca;
import com.dev.backend.modules.marca.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListarTodasCategoriaService {

    @Autowired
    private CategoriaRepositorty categoriaRepositorty;

    public List<ListCategoriaResponseDTO> execute() {
        List<ListCategoriaResponseDTO> response = new ArrayList<>();

        List<Categoria> categorias = categoriaRepositorty.findAll();

        for(Categoria categoria: categorias){
            ListCategoriaResponseDTO list = new ListCategoriaResponseDTO();
            list.setNome(categoria.getNome());
            response.add(list);
        }

        if(response.isEmpty()){
            throw new Error("Lista de Categorias esta vazia");
        }

        return response;
    }
}
