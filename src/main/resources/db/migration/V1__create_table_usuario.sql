create table usuarios(
    id int not null auto_increment,
    nombre varchar(80) not null,
    email varchar(100) not null,
    contrasena varchar(255) not null,
    id_perfil int not nulL,

    primary key(id),
    constraint fk_usuario_perfil foreign key(id_perfil) references perfiles(id)
);