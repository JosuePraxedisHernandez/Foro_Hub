package com.example.forohub.domain.topicos;

import com.example.forohub.domain.cursos.Curso;
import com.example.forohub.domain.perfiles.DatosPerfil;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosTopicos(
        @NotNull
        Long id,
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @Valid
        DatosPerfil autor,
        @NotNull
        Curso curso
) {
}
