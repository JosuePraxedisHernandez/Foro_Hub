package com.example.forohub.repository;

import com.example.forohub.domain.respuesta.Respuesta;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import java.util.List;

public interface RespuestaRepository extends JpaRepository<Respuesta, Long> {
    List<Respuesta> findByTopicoId(Long topicId);

    Page<Respuesta> findAllByStatusTrue(Pageable paginacion);
}
