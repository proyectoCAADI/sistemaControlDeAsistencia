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
DROP DATABASE  IF EXISTS `CaadiIntegrada`;
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
-- Table `CaadiIntegrada`.`tipo_libro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CaadiIntegrada`.`tipo_libro` (
  `id_tipo_libro` INT(11) NOT NULL AUTO_INCREMENT,
  `tipo_libro` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id_tipo_libro`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `CaadiIntegrada`.`rating`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CaadiIntegrada`.`rating` (
  `id_rating` INT(11) NOT NULL AUTO_INCREMENT,
  `rating` INT(1) NOT NULL,
  PRIMARY KEY (`id_rating`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `CaadiIntegrada`.`area_libro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CaadiIntegrada`.`area_libro` (
  `id_area_libro` INT(11) NOT NULL AUTO_INCREMENT,
  `area_libro` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id_area_libro`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `CaadiIntegrada`.`idioma`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CaadiIntegrada`.`idioma` (
  `id_idioma` INT(11) NOT NULL AUTO_INCREMENT,
  `idioma` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id_idioma`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `CaadiIntegrada`.`nivel`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CaadiIntegrada`.`nivel` (
  `id_nivel` INT(11) NOT NULL AUTO_INCREMENT,
  `nivel` VARCHAR(2) NOT NULL,
  PRIMARY KEY (`id_nivel`))
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `CaadiIntegrada`.`editorial`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CaadiIntegrada`.`editorial` (
  `id_editorial` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre_editorial` VARCHAR(100) NOT NULL,
  `direccion` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id_editorial`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `CaadiIntegrada`.`libro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CaadiIntegrada`.`libro` (
  `id_libro` BIGINT(20) NOT NULL,
  `isbn` INT(13) NULL DEFAULT NULL,
  `cantidad` INT(11) NOT NULL,
  `id_area_libro` INT(11) NOT NULL,
  `año_publicacion` VARCHAR(20) NOT NULL,
  `titulo_libro` VARCHAR(100) NOT NULL,
  `id_tipo_libro` INT(11) NOT NULL,
  `audio_libro` TINYINT(1) NOT NULL,
  `id_rating` INT(11) NULL DEFAULT '1',
  `id_editorial` INT(11) NOT NULL,
  `id_idioma` INT(11) NOT NULL,
  `id_nivel` INT(11) NOT NULL,
  PRIMARY KEY (`id_libro`),
  INDEX `id_tipo_libro` (`id_tipo_libro` ASC),
  INDEX `id_rating` (`id_rating` ASC),
  INDEX `id_area_libro` (`id_area_libro` ASC),
  INDEX `id_idioma` (`id_idioma` ASC),
  INDEX `id_nivel` (`id_nivel` ASC),
  INDEX `id_editorial` (`id_editorial` ASC),
  CONSTRAINT `libro_ibfk_1`
    FOREIGN KEY (`id_tipo_libro`)
    REFERENCES `CaadiIntegrada`.`tipo_libro` (`id_tipo_libro`),
  CONSTRAINT `libro_ibfk_2`
    FOREIGN KEY (`id_rating`)
    REFERENCES `CaadiIntegrada`.`rating` (`id_rating`),
  CONSTRAINT `libro_ibfk_3`
    FOREIGN KEY (`id_area_libro`)
    REFERENCES `CaadiIntegrada`.`area_libro` (`id_area_libro`),
  CONSTRAINT `libro_ibfk_4`
    FOREIGN KEY (`id_idioma`)
    REFERENCES `CaadiIntegrada`.`idioma` (`id_idioma`),
  CONSTRAINT `libro_ibfk_5`
    FOREIGN KEY (`id_nivel`)
    REFERENCES `CaadiIntegrada`.`nivel` (`id_nivel`),
  CONSTRAINT `libro_ibfk_6`
    FOREIGN KEY (`id_editorial`)
    REFERENCES `CaadiIntegrada`.`editorial` (`id_editorial`))
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
  `libro_id_libro` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`, `libro_id_libro`),
  INDEX `Visit_Students_FK_idx` (`nua` ASC),
  INDEX `Visit_Period_FK_idx` (`periodId` ASC),
  INDEX `fk_Visit_libro1_idx` (`libro_id_libro` ASC),
  CONSTRAINT `Visit_Period_FK`
    FOREIGN KEY (`periodId`)
    REFERENCES `CaadiIntegrada`.`Periods` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `Visit_Students_FK`
    FOREIGN KEY (`nua`)
    REFERENCES `CaadiIntegrada`.`Students` (`nua`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Visit_libro1`
    FOREIGN KEY (`libro_id_libro`)
    REFERENCES `CaadiIntegrada`.`libro` (`id_libro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 25
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `CaadiIntegrada`.`actor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CaadiIntegrada`.`actor` (
  `id_actor` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre_actor` VARCHAR(20) NOT NULL,
  `apellido_actor` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id_actor`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `CaadiIntegrada`.`autor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CaadiIntegrada`.`autor` (
  `id_autor` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre_autorlibro` VARCHAR(20) NOT NULL,
  `apellido_autorlibro` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id_autor`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `CaadiIntegrada`.`autor_actividad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CaadiIntegrada`.`autor_actividad` (
  `id_autor` INT(11) NOT NULL AUTO_INCREMENT,
  `nua` INT(6) NOT NULL,
  PRIMARY KEY (`id_autor`))
ENGINE = InnoDB
AUTO_INCREMENT = 103
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `CaadiIntegrada`.`autor_libro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CaadiIntegrada`.`autor_libro` (
  `id_libro` BIGINT(20) NOT NULL,
  `id_autor` INT(11) NOT NULL,
  INDEX `id_libro` (`id_libro` ASC),
  INDEX `id_autor` (`id_autor` ASC),
  CONSTRAINT `autor_libro_ibfk_1`
    FOREIGN KEY (`id_libro`)
    REFERENCES `CaadiIntegrada`.`libro` (`id_libro`),
  CONSTRAINT `autor_libro_ibfk_2`
    FOREIGN KEY (`id_autor`)
    REFERENCES `CaadiIntegrada`.`autor` (`id_autor`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `CaadiIntegrada`.`estatus`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CaadiIntegrada`.`estatus` (
  `id_estatus` INT(11) NOT NULL AUTO_INCREMENT,
  `estatus` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id_estatus`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `CaadiIntegrada`.`genero`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CaadiIntegrada`.`genero` (
  `id_genero` INT(11) NOT NULL AUTO_INCREMENT,
  `genero` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id_genero`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `CaadiIntegrada`.`habilidad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CaadiIntegrada`.`habilidad` (
  `id_habilidad` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre_habilidad` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id_habilidad`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `CaadiIntegrada`.`material_apoyo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CaadiIntegrada`.`material_apoyo` (
  `id_material` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre_material` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id_material`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `CaadiIntegrada`.`hoja_trabajo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CaadiIntegrada`.`hoja_trabajo` (
  `id_hoja` INT(11) NOT NULL AUTO_INCREMENT,
  `duracion_hoja` INT(11) NOT NULL,
  `nombre_hoja` VARCHAR(100) NOT NULL,
  `fecha` DATE NOT NULL,
  `id_estatus` INT(11) NULL DEFAULT '1',
  `id_habilidad` INT(11) NOT NULL,
  `id_material` INT(11) NOT NULL,
  `id_nivel` INT(11) NOT NULL,
  `id_autor` INT(11) NOT NULL,
  `id_idioma` INT(11) NOT NULL,
  `id_rating` INT(11) NULL DEFAULT '1',
  PRIMARY KEY (`id_hoja`),
  INDEX `id_estatus` (`id_estatus` ASC),
  INDEX `id_habilidad` (`id_habilidad` ASC),
  INDEX `id_material` (`id_material` ASC),
  INDEX `id_nivel` (`id_nivel` ASC),
  INDEX `id_autor` (`id_autor` ASC),
  INDEX `id_idioma` (`id_idioma` ASC),
  INDEX `id_rating` (`id_rating` ASC),
  CONSTRAINT `hoja_trabajo_ibfk_1`
    FOREIGN KEY (`id_estatus`)
    REFERENCES `CaadiIntegrada`.`estatus` (`id_estatus`),
  CONSTRAINT `hoja_trabajo_ibfk_2`
    FOREIGN KEY (`id_habilidad`)
    REFERENCES `CaadiIntegrada`.`habilidad` (`id_habilidad`),
  CONSTRAINT `hoja_trabajo_ibfk_3`
    FOREIGN KEY (`id_material`)
    REFERENCES `CaadiIntegrada`.`material_apoyo` (`id_material`),
  CONSTRAINT `hoja_trabajo_ibfk_4`
    FOREIGN KEY (`id_nivel`)
    REFERENCES `CaadiIntegrada`.`nivel` (`id_nivel`),
  CONSTRAINT `hoja_trabajo_ibfk_5`
    FOREIGN KEY (`id_autor`)
    REFERENCES `CaadiIntegrada`.`autor_actividad` (`id_autor`),
  CONSTRAINT `hoja_trabajo_ibfk_6`
    FOREIGN KEY (`id_idioma`)
    REFERENCES `CaadiIntegrada`.`idioma` (`id_idioma`),
  CONSTRAINT `hoja_trabajo_ibfk_7`
    FOREIGN KEY (`id_rating`)
    REFERENCES `CaadiIntegrada`.`rating` (`id_rating`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `CaadiIntegrada`.`juego`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CaadiIntegrada`.`juego` (
  `id_juego` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre_juego` VARCHAR(100) NOT NULL,
  `instruccion` VARCHAR(100) NOT NULL,
  `unidad` INT(11) NOT NULL,
  `duracion` INT(3) NOT NULL,
  `fecha` DATE NOT NULL,
  `id_estatus` INT(11) NULL DEFAULT '1',
  `id_nivel` INT(11) NOT NULL,
  `id_autor` INT(11) NOT NULL,
  `id_idioma` INT(11) NOT NULL,
  `id_rating` INT(11) NULL DEFAULT '1',
  `id_habilidad` INT(11) NOT NULL,
  PRIMARY KEY (`id_juego`),
  INDEX `id_estatus` (`id_estatus` ASC),
  INDEX `id_habilidad` (`id_habilidad` ASC),
  INDEX `id_nivel` (`id_nivel` ASC),
  INDEX `id_autor` (`id_autor` ASC),
  INDEX `id_idioma` (`id_idioma` ASC),
  INDEX `id_rating` (`id_rating` ASC),
  CONSTRAINT `juego_ibfk_1`
    FOREIGN KEY (`id_estatus`)
    REFERENCES `CaadiIntegrada`.`estatus` (`id_estatus`),
  CONSTRAINT `juego_ibfk_2`
    FOREIGN KEY (`id_habilidad`)
    REFERENCES `CaadiIntegrada`.`habilidad` (`id_habilidad`),
  CONSTRAINT `juego_ibfk_3`
    FOREIGN KEY (`id_nivel`)
    REFERENCES `CaadiIntegrada`.`nivel` (`id_nivel`),
  CONSTRAINT `juego_ibfk_4`
    FOREIGN KEY (`id_autor`)
    REFERENCES `CaadiIntegrada`.`autor_actividad` (`id_autor`),
  CONSTRAINT `juego_ibfk_5`
    FOREIGN KEY (`id_idioma`)
    REFERENCES `CaadiIntegrada`.`idioma` (`id_idioma`),
  CONSTRAINT `juego_ibfk_6`
    FOREIGN KEY (`id_rating`)
    REFERENCES `CaadiIntegrada`.`rating` (`id_rating`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `CaadiIntegrada`.`subtitulo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CaadiIntegrada`.`subtitulo` (
  `id_subtitulo` INT(11) NOT NULL AUTO_INCREMENT,
  `idioma_subtitulo` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id_subtitulo`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `CaadiIntegrada`.`pelicula`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CaadiIntegrada`.`pelicula` (
  `id_pelicula` INT(11) NOT NULL AUTO_INCREMENT,
  `titulo_pelicula` VARCHAR(100) NOT NULL,
  `duracion_pelicula` INT(3) NOT NULL,
  `back_cover` VARCHAR(100) NULL DEFAULT NULL,
  `front_cover` VARCHAR(100) NULL DEFAULT NULL,
  `id_idioma` INT(11) NOT NULL,
  `id_subtitulo` INT(11) NOT NULL,
  `id_actor` INT(11) NOT NULL,
  `id_rating` INT(11) NULL DEFAULT '1',
  `id_genero` INT(11) NOT NULL,
  PRIMARY KEY (`id_pelicula`),
  INDEX `id_idioma` (`id_idioma` ASC),
  INDEX `id_subtitulo` (`id_subtitulo` ASC),
  INDEX `id_actor` (`id_actor` ASC),
  INDEX `id_rating` (`id_rating` ASC),
  INDEX `id_genero` (`id_genero` ASC),
  CONSTRAINT `pelicula_ibfk_1`
    FOREIGN KEY (`id_idioma`)
    REFERENCES `CaadiIntegrada`.`idioma` (`id_idioma`),
  CONSTRAINT `pelicula_ibfk_2`
    FOREIGN KEY (`id_subtitulo`)
    REFERENCES `CaadiIntegrada`.`subtitulo` (`id_subtitulo`),
  CONSTRAINT `pelicula_ibfk_3`
    FOREIGN KEY (`id_actor`)
    REFERENCES `CaadiIntegrada`.`actor` (`id_actor`),
  CONSTRAINT `pelicula_ibfk_4`
    FOREIGN KEY (`id_rating`)
    REFERENCES `CaadiIntegrada`.`rating` (`id_rating`),
  CONSTRAINT `pelicula_ibfk_5`
    FOREIGN KEY (`id_genero`)
    REFERENCES `CaadiIntegrada`.`genero` (`id_genero`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `CaadiIntegrada`.`registro_libro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CaadiIntegrada`.`registro_libro` (
  `id_registro` INT(11) NOT NULL AUTO_INCREMENT,
  `cod_bar` BIGINT(20) NOT NULL,
  `id_visita` INT(11) NOT NULL,
  PRIMARY KEY (`id_registro`),
  INDEX `id_visita` (`id_visita` ASC),
  INDEX `cod_bar` (`cod_bar` ASC),
  CONSTRAINT `registro_libro_ibfk_1`
    FOREIGN KEY (`id_visita`)
    REFERENCES `CaadiIntegrada`.`Visit` (`id`),
  CONSTRAINT `registro_libro_ibfk_2`
    FOREIGN KEY (`cod_bar`)
    REFERENCES `CaadiIntegrada`.`libro` (`id_libro`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `CaadiIntegrada`.`revista`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CaadiIntegrada`.`revista` (
  `id_revista` INT(11) NOT NULL AUTO_INCREMENT,
  `titulo_revista` VARCHAR(100) NOT NULL,
  `nombre_revista` VARCHAR(101) NOT NULL,
  `fecha` VARCHAR(20) NOT NULL,
  `id_rating` INT(11) NULL DEFAULT '1',
  `id_estado` VARCHAR(100) NOT NULL,
  `id_editorial` INT(11) NOT NULL,
  PRIMARY KEY (`id_revista`),
  INDEX `id_rating` (`id_rating` ASC),
  INDEX `id_editorial` (`id_editorial` ASC),
  CONSTRAINT `revista_ibfk_1`
    FOREIGN KEY (`id_rating`)
    REFERENCES `CaadiIntegrada`.`rating` (`id_rating`),
  CONSTRAINT `revista_ibfk_2`
    FOREIGN KEY (`id_editorial`)
    REFERENCES `CaadiIntegrada`.`editorial` (`id_editorial`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
