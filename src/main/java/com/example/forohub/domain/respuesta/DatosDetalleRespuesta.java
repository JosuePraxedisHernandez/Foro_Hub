package com.example.forohub.domain.respuesta;

import com.example.forohub.domain.topicos.Topico;
import com.example.forohub.domain.usuarios.Usuario;

import java.time.LocalDateTime;

public record DatosDetalleRespuesta(
    Long id,
    String mensaje,
    LocalDateTime fechaCreacion,
    String autor,
    String topico) {

    public DatosDetalleRespuesta(Respuesta respuesta) {
            this(
                    respuesta.getId(),
                    respuesta.getMensaje(),
                    respuesta.getFechaCreacion(),
                    respuesta.getAutor().getId().toString(),
                    respuesta.getTopico().getId().toString()
            );

        }
}
