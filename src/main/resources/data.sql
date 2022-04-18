
INSERT INTO odontologo (nombre,apellido,matricula) VALUES ('angel','estrada','123456789');
INSERT INTO odontologo (nombre,apellido,matricula) VALUES ('jesus','anaya','987654321');
INSERT INTO odontologo (nombre,apellido,matricula) VALUES ('jose','maria','678954321');

INSERT INTO domicilio (calle,numero,localidad,provincia) VALUES ('183','45-4','locali1','nose1');
INSERT INTO domicilio (calle,numero,localidad,provincia) VALUES ('54','120-8','locali2','nose2');
INSERT INTO domicilio (calle,numero,localidad,provincia) VALUES ('98','23-87','locali3','nose3');

INSERT INTO paciente (apellido,nombre,dni,fecha_ingreso,domicilio_id) VALUES ('acuña','mario','67897678','2022-10-24',1);
INSERT INTO paciente (apellido,nombre,dni,fecha_ingreso,domicilio_id) VALUES ('perez','rafa','890789067','2022-10-24',2);
INSERT INTO paciente (apellido,nombre,dni,fecha_ingreso,domicilio_id) VALUES ('gomez','juan','23456456','2022-10-24',3);

INSERT INTO turno (odontologo_id,paciente_id,fecha,hora) VALUES (1,1,'2022-10-24',' 02:30:00');
INSERT INTO turno (odontologo_id,paciente_id,fecha,hora) VALUES (1,2,'2022-10-24',' 02:30:00');
INSERT INTO turno (odontologo_id,paciente_id,fecha,hora) VALUES (1,3,'2022-10-24 ','02:30:00');
INSERT INTO turno (odontologo_id,paciente_id,fecha,hora) VALUES (2,1,'2022-10-24', '02:30:00');
INSERT INTO turno (odontologo_id,paciente_id,fecha,hora) VALUES (2,2,'2022-10-24',' 02:30:00');
INSERT INTO turno (odontologo_id,paciente_id,fecha,hora) VALUES (2,3,'2022-10-24', '02:30:00');
INSERT INTO turno (odontologo_id,paciente_id,fecha,hora) VALUES (3,1,'2022-10-24', '02:30:00');
INSERT INTO turno (odontologo_id,paciente_id,fecha,hora) VALUES (3,2,'2022-10-24', '02:30:00');
INSERT INTO turno (odontologo_id,paciente_id,fecha,hora) VALUES (3,3,'2022-10-24',' 02:30:00');

INSERT INTO perfil (nombre) VALUES ('PACI');
INSERT INTO perfil (nombre) VALUES ('ODO');
INSERT INTO perfil (nombre) VALUES ('ADMIN');
