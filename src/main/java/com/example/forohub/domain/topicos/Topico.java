package com.example.forohub.domain.topicos;

import com.example.forohub.domain.cursos.Curso;
import com.example.forohub.domain.perfiles.Perfil;
import com.example.forohub.domain.respuesta.Respuesta;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name = "topicos")
@Entity(name = "Topico")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of="id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Perfil autor;
    private LocalDateTime fechaCreacion;
    private boolean status;
    @Enumerated(EnumType.STRING)
    private Curso curso;
    private String nombre_autor;

    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL)
    private List<Respuesta> respuestas = new ArrayList<>();


    public Topico(DatosTopicos datos,Perfil perfil) {
        this.titulo = datos.titulo();
        this.mensaje = datos.mensaje();
        this.autor = perfil;
        this.nombre_autor = perfil.getNombre();
        this.fechaCreacion = LocalDateTime.now();
        this.status = true;
        this.curso = datos.curso();
    }


    public void actualizarDatos(@Valid DatosActualizarTopico datos) {
        if (datos.titulo() != null) {
            this.titulo = datos.titulo();
        }
        if (datos.mensaje() != null) {
            this.mensaje = datos.mensaje();
        }
        if (datos.curso() != null) {
            this.curso = datos.curso();
        }
        if (datos.autor() != null) {
            this.autor.actualizarDatos(datos.autor());
        }
    }

    public void desactivarTopico() {
        this.status = false;
    }
}
