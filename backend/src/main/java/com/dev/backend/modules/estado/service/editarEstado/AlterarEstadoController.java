package com.dev.backend.modules.estado.service.editarEstado;

import com.dev.backend.modules.estado.dto.EstadoRequestAtualizacaoDTO;
import com.dev.backend.modules.estado.dto.EstadoResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/api/estado")
public class AlterarEstadoController {

    @Autowired
    private AlterarEstadoService alterarEstadoService;


    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<EstadoResponseDTO> handle(@PathVariable("id")  Long id,@RequestBody @Valid EstadoRequestAtualizacaoDTO data){
        EstadoResponseDTO response =  alterarEstadoService.execute(id,data);

        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }
}
