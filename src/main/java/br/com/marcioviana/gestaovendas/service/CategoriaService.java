package br.com.marcioviana.gestaovendas.service;

import br.com.marcioviana.gestaovendas.entidades.Categoria;
import br.com.marcioviana.gestaovendas.repository.CategoriaRepositorio;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepositorio categoriaRepositorio;

    public List<Categoria> buscarTodas(){
        return categoriaRepositorio.findAll();
    }

    public Optional<Categoria> buscarPorId(Long id){
        return categoriaRepositorio.findById(id);
    }

    public Categoria salvar(Categoria categoria){
        return categoriaRepositorio.save(categoria);
    }

    public Categoria update(Long id, Categoria categoria){
        Categoria categoriaSalvar = validarCategoriaExiste(id);
        BeanUtils.copyProperties(categoria, categoriaSalvar, "id");
        return categoriaRepositorio.save(categoriaSalvar);
    }

    private Categoria validarCategoriaExiste(Long id) {
        Optional<Categoria> categoria = buscarPorId(id);
        if (categoria.isEmpty()){
            throw new EmptyResultDataAccessException(1);
        }
        return categoria.get();
    }
}
