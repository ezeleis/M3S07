package com.example.M3S07.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class MedicoDTO {
    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @NotBlank(message = "O medico deve ter uma expecialidade")
    private String especialidade;

    @NotBlank(message = "O e-mail é obrigatório")
    private String email;

    @NotBlank(message = "O telefone é obrigatório")
    private String telefone;

    @NotBlank(message = "O CRM é obrigatório")
    private String crm;
}
