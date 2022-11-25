package com.dev.backend.modules.users.user.service.excluirPessoa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pessoa")
public class DeleteUserController {

    @Autowired
    private DeleteUserService deleteUserService;


    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Void> handle(@PathVariable("id") Long id){
        deleteUserService.execute(id);

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
