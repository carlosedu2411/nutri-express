package br.com.nutriexpress.demo.controller;

import br.com.nutriexpress.demo.model.Prato;
import br.com.nutriexpress.demo.service.PratoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pratos")
public class PratoController {

    private final PratoService pratoService;

    public PratoController(PratoService pratoService) {
        this.pratoService = pratoService;
    }

    @GetMapping("/calorias")
    public List<Prato> buscarPorCalorias(
            @RequestParam(required = false, defaultValue = "500") Integer max) {

        return pratoService.buscarPorCalorias(max);
    }

    @PatchMapping("/{id}/valor")
    public Prato atualizarValor(@PathVariable Long id, @RequestBody Map<String, Double> body) {
        Double valor = body.get("valor");
        if (valor == null) {
            throw new IllegalArgumentException("Campo 'valor' é obrigatório");
        }
        return pratoService.atualizarValor(id, valor);
    }
}
