package com.dev.backend.modules.address.state.service.novoEstado;

import com.dev.backend.modules.address.state.dto.EstadoSalvarDTO;
import com.dev.backend.modules.address.state.entity.Estado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/estado")
public class NovoEstadoController {

    @Autowired
    private NovoEstadoService novoEstadoService;

    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<Estado> handle(@RequestBody @Valid EstadoSalvarDTO data) {
        Estado execute = novoEstadoService.execute(data);

        return new ResponseEntity<>(execute, HttpStatus.CREATED);
    }

}
