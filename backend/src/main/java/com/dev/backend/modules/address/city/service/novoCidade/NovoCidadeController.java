package com.dev.backend.modules.address.city.service.novoCidade;

import com.dev.backend.modules.address.city.dto.NovaCidadeDTO;
import com.dev.backend.modules.address.city.entity.Cidade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/cidade")
public class NovoCidadeController {

    @Autowired
    private NovoCidadeService novoCidadeService;

    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<Cidade> handle(@RequestBody @Valid NovaCidadeDTO data) {
        Cidade execute = novoCidadeService.execute(data);

        return new ResponseEntity<>(execute, HttpStatus.CREATED);
    }

}
