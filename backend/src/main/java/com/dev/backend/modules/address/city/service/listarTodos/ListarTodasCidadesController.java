package com.dev.backend.modules.address.city.service.listarTodos;


import com.dev.backend.modules.address.city.dto.ListarTodasCidadesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cidade")
public class ListarTodasCidadesController {

    @Autowired
    private ListarTodasCidadesService listarTodasCidadesService;


    @GetMapping("/")
    @ResponseBody
    public ResponseEntity<List<ListarTodasCidadesDTO>> handle() {
        List<ListarTodasCidadesDTO> execute = listarTodasCidadesService.execute();

        return new ResponseEntity<>(execute, HttpStatus.ACCEPTED);
    }
}
