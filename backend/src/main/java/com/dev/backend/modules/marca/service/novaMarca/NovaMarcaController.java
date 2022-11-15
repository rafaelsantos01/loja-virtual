package com.dev.backend.modules.marca.service.novaMarca;

import com.dev.backend.modules.marca.dto.NovaMarcaRequestDTO;
import com.dev.backend.modules.marca.dto.NovaMarcaResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/marca")
public class NovaMarcaController {

    @Autowired
    private NovaMarcaService novaMarcaService;


    @PostMapping
    @ResponseBody
    public ResponseEntity<NovaMarcaResponseDTO> handle(@RequestBody @Valid NovaMarcaRequestDTO data){
        NovaMarcaResponseDTO response = novaMarcaService.execute(data);

        return  new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
