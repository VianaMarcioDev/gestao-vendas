package br.com.marcioviana.gestaovendas.controller;

import br.com.marcioviana.gestaovendas.entidades.Categoria;
import br.com.marcioviana.gestaovendas.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> buscarTodas(){
        return categoriaService.buscarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Categoria>> buscarPorId(@PathVariable Long id){
        Optional<Categoria> categoria = categoriaService.buscarPorId(id);
        return categoria.isPresent() ? ResponseEntity.ok(categoria) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Categoria> salvar(@RequestBody Categoria categoria){
        Categoria categoriaSalva = categoriaService.salvar(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaSalva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> atualizar(@PathVariable Long id, @RequestBody Categoria categoria){
        return ResponseEntity.ok(categoriaService.update(id, categoria));
    }


}
