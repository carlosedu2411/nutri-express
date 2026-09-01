package br.com.nutriexpress.demo.service;

import br.com.nutriexpress.demo.exception.ResourceNotFoundException;
import br.com.nutriexpress.demo.model.Prato;
import br.com.nutriexpress.demo.repository.PratoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PratoService {

    private final PratoRepository pratoRepository;

    public PratoService(PratoRepository pratoRepository) {
        this.pratoRepository = pratoRepository;
    }

    public List<Prato> buscarPorCalorias(Integer max) {
        return pratoRepository.findByCaloriasLessThanEqual(max);
    }

    public Prato atualizarValor(Long id, Double valor) {
        Prato prato = pratoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Prato não encontrado"));
        prato.setPreco(valor);
        return pratoRepository.save(prato);
    }
}