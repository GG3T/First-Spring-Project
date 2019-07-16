package org.brazil.generation.demo.controller;


import org.brazil.generation.demo.UsuarioRepository;
import org.brazil.generation.demo.exception.ResourceNotFoundException;
import org.brazil.generation.demo.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/usuario")
    @ResponseStatus(HttpStatus.CREATED)
    public void save (@RequestBody Usuario usuario){
        usuarioRepository.save(usuario);
    }

    @GetMapping("/usuarios")
    public List findAll(){
        return usuarioRepository.findAll();
    }

    @PutMapping ("usuario/{id}")
    public Usuario update (@PathVariable Long id,@RequestBody Usuario usuario)throws ResourceNotFoundException {
        return usuarioRepository.findById(id).map(usuarioAtualizado-> {
            usuarioAtualizado.setNome(usuario.getNome());
            usuarioAtualizado.setEmail(usuario.getEmail());
            usuarioAtualizado.setLogin(usuario.getLogin());
            usuarioAtualizado.setSenha(usuario.getSenha());
        return usuarioRepository.save(usuarioAtualizado);
        }).orElseThrow ( ()-> new ResourceNotFoundException("Olá igor"));
    }
     @DeleteMapping ("usuario/{id}")
    public void delete (@PathVariable Long id){

     }

    }






