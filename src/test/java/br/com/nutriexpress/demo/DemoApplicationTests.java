package br.com.nutriexpress.demo;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import br.com.nutriexpress.demo.dto.PratoRequestDTO;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class DemoApplicationTests {

    @Test
    void deveCriarDtoValido() {
        PratoRequestDTO dto = new PratoRequestDTO(
                "Salada Fitness",
                "Salada fresca com quinoa",
                new BigDecimal("29.90"),
                "vegano",
                320,
                250.0,
                "g"
        );

        assertNotNull(dto);
        assertNotNull(dto.nome());
        assertNotNull(dto.valor());
    }
}
