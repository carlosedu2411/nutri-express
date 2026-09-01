package br.com.nutriexpress.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.nutriexpress.demo.model.Categoria;
import br.com.nutriexpress.demo.model.Prato;
import br.com.nutriexpress.demo.repository.CategoriaRepository;
import br.com.nutriexpress.demo.repository.PratoRepository;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(CategoriaRepository categoriaRepository, PratoRepository pratoRepository) {
        return args -> {
            Categoria categoria1 = new Categoria();
            categoria1.setNome("Categoria 1");  
            categoria1.setDescricao("Descrição da categoria 1");

            Categoria categoria2 = new Categoria();
            categoria2.setNome("Categoria 2");
            categoria2.setDescricao("Descrição da categoria 2");

            Categoria cat1 = categoriaRepository.save(categoria1);
            Categoria cat2 = categoriaRepository.save(categoria2);
            
            log.info("Preloading " + cat1);
            log.info("Preloading " + cat2);
            
            // Carregar pratos de exemplo
            Prato prato1 = new Prato();
            prato1.setNome("Salada Verde");
            prato1.setDescricao("Salada fresca com legumes");
            prato1.setPreco(25.90);
            prato1.setCalorias(150);
            prato1.setDisponivel(true);
            prato1.setCategoriaId(cat1.getId());
            
            Prato prato2 = new Prato();
            prato2.setNome("Frango Grelhado");
            prato2.setDescricao("Peito de frango com arroz integral");
            prato2.setPreco(35.50);
            prato2.setCalorias(450);
            prato2.setDisponivel(true);
            prato2.setCategoriaId(cat1.getId());
            
            Prato prato3 = new Prato();
            prato3.setNome("Chocolate Quente");
            prato3.setDescricao("Bebida quente nutritiva");
            prato3.setPreco(12.00);
            prato3.setCalorias(300);
            prato3.setDisponivel(true);
            prato3.setCategoriaId(cat2.getId());
            
            log.info("Preloading " + pratoRepository.save(prato1));
            log.info("Preloading " + pratoRepository.save(prato2));
            log.info("Preloading " + pratoRepository.save(prato3));
        };
    }
}
