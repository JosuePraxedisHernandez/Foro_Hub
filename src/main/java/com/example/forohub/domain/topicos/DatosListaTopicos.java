package com.example.forohub.domain.topicos;

import java.time.LocalDateTime;

public record DatosListaTopicos(
        Long id,
        String nombre,
        String mensaje,
        LocalDateTime fecha_creacion,
        String curso,
        String nombre_autor
) {
    public DatosListaTopicos(Topico topico) {
        this(topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                String.valueOf(topico.getCurso()),
                topico.getNombre_autor()
        );
    }
}
