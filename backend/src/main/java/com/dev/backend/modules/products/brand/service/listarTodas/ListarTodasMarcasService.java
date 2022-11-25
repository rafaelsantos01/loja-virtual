package com.dev.backend.modules.products.brand.service.listarTodas;

import com.dev.backend.modules.products.brand.dto.ListMarcaResponseDTO;
import com.dev.backend.modules.products.brand.entity.Marca;
import com.dev.backend.modules.products.brand.repository.MarcaRepository;
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
            list.setId(marca.getId());
            list.setDataAtualizacao(marca.getDataAtualizacao());
            list.setDataCriacao(marca.getDataCriacao());

            response.add(list);
        }

        if(response.isEmpty()){
            throw new Error("Lista de marcas esta vazia");
        }

        return response;
    }
}
