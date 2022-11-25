package com.dev.backend.modules.address.city.service.editarCidade;

import com.dev.backend.modules.address.city.dto.AtualizarCidadeRequestDTO;
import com.dev.backend.modules.address.city.dto.AtualizarCidadeResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/cidade")
public class AlterarCidadeController {

    @Autowired
    private AlterarCidadeService alterarCidadeService;


    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<AtualizarCidadeResponseDTO> handle(@PathVariable("id")  Long id, @RequestBody @Valid AtualizarCidadeRequestDTO data){
        AtualizarCidadeResponseDTO response =  alterarCidadeService.execute(id,data);

        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }
}
