package br.com.nutriexpress.demo.service;

import br.com.nutriexpress.demo.exception.PratoNaoEncontradoException;
import br.com.nutriexpress.demo.model.Prato;
import br.com.nutriexpress.demo.repository.PratoRepository;
import br.com.nutriexpress.demo.dto.PratoRequestDTO;
import br.com.nutriexpress.demo.dto.PratoResponseDTO;
import br.com.nutriexpress.demo.dto.PratoValorRequestDTO;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PratoService {

    private final PratoRepository repository;

    public PratoService(PratoRepository repository) {
        this.repository = repository;
    }

    public PratoResponseDTO criar(PratoRequestDTO dto) {
        if (repository.existsByNomeIgnoreCase(dto.nome())) {
            throw new IllegalArgumentException("Já existe um prato com esse nome");
        }

        return toDTO(repository.save(toEntity(dto)));
    }

    public List<PratoResponseDTO> listarTodos() {
        return repository.findAll().stream()
                .map(this::toDTO)
                .toList();
    }

    public PratoResponseDTO buscarPorId(Long id) {
        return toDTO(repository.findById(id)
                .orElseThrow(() -> new PratoNaoEncontradoException(id)));
    }

    public List<PratoResponseDTO> listarPorCategoria(String categoria) {
        return repository.findByCategoriaIgnoreCase(categoria)
                .stream()
                .map(this::toDTO)
                .toList();
    }

    public PratoResponseDTO atualizar(Long id, PratoRequestDTO dto) {
        Prato prato = repository.findById(id)
                .orElseThrow(() -> new PratoNaoEncontradoException(id));

        // Regra de negocio: dois pratos nao podem ter o mesmo nome, inclusive na atualizacao.
        if (repository.existsByNomeIgnoreCaseAndIdNot(dto.nome(), id)) {
            throw new IllegalArgumentException("Ja existe um prato com esse nome");
        }

        prato.setNome(dto.nome());
        prato.setDescricao(dto.descricao());
        prato.setValor(dto.valor());
        prato.setCategoria(dto.categoria());
        prato.setCalorias(dto.calorias());
        prato.setQuantidade(dto.quantidade());
        prato.setUnidadeMedida(dto.unidadeMedida());

        return toDTO(repository.save(prato));
    }

    public List<PratoResponseDTO> listarPorCalorias(Integer max) {
        return repository.findByCaloriasLessThanEqual(max).stream()
                .map(this::toDTO)
                .toList();
    }

    public PratoResponseDTO atualizarValor(Long id, PratoValorRequestDTO dto) {
        Prato prato = repository.findById(id)
                .orElseThrow(() -> new PratoNaoEncontradoException(id));

        prato.setValor(dto.valor());
        return toDTO(repository.save(prato));
    }

    public void remover(Long id) {
        Prato prato = repository.findById(id)
                .orElseThrow(() -> new PratoNaoEncontradoException(id));

        repository.delete(prato);
    }

    private Prato toEntity(PratoRequestDTO dto) {
        Prato prato = new Prato();
        prato.setNome(dto.nome());
        prato.setDescricao(dto.descricao());
        prato.setValor(dto.valor());
        prato.setCategoria(dto.categoria());
        prato.setCalorias(dto.calorias());
        prato.setQuantidade(dto.quantidade());
        prato.setUnidadeMedida(dto.unidadeMedida());
        return prato;
    }

    private PratoResponseDTO toDTO(Prato prato) {
        return new PratoResponseDTO(
                prato.getId(),
                prato.getNome(),
                prato.getDescricao(),
                prato.getValor(),
                prato.getCategoria(),
                prato.getCalorias(),
                prato.getQuantidade(),
                prato.getUnidadeMedida()
        );
    }
}