package com.dev.backend.modules.products.brand.service.editarMarca;

import com.dev.backend.modules.products.brand.dto.NovaMarcaRequestDTO;
import com.dev.backend.modules.products.brand.dto.NovaMarcaResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/marca")
public class EditarMarcaController {

    @Autowired
    private EditarMarcaService editarMarcaService;

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<NovaMarcaResponseDTO> handle(@PathVariable("id") Long id, @RequestBody NovaMarcaRequestDTO data){
        NovaMarcaResponseDTO response = editarMarcaService.execute(id,data);

        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }
}
