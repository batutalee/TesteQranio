-- MySQL Script generated by MySQL Workbench
-- 07/09/15 20:05:13
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`USUARIO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`USUARIO` (
  `ID_USUARIO` INT NOT NULL COMMENT 'ID do usuário.',
  `NOME_USUARIO` VARCHAR(45) NOT NULL COMMENT 'Nome do usuário.',
  `SENHA_USUARIO` VARCHAR(45) NOT NULL COMMENT 'Senha do usuário.',
  `EMAIL_USUARIO` VARCHAR(75) NOT NULL COMMENT 'Email do usuário.',
  PRIMARY KEY (`ID_USUARIO`)  COMMENT '',
  UNIQUE INDEX `idID_USUARIO_UNIQUE` (`ID_USUARIO` ASC)  COMMENT '')
ENGINE = InnoDB
COMMENT = 'Usuários cadastrados no sistema.';


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
