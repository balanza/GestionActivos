CREATE TABLE Empresa (
       id_empresa INT NOT NULL PRIMARY KEY
     , nombre CHAR(100)
     , direccion CHAR(100)
     , telefono CHAR(12)
     , email CHAR(100)
     , poblacion CHAR(100)
);

CREATE TABLE Departamento (
       codigo INT NOT NULL PRIMARY KEY
     , nombre CHAR(100)
);

CREATE TABLE PersonaContacto (
       id_persona_contacto INT NOT NULL
     , nombre CHAR(100)
     , telefono CHAR(12)
     , PRIMARY KEY (id_persona_contacto)
);

CREATE TABLE Dispositivo (
       numInventario INT NOT NULL PRIMARY KEY
     , numSerie CHAR(5) NOT NULL
     , fechaInstalacion INT
     , fechaFinGarantia INT
     , fechaCompra INT
     , prioridad INT
     , ip CHAR(15)
     , observaciones VARCHAR(255)
     , precioCompra CHAR(10)
     , id_empresa INT NOT NULL
     , departamento_codigo INT NOT NULL
     , personacontacto_id_persona_contacto INT NOT NULL
     , id_prioridad CHAR(10) NOT NULL
);

CREATE TABLE Impresora (
       numInventario INT NOT NULL
     , marca CHAR(100)
     , modelo CHAR(100)
     , PRIMARY KEY (numInventario)
);

CREATE TABLE Ordenador (
       numInventario INT NOT NULL
     --, id_configuracion_tipo INT NOT NULL
     , PRIMARY KEY (numInventario)
);


CREATE TABLE Departamento (
       codigo INT NOT NULL PRIMARY KEY
     , nombre CHAR(100)
);
CREATE TABLE PersonaContacto (
       id_persona_contacto INT NOT NULL
     , nombre CHAR(100)
     , telefono CHAR(12)
     , PRIMARY KEY (id_persona_contacto)
);


ALTER TABLE Dispositivo
  ADD CONSTRAINT FK_Dispositivo_1
      FOREIGN KEY (id_empresa)
      REFERENCES Empresa (id_empresa)
   ON DELETE CASCADE;

ALTER TABLE Dispositivo
  ADD CONSTRAINT FK_Dispositivo_2
      FOREIGN KEY (departamento_codigo)
      REFERENCES Departamento (codigo)
   ON DELETE CASCADE;

ALTER TABLE Dispositivo
  ADD CONSTRAINT FK_Dispositivo_3
      FOREIGN KEY (personacontacto_id_persona_contacto)
      REFERENCES PersonaContacto (id_persona_contacto)
   ON DELETE CASCADE;
      
ALTER TABLE Ordenador
  ADD CONSTRAINT FK_Ordenador_1
      FOREIGN KEY (numInventario)
      REFERENCES Dispositivo (numInventario)
   ON DELETE CASCADE;
   
ALTER TABLE Impresora
  ADD CONSTRAINT FK_Impresora_1
      FOREIGN KEY (numInventario)
      REFERENCES Dispositivo (numInventario)
   ON DELETE CASCADE;
   
   
   --select * from empresa
--select * from departamento
--select * from personacontacto
--insert into dispositivo(numinventario, id_empresa, departamento_codigo, personacontacto_id_persona_contacto, numserie) values (10, 1, 1, 1, 'P1011')
--select * from dispositivo
delete from departamento

