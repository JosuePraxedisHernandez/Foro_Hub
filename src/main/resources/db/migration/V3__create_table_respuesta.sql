create table respuestas (
    id bigint not null auto_increment,
    mensaje text not null,
    fecha_creacion datetime not null,
    id_autor int not null,
    id_topico int not null,
    status boolean not null default true,

    primary key (id),

    constraint fk_respuesta_autor foreign key (id_autor) references usuarios(id),
    constraint fk_respuesta_topico foreign key (id_topico) references topicos(id)
);