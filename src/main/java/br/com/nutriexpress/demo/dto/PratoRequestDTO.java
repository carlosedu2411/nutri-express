package br.com.nutriexpress.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

public record PratoRequestDTO(
        @NotBlank(message = "Nome é obrigatório") String nome,
        @NotBlank(message = "Descrição é obrigatória") String descricao,
        @NotNull(message = "Valor é obrigatório") @Positive(message = "Valor deve ser positivo") BigDecimal valor,
        @NotBlank(message = "Categoria é obrigatória") String categoria,
        @NotNull(message = "Calorias são obrigatórias") @PositiveOrZero(message = "Calorias não podem ser negativas") Integer calorias,
        @NotNull(message = "Quantidade é obrigatória") @Positive(message = "Quantidade deve ser positiva") Double quantidade,
        @NotBlank(message = "Unidade de medida é obrigatória") String unidadeMedida
) {
}
