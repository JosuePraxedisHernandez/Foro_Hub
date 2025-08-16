package com.example.forohub.domain.respuesta;

import com.example.forohub.domain.topicos.Topico;
import com.example.forohub.domain.usuarios.Usuario;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "respuestas")
@Entity(name = "Respuesta")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of="id")
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mensaje;

    private LocalDateTime fechaCreacion;

    @ManyToOne
    @JoinColumn(name = "autor_id",nullable = false)
    private Usuario autor;

    @ManyToOne
    @JoinColumn(name = "topico_id",nullable = false)
    private Topico topico;

    private boolean status;

    public Respuesta(@Valid DatosRespuesta datos, Usuario autor, Topico topico) {
        this.id = null;
        this.mensaje = datos.mensaje();
        this.fechaCreacion = LocalDateTime.now();
        this.autor = autor;
        this.topico = topico;
        this.status = true;
    }

    public void desactivarTopico() {
        this.status = false;
    }
}
