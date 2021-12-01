CREATE DATABASE `aula-java`;

USE `aula-java`;

CREATE TABLE IF NOT EXISTS `aula-java`.`funcionario`(
`id_funcionario` INT UNSIGNED NOT NULL AUTO_INCREMENT,
`nome` VARCHAR(255) NOT NULL,
`dataNascimento` VARCHAR(10) NOT NULL,
`cpf` VARCHAR(15) NOT NULL,
`matricula` VARCHAR(10) NOT NULL,
PRIMARY KEY (`id_funcionario`)
)

SELECT * FROM funcionario;