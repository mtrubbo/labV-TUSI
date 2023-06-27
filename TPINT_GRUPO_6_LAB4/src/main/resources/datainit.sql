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

insert into articulos(descripcion, estado, marca, nombre, precio, tipo)
values('Es una remera blanca', 1, 1, 'Remera blanca', 3699.50, 1);
insert into articulos(descripcion, estado, marca, nombre, precio, tipo)
values('Es una remera negra', 1, 1, 'Remera negra', 4300, 1);

insert into ventas(estado, fecha, montoTotal, id_cliente)
values(1, '2022-01-01', 0, 1);

insert into ventas_articulos(venta_id, articulo_id)
values(1, 1);
insert into ventas_articulos(venta_id, articulo_id)
values(1, 2);