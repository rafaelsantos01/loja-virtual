package com.dev.backend.modules.estado.service.excluirEstado;

import com.dev.backend.modules.estado.dto.EstadoResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/api/estado")
public class ExcluirEstadoController {

    @Autowired
    private ExcluirEstadoService excluirEstadoService;


    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Void> handle(@PathVariable("id") Long id) {
        excluirEstadoService.execute(id);

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
