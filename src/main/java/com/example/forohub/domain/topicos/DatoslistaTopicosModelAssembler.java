package com.example.forohub.domain.topicos;

import lombok.NonNull;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class DatoslistaTopicosModelAssembler implements RepresentationModelAssembler<DatosListaTopicos, EntityModel<DatosListaTopicos>>{
    @Override
    public EntityModel<DatosListaTopicos> toModel(@NonNull DatosListaTopicos datos) {
        return EntityModel.of(datos);
    }
}
