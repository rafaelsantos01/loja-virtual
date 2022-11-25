package com.dev.backend.modules.users.user.service.ListarTodasPessoas;

import com.dev.backend.modules.users.user.dto.PessoaListDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pessoa")
public class ListAllUserController {

    @Autowired
    private ListAllUserService listAllUserService;


    @GetMapping("/")
    @ResponseBody
    public ResponseEntity<List<PessoaListDTO>> handle(){
        List<PessoaListDTO> lista = listAllUserService.execute();

        return new ResponseEntity<List<PessoaListDTO>>(lista, HttpStatus.ACCEPTED);
    }

}
