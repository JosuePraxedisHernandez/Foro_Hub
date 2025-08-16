package com.example.forohub.controller;

import com.example.forohub.repository.UsuarioRepository;
import com.example.forohub.domain.respuesta.*;
import com.example.forohub.domain.topicos.*;
import com.example.forohub.domain.usuarios.Usuario;
import com.example.forohub.repository.RespuestaRepository;
import com.example.forohub.repository.TopicoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/respuestas")
public class RespuestaController {
    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PagedResourcesAssembler<DatosListaRespuesta> pagedResourcesAssembler;

    @Autowired
    private DatosListaRespuestasModelAssembler datosListaRespuestasModelAssembler;

    @Autowired
    RespuestaRepository respuestaRepository;

    @Transactional
    @PostMapping
    public ResponseEntity crearRespuesta(@RequestBody @Valid DatosRespuesta datos, UriComponentsBuilder uriBuilder) {
        System.out.println("Obtonenemos los datos de la respuesta: " + datos);
        Usuario autor = usuarioRepository.findById(datos.autorId())
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado con ID: " + datos.autorId()));

        Topico topico = topicoRepository.findById(datos.topicoId())
                .orElseThrow(() -> new EntityNotFoundException("Topico no encontrado con ID: " + datos.topicoId()));
        var respuesta = new Respuesta(datos,autor,topico);

        respuestaRepository.save(respuesta);

        var uri = uriBuilder.path("/respuestas/{id}")
                .buildAndExpand(respuesta.getId())
                .toUri();

        return ResponseEntity.created(uri).body(new DatosDetalleRespuesta(respuesta));
    }
    @GetMapping
    public PagedModel<EntityModel<DatosListaRespuesta>> listarRespuess(@PageableDefault(size = 10, sort = {"fechaCreacion"}, direction = Sort.Direction.ASC) Pageable paginacion){
        Page<DatosListaRespuesta> pagina = respuestaRepository.findAllByStatusTrue(paginacion).map(DatosListaRespuesta::new);
        return pagedResourcesAssembler.toModel(pagina,datosListaRespuestasModelAssembler);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity eliminarRespuesta(@PathVariable Long id) {
        var respuesta = respuestaRepository.getReferenceById(id);
        respuesta.desactivarTopico();
        return ResponseEntity.noContent().build();
    }

}
