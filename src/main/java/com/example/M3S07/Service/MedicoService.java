package com.example.M3S07.Service;

import com.example.M3S07.DTO.MedicoDTO;
import com.example.M3S07.Repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.M3S07.Model.Medico;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MedicoService {

    private final MedicoRepository medicoRepository;

    @Autowired
    public MedicoService(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    public List<MedicoDTO> listarMedicos() {
        List<Medico> medicos = medicoRepository.findAll();
        return medicos.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public MedicoDTO buscarMedicoPorId(Long id) {
        Optional<Medico> optionalMedico = medicoRepository.findById(id);
        if (optionalMedico.isPresent()) {
            return convertToDTO(optionalMedico.get());
        }
        return null; // Handle this better in a real application
    }

    public MedicoDTO adicionarMedico(MedicoDTO medicoDTO) {
        Medico medico = convertToEntity(medicoDTO);
        Medico savedMedico = medicoRepository.save(medico);
        return convertToDTO(savedMedico);
    }

    public MedicoDTO atualizarMedico(Long id, MedicoDTO medicoDTO) {
        Optional<Medico> optionalMedico = medicoRepository.findById(id);
        if (optionalMedico.isPresent()) {
            Medico medico = optionalMedico.get();
            // Update medico fields with data from medicoDTO
            medico.setNome(medicoDTO.getNome());
            medico.setEspecialidade(medicoDTO.getEspecialidade());
            // Save the updated medico
            Medico updatedMedico = medicoRepository.save(medico);
            return convertToDTO(updatedMedico);
        }
        return null; // Handle this better in a real application
    }

    public boolean excluirMedico(Long id) {
        medicoRepository.deleteById(id);
        return false;
    }

    private MedicoDTO convertToDTO(Medico medico) {
        MedicoDTO medicoDTO = new MedicoDTO();
        medicoDTO.setId(medico.getId());
        medicoDTO.setNome(medico.getNome());
        medicoDTO.setEspecialidade(medico.getEspecialidade());
        return medicoDTO;
    }

    private Medico convertToEntity(MedicoDTO medicoDTO) {
        Medico medico = new Medico();
        medico.setNome(medicoDTO.getNome());
        medico.setEspecialidade(medicoDTO.getEspecialidade());
        return medico;
    }
}
