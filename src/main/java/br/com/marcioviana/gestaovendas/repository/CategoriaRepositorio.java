package br.com.marcioviana.gestaovendas.repository;

import br.com.marcioviana.gestaovendas.entidades.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepositorio extends JpaRepository<Categoria,Long> {


}
