package com.example.forohub.domain.topicos;

import com.example.forohub.domain.cursos.Curso;
import com.example.forohub.domain.perfiles.DatosPerfil;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(
        @NotNull Long id,
        String titulo,
        String mensaje,
        Curso curso,
        DatosPerfil autor
) {
}
