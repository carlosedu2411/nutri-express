package br.dtos.categoria;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoriaRequestDTO {
    
    
    @NotBlank(message = "O campo nome da categoria é obrigatório")
    @Size(max = 50, message = "O campo nome da categoria deve ter no máximo 50 caracteres")
    private String nome;
    @Size(max = 200, message = "O campo descrição da categoria deve ter no máximo 200 caracteres")
    private String descricao;
    
}
