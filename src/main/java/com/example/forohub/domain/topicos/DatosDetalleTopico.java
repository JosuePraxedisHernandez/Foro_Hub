package com.example.forohub.domain.topicos;

import com.example.forohub.domain.perfiles.Perfil;

import java.time.LocalDateTime;

public record DatosDetalleTopico(
        Long id,
        String titulo,
        String mensaje,
        Perfil autor,
        LocalDateTime fechaCreacion,
        String curso
) {
    public DatosDetalleTopico(Topico topico) {
        this(topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getAutor(),
                topico.getFechaCreacion(),
                String.valueOf(topico.getCurso())
        );
    }
}
