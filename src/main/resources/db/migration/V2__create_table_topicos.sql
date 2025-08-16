create table topicos(
    id int not null auto_increment,
    titulo varchar(100) not null unique,
    mensaje text not null,
    fecha_creacion datetime not null,
    status varchar(20) not null,
    nombre_autor varchar(100) not null,
    curso varchar(100) not null,
    id_usuario int not null,
    primary key (id),
    constraint fk_topico_usuario  foreign key(id_usuario) references usuarios(id)
);