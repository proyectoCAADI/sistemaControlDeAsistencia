-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema CaadiIntegrada
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema CaadiIntegrada
-- -----------------------------------------------------
drop  schema if exists `CaadiIntegrada`;
CREATE SCHEMA IF NOT EXISTS `CaadiIntegrada` DEFAULT CHARACTER SET utf8 ;
USE `CaadiIntegrada` ;

-- -----------------------------------------------------
-- Table `CaadiIntegrada`.`Periods`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CaadiIntegrada`.`Periods` (
  `id` INT(11) NOT NULL,
  `start` DATETIME NOT NULL,
  `end` DATETIME NOT NULL,
  `description` VARCHAR(300) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `CaadiIntegrada`.`Teachers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CaadiIntegrada`.`Teachers` (
  `employeeNumber` VARCHAR(10) NOT NULL,
  `firstLastName` VARCHAR(100) NOT NULL,
  `secondLastName` VARCHAR(100) NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `gender` VARCHAR(10) NOT NULL,
  `email` VARCHAR(500) NULL DEFAULT NULL,
  PRIMARY KEY (`employeeNumber`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `CaadiIntegrada`.`Groups`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CaadiIntegrada`.`Groups` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `periodId` INT(11) NOT NULL,
  `employeeNumber` VARCHAR(10) NOT NULL,
  `learningUnit` VARCHAR(500) NOT NULL,
  `level` VARCHAR(10) NOT NULL,
  `identifier` VARCHAR(5) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `Groups_Periods_FK_idx` (`periodId` ASC),
  INDEX `Groups_Teachers_FK_idx` (`employeeNumber` ASC),
  CONSTRAINT `Groups_Periods_FK`
    FOREIGN KEY (`periodId`)
    REFERENCES `CaadiIntegrada`.`Periods` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `Groups_Teachers_FK`
    FOREIGN KEY (`employeeNumber`)
    REFERENCES `CaadiIntegrada`.`Teachers` (`employeeNumber`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `CaadiIntegrada`.`Students`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CaadiIntegrada`.`Students` (
  `nua` VARCHAR(10) NOT NULL,
  `firstLastName` VARCHAR(100) NOT NULL,
  `secondLastName` VARCHAR(100) NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `gender` VARCHAR(10) NOT NULL,
  `birthday` DATETIME NULL DEFAULT NULL,
  `program` VARCHAR(500) NULL DEFAULT NULL,
  `email` VARCHAR(500) NULL DEFAULT NULL,
  PRIMARY KEY (`nua`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `CaadiIntegrada`.`GroupMembers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CaadiIntegrada`.`GroupMembers` (
  `groupId` INT(11) NOT NULL,
  `nua` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`groupId`, `nua`),
  INDEX `GroupMember_Student_FK_idx` (`nua` ASC),
  CONSTRAINT `GroupMember_Group_FK`
    FOREIGN KEY (`groupId`)
    REFERENCES `CaadiIntegrada`.`Groups` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `GroupMember_Student_FK`
    FOREIGN KEY (`nua`)
    REFERENCES `CaadiIntegrada`.`Students` (`nua`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `CaadiIntegrada`.`Visit`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CaadiIntegrada`.`Visit` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `periodId` INT(11) NOT NULL,
  `nua` VARCHAR(10) NOT NULL,
  `skill` VARCHAR(40) NULL DEFAULT NULL,
  `start` DATETIME NOT NULL,
  `end` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `Visit_Students_FK_idx` (`nua` ASC),
  INDEX `Visit_Period_FK_idx` (`periodId` ASC),
  CONSTRAINT `Visit_Period_FK`
    FOREIGN KEY (`periodId`)
    REFERENCES `CaadiIntegrada`.`Periods` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `Visit_Students_FK`
    FOREIGN KEY (`nua`)
    REFERENCES `CaadiIntegrada`.`Students` (`nua`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 25
DEFAULT CHARACTER SET = utf8;
-- -------------------------
-- Union de la base de datos - Inventario
-- -------------------------
create table estatus
(
	id_estatus int auto_increment not null,
    estatus varchar(20) not null,
    primary key(id_estatus)
);



create table habilidad
(
	id_habilidad int auto_increment not null,
    nombre_habilidad varchar(20) not null,
    primary key(id_habilidad)
);

create table material_apoyo
(
	id_material int auto_increment not null,
    nombre_material varchar(100) not null,
    primary key(id_material)
);

create table nivel
(
	id_nivel int auto_increment not null,
    nivel varchar(2) not null,
    primary key(id_nivel)
);

create table autor_actividad
(
	id_autor int auto_increment not null,
	nua int(6) not null,
    primary key(id_autor)
);

insert into autor_actividad(nua) values(909090);
insert into autor_actividad(nua) values(909490);
insert into autor_actividad(nua) values(923090);

create table idioma
(
	id_idioma int auto_increment not null,
    idioma varchar(20) not null,
    primary key(id_idioma)
);

insert into idioma(idioma) values("English");
insert into idioma(idioma) values("French");
insert into idioma(idioma) values("German");

create table rating
(
	id_rating int auto_increment not null,
    rating int(1) not null,
    primary key(id_rating)
);

create table hoja_trabajo
(
	id_hoja int auto_increment,
    duracion_hoja int not null,
    nombre_hoja varchar(100) not null,
    fecha date not null,
    id_estatus int default 1 ,
    id_habilidad int not null,
    id_material int not null,
    id_nivel int not null,
    id_autor int not null,
    id_idioma int not null,
    id_rating int default 1,
	primary key(id_hoja),
    foreign key(id_estatus) references estatus(id_estatus),
    foreign key(id_habilidad) references habilidad(id_habilidad),
    foreign key(id_material) references material_apoyo(id_material),
    foreign key(id_nivel) references nivel(id_nivel),
    foreign key(id_autor) references autor_actividad(id_autor),
    foreign key(id_idioma) references idioma(id_idioma),
    foreign key(id_rating) references rating(id_rating)
);

create table juego
(
	id_juego int auto_increment not null,
    nombre_juego varchar(100) not null,
    instruccion varchar(100) not null,
    unidad int not null,
    duracion int(3) not null,
    fecha date not null,
    id_estatus int default 1,
    id_nivel int not null,
    id_autor int not null,
    id_idioma int not null,
    id_rating int default 1,
    id_habilidad int not null,
    primary key(id_juego),
    foreign key(id_estatus) references estatus(id_estatus),
    foreign key(id_habilidad) references habilidad(id_habilidad),
	foreign key(id_nivel) references nivel(id_nivel),
    foreign key(id_autor) references autor_actividad(id_autor),
    foreign key(id_idioma) references idioma(id_idioma),
    foreign key(id_rating) references rating(id_rating)
);

create table subtitulo
(
	id_subtitulo int auto_increment not null,
    idioma_subtitulo varchar(20) not null,
    primary key(id_subtitulo)
);
insert into subtitulo(idioma_subtitulo) values("English");
insert into subtitulo(idioma_subtitulo) values("French");
insert into subtitulo(idioma_subtitulo) values("German");

create table actor
(
	id_actor int auto_increment not null,
    nombre_actor varchar(20) not null,
    apellido_actor varchar(20) not null,
    primary key(id_actor)
);
insert into actor(nombre_actor,apellido_actor) values("nico","chavez");	
create table genero
(
	id_genero int auto_increment not null,
    genero varchar(20) not null,
    primary key(id_genero)
);
insert into genero(genero) values("Horror");
insert into genero(genero) values("Scify");


create table pelicula
(
	id_pelicula int auto_increment ,
    titulo_pelicula varchar(100) not null,
    duracion_pelicula int(3) not null,
    back_cover varchar(100),
    front_cover varchar(100),
    id_idioma int not null,
    id_subtitulo int not null,
    id_actor int not null,
    id_rating int default 1,
    id_genero int not null,
    primary key(id_pelicula),
    foreign key(id_idioma) references idioma(id_idioma),
    foreign key(id_subtitulo) references subtitulo(id_subtitulo),
    foreign key(id_actor) references actor(id_actor),
    foreign key(id_rating) references rating(id_rating),
    foreign key(id_genero) references genero(id_genero)
);

create table editorial
(
	id_editorial int auto_increment not null,
    nombre_editorial varchar(100) not null,
    direccion varchar(100) not null,
    primary key(id_editorial)
);
insert into editorial(nombre_editorial, direccion) values("Sigma", "Av. Siempre Viva 43");
insert into editorial(nombre_editorial, direccion) values("Watson", "Av. Flower 34");

create table revista
(
	id_revista int auto_increment not null,
    titulo_revista varchar(100) not null,
    nombre_revista varchar(100) not null,
    fecha varchar(20) not null,
    id_rating int default 1,
    id_estado varchar(100) not null,
    id_editorial int not null,
    primary key(id_revista),
    foreign key(id_rating) references rating(id_rating),
    foreign key(id_editorial) references editorial(id_editorial)
);
alter table revista modify column nombre_revista varchar(101) not null;

create table autor_libro
(
	id_libro bigint not null,
    id_autor int not null,
    foreign key(id_libro)references libro(id_libro),
    foreign key (id_autor) references autor(id_autor)
);

create table autor(
	id_autor int auto_increment primary key,
    nombre_autorlibro varchar(20) not null,
    apellido_autorlibro varchar(20) not null

);


create table tipo_libro(
	id_tipo_libro int auto_increment primary key,
    tipo_libro varchar(100) not null
);

insert into tipo_libro(tipo_libro) values("Answers");
insert into tipo_libro(tipo_libro) values("Theory");



create table area_libro(
	id_area_libro int auto_increment primary key,
    area_libro varchar(100) not null
);

insert into area_libro(area_libro) values("Listening");
insert into area_libro(area_libro) values("Writing");

create table libro
(
	id_libro bigint not null,
    isbn int(13),
    cantidad int not null,
    id_area_libro int not null,
    año_publicacion varchar(20) not null,
    titulo_libro varchar(100) not null,
    id_tipo_libro int not null,
    audio_libro boolean not null,
    id_rating int default 1,
    id_editorial int not null,
    id_idioma int not null,
    id_nivel int not null,
    #id_autorlibro int not null,
    primary key(id_libro),
    foreign key(id_tipo_libro) references tipo_libro(id_tipo_libro),
    foreign key(id_rating) references rating(id_rating),
    foreign key(id_area_libro) references area_libro(id_area_libro),
    foreign key(id_idioma) references idioma(id_idioma),
    foreign key(id_nivel) references nivel(id_nivel),
    #foreign key(id_autorlibro) references autor_libro(id_autorlibro),
    foreign key(id_editorial) references editorial(id_editorial)
);

create table registro_libro(
	id_registro int auto_increment primary key,
    cod_bar bigint(20) not null,
    id_visita int(11) not null,
    foreign key(id_visita) references `CaadiIntegrada`.`Visit`(`id`),
    foreign key(cod_bar) references libro(id_libro)
);



# modificaciones nico

alter table autor_actividad auto_increment=100;
alter table material_apoyo auto_increment=1;
alter table hoja_trabajo auto_increment=1;
alter table habilidad auto_increment=1;
alter table estatus auto_increment=1;
alter table idioma auto_increment=1;
alter table rating auto_increment=1;
alter table nivel auto_increment=1;

insert into habilidad(nombre_habilidad) values('speaking');
insert into habilidad(nombre_habilidad) values('writing');
insert into habilidad(nombre_habilidad) values('listening');

insert into idioma(idioma) values('ingles');
insert into idioma(idioma) values('frances');
insert into idioma(idioma) values('italiano');

insert into estatus(estatus) values('requesting');
insert into estatus(estatus) values('accepted');
insert into estatus(estatus) values('rejected');

insert into material_apoyo(nombre_material) values('no material');
insert into material_apoyo(nombre_material) values('cd');
insert into material_apoyo(nombre_material) values('dvd');

insert into rating(rating) values(0);
insert into rating(rating) values(1);
insert into rating(rating) values(2);
insert into rating(rating) values(3);
insert into rating(rating) values(4);
insert into rating(rating) values(5);

insert into nivel(nivel) values('1');
insert into nivel(nivel) values('2');
insert into nivel(nivel) values('3');
insert into nivel(nivel) values('4');
insert into nivel(nivel) values('5');
insert into nivel(nivel) values('6');
insert into nivel(nivel) values('7');
insert into nivel(nivel) values('8');

insert into autor_actividad(nua) values('810320');
insert into autor_actividad(nua) values('810228');
insert into autor_actividad(nua) values('810621');


-- Fin de la union inventario




SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
