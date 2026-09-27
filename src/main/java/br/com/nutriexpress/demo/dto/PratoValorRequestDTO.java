package br.com.nutriexpress.demo.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record PratoValorRequestDTO(
        @NotNull @Positive BigDecimal valor
) {
}
