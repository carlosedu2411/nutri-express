package br.com.nutriexpress.demo.controller;

import br.com.nutriexpress.demo.dto.PratoRequestDTO;
import br.com.nutriexpress.demo.dto.PratoResponseDTO;
import br.com.nutriexpress.demo.dto.PratoValorRequestDTO;
import br.com.nutriexpress.demo.service.PratoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/pratos")
public class PratoController {

    private final PratoService service;

    public PratoController(PratoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<PratoResponseDTO>> listar(
            @RequestParam(required = false) String categoria) {

        if (categoria != null) {
            return ResponseEntity.ok(service.listarPorCategoria(categoria));
        }

        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/calorias")
    public ResponseEntity<List<PratoResponseDTO>> listarPorCalorias(
            @RequestParam Integer max) {
        return ResponseEntity.ok(service.listarPorCalorias(max));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PratoResponseDTO> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<PratoResponseDTO> criar(
            @Valid @RequestBody PratoRequestDTO dto) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.criar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PratoResponseDTO> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody PratoRequestDTO dto) {

        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @PatchMapping("/{id}/valor")
    public ResponseEntity<PratoResponseDTO> atualizarValor(
            @PathVariable Long id,
            @Valid @RequestBody PratoValorRequestDTO dto) {
        return ResponseEntity.ok(service.atualizarValor(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        service.remover(id);
        return ResponseEntity.noContent().build();
    }
}