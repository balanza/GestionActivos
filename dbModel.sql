CREATE TABLE Aplicacion (
       id_aplicacion INT NOT NULL  PRIMARY KEY
     , nombre CHAR(255)
     , version CHAR(10)
);

CREATE TABLE SistemaOperativo (
       id_sistema_operativo INT NOT NULL  PRIMARY KEY
     , nombre CHAR(100)
     , version CHAR(10)
     , description CHAR(255)
);

CREATE TABLE Empresa (
       id_empresa INT NOT NULL  PRIMARY KEY
     , nombre CHAR(100)
     , direccion CHAR(100)
     , telefono CHAR(12)
     , email CHAR(100)
     , poblacion CHAR(100)
);

CREATE TABLE Departamento (
       codigo INT NOT NULL  PRIMARY KEY
     , nombre CHAR(100)
);

CREATE TABLE PersonaContacto (
       id_persona_contacto INT NOT NULL
     , nombre CHAR(100)
     , telefono CHAR(12)
     , PRIMARY KEY (id_persona_contacto)
);

CREATE TABLE Prioridad (
       id_prioridad CHAR(10) NOT NULL  PRIMARY KEY
     , nombre CHAR(20)
     , numInventario INT NOT NULL
);

CREATE TABLE DiscoMaster (
       id_disco_master INT NOT NULL  PRIMARY KEY
     , description CHAR(255)
);

CREATE TABLE Dispositivo (
       numInventario INT NOT NULL  PRIMARY KEY
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
     , numSecuencia INT NOT NULL
     , personacontacto_id_persona_contacto INT NOT NULL
     , id_prioridad CHAR(10) NOT NULL
);

CREATE TABLE ConfiguracionTipo (
       id_configuracion_tipo INT NOT NULL  PRIMARY KEY
     , marca CHAR(100)
     , modelo CHAR(100)
     , ram INT
     , procesador CHAR(100)
     , id_disco_master INT NOT NULL
);

CREATE TABLE AplicationesDefault (
       id_aplicacion INT NOT NULL
     , id_disco_master INT NOT NULL
     , PRIMARY KEY (id_aplicacion, id_disco_master)
);

CREATE TABLE Accion (
       numSecuencia INT NOT NULL  PRIMARY KEY
     , numInventario INT NOT NULL PRIMARY KEY
     , fechaAccion INT
     , description CHAR(255)
);

CREATE TABLE Ordenador (
       numInventario INT NOT NULL
     , id_configuracion_tipo INT NOT NULL
     , PRIMARY KEY (numInventario)
);

CREATE TABLE Instalacion (
       numInventario INT NOT NULL
     , fechaInstalacion INT
     , id_aplicacion INT NOT NULL
     , PRIMARY KEY (numInventario)
);

CREATE TABLE SistemasOperativosDefault (
       id_sistema_operativo INT NOT NULL
     , id_disco_master INT NOT NULL
);

CREATE TABLE Baja (
       fechaBaja INT
     , numSecuencia INT NOT NULL
     , numInventario INT NOT NULL
);

CREATE TABLE Ampliacion (
       nuevoProcesador CHAR(10)
     , nuevaRAM INT
     , numSecuencia INT NOT NULL
     , numInventario INT NOT NULL
     , PRIMARY KEY (numSecuencia, numInventario)
);

CREATE TABLE CambioDestino (
       nuevaIP CHAR(15)
     , nuevaPrioridad INT
     , numSecuencia INT NOT NULL
     , numInventario INT NOT NULL
     , id_persona_contacto INT NOT NULL
     , PRIMARY KEY (numSecuencia, numInventario)
);

CREATE TABLE Impresora (
       numInventario INT NOT NULL
     , marca CHAR(100)
     , modelo CHAR(100)
     , PRIMARY KEY (numInventario)
);

ALTER TABLE Dispositivo
  ADD CONSTRAINT FK_Dispositivo_1
      FOREIGN KEY (id_empresa)
      REFERENCES Empresa (id_empresa);

ALTER TABLE Dispositivo
  ADD CONSTRAINT FK_Dispositivo_2
      FOREIGN KEY (codigo)
      REFERENCES Departamento (codigo);

ALTER TABLE Dispositivo
  ADD CONSTRAINT FK_Dispositivo_3
      FOREIGN KEY (id_persona_contacto)
      REFERENCES PersonaContacto (id_persona_contacto);

ALTER TABLE Dispositivo
  ADD CONSTRAINT FK_Dispositivo_4
      FOREIGN KEY (prioridad)
      REFERENCES Prioridad (id_prioridad);

ALTER TABLE ConfiguracionTipo
  ADD CONSTRAINT FK_ConfiguracionTipo_1
      FOREIGN KEY (id_disco_master)
      REFERENCES DiscoMaster (id_disco_master);

ALTER TABLE AplicationesDefault
  ADD CONSTRAINT FK_AplicationesDefault_1
      FOREIGN KEY (id_aplicacion)
      REFERENCES Aplicacion (id_aplicacion);

ALTER TABLE AplicationesDefault
  ADD CONSTRAINT FK_AplicationesDefault_2
      FOREIGN KEY (id_aplicacion, id_disco_master)
      REFERENCES AplicationesDefault (id_aplicacion, id_disco_master);

ALTER TABLE AplicationesDefault
  ADD CONSTRAINT FK_AplicationesDefault_3
      FOREIGN KEY (id_disco_master)
      REFERENCES DiscoMaster (id_disco_master);

ALTER TABLE Accion
  ADD CONSTRAINT FK_Accion_1
      FOREIGN KEY (numInventario)
      REFERENCES Dispositivo (numInventario)
   ON DELETE CASCADE;




ALTER TABLE Ordenador
  ADD CONSTRAINT FK_Ordenador_5
      FOREIGN KEY (id_configuracion_tipo)
      REFERENCES ConfiguracionTipo (id_configuracion_tipo);

ALTER TABLE Ordenador
  ADD CONSTRAINT FK_Ordenador_1
      FOREIGN KEY (numInventario)
      REFERENCES Dispositivo (numInventario)
   ON DELETE CASCADE;

ALTER TABLE Instalacion
  ADD CONSTRAINT FK_Instalacion_2
      FOREIGN KEY (id_aplicacion)
      REFERENCES Aplicacion (id_aplicacion);

ALTER TABLE Instalacion
  ADD CONSTRAINT FK_Instalacion_3
      FOREIGN KEY (numInventario)
      REFERENCES Ordenador (numInventario);

ALTER TABLE SistemasOperativosDefault
  ADD CONSTRAINT FK_SistemasOperativosDefault_1
      FOREIGN KEY (id_sistema_operativo)
      REFERENCES SistemaOperativo (id_sistema_operativo);

ALTER TABLE SistemasOperativosDefault
  ADD CONSTRAINT FK_SistemasOperativosDefault_2
      FOREIGN KEY (id_disco_master)
      REFERENCES DiscoMaster (id_disco_master);

ALTER TABLE Baja
  ADD CONSTRAINT FK_Baja_1
      FOREIGN KEY (numSecuencia, numInventario)
      REFERENCES Accion (numSecuencia, numInventario)
   ON DELETE CASCADE;

ALTER TABLE Ampliacion
  ADD CONSTRAINT FK_Ampliacion_1
      FOREIGN KEY (numSecuencia, numInventario)
      REFERENCES Accion (numSecuencia, numInventario)
   ON DELETE CASCADE;

ALTER TABLE CambioDestino
  ADD CONSTRAINT FK_CambioDestino_1
      FOREIGN KEY (numSecuencia, numInventario)
      REFERENCES Accion (numSecuencia, numInventario)
   ON DELETE CASCADE;

ALTER TABLE CambioDestino
  ADD CONSTRAINT FK_CambioDestino_2
      FOREIGN KEY (id_persona_contacto)
      REFERENCES PersonaContacto (id_persona_contacto);

ALTER TABLE CambioDestino
  ADD CONSTRAINT FK_CambioDestino_3
      FOREIGN KEY (nuevaPrioridad)
      REFERENCES Prioridad (id_prioridad);

ALTER TABLE Impresora
  ADD CONSTRAINT FK_Impresora_1
      FOREIGN KEY (numInventario)
      REFERENCES Dispositivo (numInventario)
   ON DELETE CASCADE;

