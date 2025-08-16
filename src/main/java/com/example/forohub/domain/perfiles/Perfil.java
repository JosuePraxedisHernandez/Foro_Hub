package com.example.forohub.domain.perfiles;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "perfiles")
@Entity(name = "Perfil")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre_completo", nullable = false)
    private String nombre;


    public Perfil(DatosPerfil datos) {
        this.nombre = datos.nombre();
    }

    public void actualizarDatos(@Valid DatosPerfil autor) {
        if (autor.nombre() != null) {
            this.nombre = autor.nombre();
        }
    }
}
