package com.dev.backend.modules.address.state.service.listarTodos;


import com.dev.backend.modules.address.state.dto.EstadoListAllDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/estado")
public class ListarTodosEstadosController {

    @Autowired
    private ListarTodosEstadosService listarTodosEstadosService;


    @GetMapping("/")
    @ResponseBody
    public ResponseEntity<List<EstadoListAllDTO>> handle() {
        List<EstadoListAllDTO> execute = listarTodosEstadosService.execute();

        return new ResponseEntity<>(execute, HttpStatus.ACCEPTED);
    }
}
