package com.example.forohub.domain.respuesta;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;

public record DatosRespuesta(
        @NotNull
        Long id,
        @NotBlank
        String mensaje,
        @NotNull
        Long autorId,
        @NotNull
        Long topicoId
) {
}
