package br.com.nutriexpress.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.nutriexpress.demo.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    
}
