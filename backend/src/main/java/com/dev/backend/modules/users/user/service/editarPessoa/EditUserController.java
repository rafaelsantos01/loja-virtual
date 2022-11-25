package com.dev.backend.modules.users.user.service.editarPessoa;

import com.dev.backend.modules.users.user.dto.NovaPessoRequestDTO;
import com.dev.backend.modules.users.user.dto.NovaPessoaResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pessoa")
public class EditUserController {

    @Autowired
    private EditUserService editUserService;


    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<NovaPessoaResponseDTO> handle(@PathVariable("id") Long id,@RequestBody NovaPessoRequestDTO data){
        NovaPessoaResponseDTO execute = editUserService.execute(id,data);

        return new ResponseEntity<>(execute, HttpStatus.ACCEPTED);
    }


}
