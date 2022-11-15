package com.dev.backend.modules.categoria.service.editarCategoria;

import com.dev.backend.modules.categoria.dto.NovaCategoriaRequestDTO;
import com.dev.backend.modules.categoria.dto.NovaCategoriaResponseDTO;
import com.dev.backend.modules.marca.dto.NovaMarcaRequestDTO;
import com.dev.backend.modules.marca.dto.NovaMarcaResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categoria")
public class EditarCategoriaController {

    @Autowired
    private EditarCategoriaService editarCategoriaService;

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<NovaCategoriaResponseDTO> handle(@PathVariable("id") Long id, @RequestBody NovaCategoriaRequestDTO data){
        NovaCategoriaResponseDTO response = editarCategoriaService.execute(id,data);

        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }
}
