package com.thiago.usuarios.controller;

import com.thiago.usuarios.model.Usuario;
import com.thiago.usuarios.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class TesteController {

    @Autowired
    private UsuarioRepository repository;

    // GET - listar todos
    @GetMapping
    public List<Usuario> listar() {
        return repository.findAll();
    }

    // POST - criar
    @PostMapping
    public Usuario salvar(@RequestBody Usuario usuario) {
        return repository.save(usuario);
    }

    // GET por ID
    @GetMapping("/{id}")
    public Usuario buscar(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    // PUT - atualizar
    @PutMapping("/{id}")
    public Usuario atualizar(@PathVariable Long id, @RequestBody Usuario novo) {

        Usuario usuario = repository.findById(id).orElse(null);

        if (usuario != null) {
            usuario.setNome(novo.getNome());
            usuario.setEmail(novo.getEmail());
            return repository.save(usuario);
        }

        return null;
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);

    }

}
