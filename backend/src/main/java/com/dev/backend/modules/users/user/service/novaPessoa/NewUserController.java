package com.dev.backend.modules.users.user.service.novaPessoa;


import com.dev.backend.modules.users.user.dto.NovaPessoRequestDTO;
import com.dev.backend.modules.users.user.dto.NovaPessoaResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pessoa")
public class NewUserController {

    @Autowired
    private NewUserService newUserService;


    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<NovaPessoaResponseDTO> handle(@RequestBody  NovaPessoRequestDTO data){
        NovaPessoaResponseDTO pessoa = newUserService.execute(data);

        return new ResponseEntity<NovaPessoaResponseDTO>(pessoa, HttpStatus.CREATED);
    }

}
