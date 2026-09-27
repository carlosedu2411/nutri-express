package br.com.nutriexpress.demo.controller;

import br.com.nutriexpress.demo.dto.PratoRequestDTO;
import br.com.nutriexpress.demo.dto.PratoResponseDTO;
import br.com.nutriexpress.demo.dto.PratoValorRequestDTO;
import br.com.nutriexpress.demo.service.PratoService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
        if (categoria != null && !categoria.isBlank()) {
            return ResponseEntity.ok(service.listarPorCategoria(categoria));
        }
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PratoResponseDTO> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping("/calorias")
    public ResponseEntity<List<PratoResponseDTO>> listarPorCalorias(@RequestParam Integer max) {
        return ResponseEntity.ok(service.listarPorCalorias(max));
    }

    @PostMapping
    public ResponseEntity<PratoResponseDTO> criar(@Valid @RequestBody PratoRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PratoResponseDTO> atualizar(@PathVariable Long id,
                                                    @Valid @RequestBody PratoRequestDTO dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @PatchMapping("/{id}/valor")
    public ResponseEntity<PratoResponseDTO> atualizarValor(@PathVariable Long id,
                                                          @Valid @RequestBody PratoValorRequestDTO dto) {
        return ResponseEntity.ok(service.atualizarValor(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        service.remover(id);
        return ResponseEntity.noContent().build();
    }
}