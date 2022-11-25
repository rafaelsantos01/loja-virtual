package com.dev.backend.modules.products.brand.service.excluirMarca;

import com.dev.backend.modules.products.brand.entity.Marca;
import com.dev.backend.modules.products.brand.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExcluirMarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

    public void execute(Long id) {

       Optional<Marca> marca= marcaRepository.findById(id);

       if(marca.isPresent()){
           marcaRepository.delete(marca.get());
       }else{
           throw new Error("Id da marca não encontrado");
       }

    }
}
