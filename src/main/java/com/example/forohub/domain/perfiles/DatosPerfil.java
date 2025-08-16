package com.example.forohub.domain.perfiles;

import jakarta.validation.constraints.NotBlank;

public record DatosPerfil(
        Long id,
        String nombre
) {
}
