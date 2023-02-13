package br.com.marcioviana.gestaovendas.repository;

import br.com.marcioviana.gestaovendas.entidades.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.yaml.snakeyaml.events.Event;

public interface CategoriaRepositorio extends JpaRepository<Categoria, Long> {


}
