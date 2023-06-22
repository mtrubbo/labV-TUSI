use tp_integrador

insert into roles_usuario(descripcion) values ("contador");
insert into roles_usuario(descripcion) values ("vendedor");
insert into usuarios(contrasena, nombrePublico, nombreUsuario, id_rol)
values ("contador", "Contador", "contador", 1);
insert into usuarios(contrasena, nombrePublico, nombreUsuario, id_rol)
values ("vendedor", "Vendedor", "vendedor", 2);

insert into marcas(nombre)
values('Nike')

insert into tipoarticulos(descripcion)
values('Indumentaria')