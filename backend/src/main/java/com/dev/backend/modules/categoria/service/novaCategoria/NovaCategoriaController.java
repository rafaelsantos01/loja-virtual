package com.dev.backend.modules.categoria.service.novaCategoria;

import com.dev.backend.modules.categoria.dto.NovaCategoriaRequestDTO;
import com.dev.backend.modules.categoria.dto.NovaCategoriaResponseDTO;
import com.dev.backend.modules.marca.dto.NovaMarcaRequestDTO;
import com.dev.backend.modules.marca.dto.NovaMarcaResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/categoria")
public class NovaCategoriaController {

    @Autowired
    private NovaCategoriaService novaCategoriaService;


    @PostMapping
    @ResponseBody
    public ResponseEntity<NovaCategoriaResponseDTO> handle(@RequestBody @Valid NovaCategoriaRequestDTO data){
        NovaCategoriaResponseDTO response = novaCategoriaService.execute(data);

        return  new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
