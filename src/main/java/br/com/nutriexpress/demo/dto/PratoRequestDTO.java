package br.com.nutriexpress.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Pattern;

import java.math.BigDecimal;

public record PratoRequestDTO(
        @NotBlank String nome,
        @NotBlank String descricao,
        @NotNull @Positive BigDecimal valor,
        @NotBlank String categoria,
        @NotNull @PositiveOrZero Integer calorias,
        @NotNull @Positive Double quantidade,
        @NotBlank @Pattern(regexp = "g|ml") String unidadeMedida
) {
}
