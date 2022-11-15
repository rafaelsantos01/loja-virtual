package com.dev.backend.modules.marca.service.listarTodas;

import com.dev.backend.modules.marca.dto.ListMarcaResponseDTO;
import com.dev.backend.modules.marca.entity.Marca;
import com.dev.backend.modules.marca.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListarTodasMarcasService {

    @Autowired
    private MarcaRepository marcaRepository;

    public List<ListMarcaResponseDTO> execute() {
        List< ListMarcaResponseDTO> response = new ArrayList<>();

        List<Marca> listMarca = marcaRepository.findAll();

        for(Marca marca: listMarca){
            ListMarcaResponseDTO list = new ListMarcaResponseDTO();
            list.setNome(marca.getNome());
            response.add(list);
        }

        if(response.isEmpty()){
            throw new Error("Lista de marcas esta vazia");
        }

        return response;
    }
}
