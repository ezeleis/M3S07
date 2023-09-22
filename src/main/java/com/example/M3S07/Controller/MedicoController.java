package com.example.M3S07.Controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.example.M3S07.DTO.MedicoDTO;
import com.example.M3S07.Service.MedicoService;
import org.springframework.http.ResponseEntity;


import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @GetMapping
    public List<MedicoDTO> listarMedicos() {
        return medicoService.listarMedicos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicoDTO> buscarMedicoPorId(@PathVariable Long id) {
        MedicoDTO medico = medicoService.buscarMedicoPorId(id);
        if (medico != null) {
            return ResponseEntity.ok(medico);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<MedicoDTO> adicionarMedico(@Valid @RequestBody MedicoDTO medicoDTO) {
        MedicoDTO novoMedico = medicoService.adicionarMedico(medicoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoMedico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicoDTO> atualizarMedico(
            @PathVariable Long id,
            @Valid @RequestBody MedicoDTO medicoDTO
    ) {
        MedicoDTO medicoAtualizado = medicoService.atualizarMedico(id, medicoDTO);
        if (medicoAtualizado != null) {
            return ResponseEntity.ok(medicoAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirMedico(@PathVariable Long id) {
        if (medicoService.excluirMedico(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
