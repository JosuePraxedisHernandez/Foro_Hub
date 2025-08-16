package com.example.forohub.domain.respuesta;

import java.time.LocalDateTime;

public record DatosListaRespuesta(
        Long id,
        String mensaje,
        LocalDateTime fechaCreacion,
        String autorId,
        String topicoId
) {
    public DatosListaRespuesta(Respuesta respuesta) {
        this(respuesta.getId(),
                respuesta.getMensaje(),
                respuesta.getFechaCreacion(),
                respuesta.getAutor().getId().toString(),
                respuesta.getTopico().getId().toString()
        );
    }
}
