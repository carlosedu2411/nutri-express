package br.com.nutriexpress.demo.repository;

import br.com.nutriexpress.demo.model.Prato;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PratoRepository extends JpaRepository<Prato, Long> {

    List<Prato> findByCategoria(String categoria);

    List<Prato> findByCaloriasLessThanEqual(Integer max);

    boolean existsByNomeIgnoreCase(String nome);

    boolean existsByNomeIgnoreCaseAndIdNot(String nome, Long id);
}