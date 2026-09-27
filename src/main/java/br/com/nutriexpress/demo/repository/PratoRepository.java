package br.com.nutriexpress.demo.repository;

import br.com.nutriexpress.demo.model.Prato;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PratoRepository extends JpaRepository<Prato, Long> {

     List<Prato> findByCategoriaIgnoreCase(String categoria);

    List<Prato> findByCaloriasLessThanEqual(Integer max);

    boolean existsByNomeIgnoreCase(String nome);

    boolean existsByNomeIgnoreCaseAndIdNot(String nome, Long id);
}