package com.example.forohub.domain.respuesta;

import jakarta.validation.constraints.NotNull;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class DatosListaRespuestasModelAssembler implements RepresentationModelAssembler<DatosListaRespuesta, EntityModel<DatosListaRespuesta>>{
    @Override
    @NotNull
    public EntityModel<DatosListaRespuesta> toModel(@NotNull DatosListaRespuesta datos) {
        return EntityModel.of(datos);
    }
}
