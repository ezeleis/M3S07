package com.example.M3S07.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.M3S07.DTO.MedicoDTO;
import com.example.M3S07.Service.MedicoService;

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
    public MedicoDTO buscarMedicoPorId(@PathVariable Long id) {
        return medicoService.buscarMedicoPorId(id);
    }

    @PostMapping
    public MedicoDTO adicionarMedico(@RequestBody MedicoDTO medicoDTO) {
        return medicoService.adicionarMedico(medicoDTO);
    }

    @PutMapping("/{id}")
    public MedicoDTO atualizarMedico(@PathVariable Long id, @RequestBody MedicoDTO medicoDTO) {
        return medicoService.atualizarMedico(id, medicoDTO);
    }

    @DeleteMapping("/{id}")
    public void excluirMedico(@PathVariable Long id) {
        medicoService.excluirMedico(id);
    }
}
