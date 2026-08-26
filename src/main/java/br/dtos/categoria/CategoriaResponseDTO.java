package br.dtos.categoria;

import br.com.nutriexpress.demo.model.Categoria;

public class CategoriaResponseDTO {
    Long id;
    String nome;
    String descricao;

    public CategoriaResponseDTO(Categoria categoria) {
        this.id = categoria.getId();
        this.nome = categoria.getNome();
        this.descricao = categoria.getDescricao();
    }
}
