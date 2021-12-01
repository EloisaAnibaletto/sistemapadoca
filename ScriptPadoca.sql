CREATE DATABASE IF NOT EXISTS `sistemaPadoca` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE IF NOT EXISTS `sistemaPadoca`.`chef` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `cpf` VARCHAR(11) NOT NULL,
  `dtNasc` VARCHAR(10) NOT NULL,
  `especialidade` VARCHAR(45) NOT NULL,
  `salario` DOUBLE NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `sistemaPadoca`.`cliente` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome`VARCHAR(45) NOT NULL,
  `cpf` VARCHAR(11) NOT NULL,
  `dtNasc` VARCHAR(10) NOT NULL,
  `telefone` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SELECT * FROM sistemapadoca.chef;
SELECT * FROM sistemapadoca.cliente;