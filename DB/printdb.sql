-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema printdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `printdb` ;

-- -----------------------------------------------------
-- Schema printdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `printdb` DEFAULT CHARACTER SET utf8 ;
SHOW WARNINGS;
USE `printdb` ;

-- -----------------------------------------------------
-- Table `material_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `material_type` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `material_type` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `material`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `material` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `material` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `cost_per_kilo` DOUBLE NOT NULL,
  `color` VARCHAR(255) NULL,
  `material_type_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_material_material_type1_idx` (`material_type_id` ASC),
  CONSTRAINT `fk_material_material_type1`
    FOREIGN KEY (`material_type_id`)
    REFERENCES `material_type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `source`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `source` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `source` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `url` VARCHAR(1000) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `printer_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `printer_type` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `printer_type` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `printer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `printer` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `printer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `printer_type_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_printer_printer_type1_idx` (`printer_type_id` ASC),
  CONSTRAINT `fk_printer_printer_type1`
    FOREIGN KEY (`printer_type_id`)
    REFERENCES `printer_type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `print`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `print` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `print` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL,
  `duration` INT NOT NULL,
  `material_consumed` DOUBLE NOT NULL,
  `photo_url` VARCHAR(1000) NULL,
  `material_id` INT NOT NULL,
  `source_id` INT NOT NULL,
  `printer_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_print_material_idx` (`material_id` ASC),
  INDEX `fk_print_source1_idx` (`source_id` ASC),
  INDEX `fk_print_printer1_idx` (`printer_id` ASC),
  CONSTRAINT `fk_print_material`
    FOREIGN KEY (`material_id`)
    REFERENCES `material` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_print_source1`
    FOREIGN KEY (`source_id`)
    REFERENCES `source` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_print_printer1`
    FOREIGN KEY (`printer_id`)
    REFERENCES `printer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;
SET SQL_MODE = '';
DROP USER IF EXISTS user@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
SHOW WARNINGS;
CREATE USER 'user'@'localhost' IDENTIFIED BY 'user';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'user'@'localhost';
SHOW WARNINGS;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `material_type`
-- -----------------------------------------------------
START TRANSACTION;
USE `printdb`;
INSERT INTO `material_type` (`id`, `name`) VALUES (1, 'PLA');
INSERT INTO `material_type` (`id`, `name`) VALUES (2, 'ABS');
INSERT INTO `material_type` (`id`, `name`) VALUES (3, 'Resin');
INSERT INTO `material_type` (`id`, `name`) VALUES (4, 'Water Washable Resin');

COMMIT;


-- -----------------------------------------------------
-- Data for table `material`
-- -----------------------------------------------------
START TRANSACTION;
USE `printdb`;
INSERT INTO `material` (`id`, `name`, `cost_per_kilo`, `color`, `material_type_id`) VALUES (1, 'Inland 1.75mm', 18.99, 'Grey', 1);
INSERT INTO `material` (`id`, `name`, `cost_per_kilo`, `color`, `material_type_id`) VALUES (2, 'Elegoo Water-Washable Resin', 39.99, 'Grey', 4);

COMMIT;


-- -----------------------------------------------------
-- Data for table `source`
-- -----------------------------------------------------
START TRANSACTION;
USE `printdb`;
INSERT INTO `source` (`id`, `name`, `url`) VALUES (1, 'Me', NULL);
INSERT INTO `source` (`id`, `name`, `url`) VALUES (2, 'Hydrate_or_Diedrate', 'https://www.thingiverse.com/thing:4920090');

COMMIT;


-- -----------------------------------------------------
-- Data for table `printer_type`
-- -----------------------------------------------------
START TRANSACTION;
USE `printdb`;
INSERT INTO `printer_type` (`id`, `name`) VALUES (1, 'FDM');
INSERT INTO `printer_type` (`id`, `name`) VALUES (2, 'MSLA');
INSERT INTO `printer_type` (`id`, `name`) VALUES (3, 'SLA');

COMMIT;


-- -----------------------------------------------------
-- Data for table `printer`
-- -----------------------------------------------------
START TRANSACTION;
USE `printdb`;
INSERT INTO `printer` (`id`, `name`, `printer_type_id`) VALUES (1, 'CR10s Pro V2', 1);
INSERT INTO `printer` (`id`, `name`, `printer_type_id`) VALUES (2, 'Elegoo Mars', 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `print`
-- -----------------------------------------------------
START TRANSACTION;
USE `printdb`;
INSERT INTO `print` (`id`, `name`, `duration`, `material_consumed`, `photo_url`, `material_id`, `source_id`, `printer_id`) VALUES (1, 'Tricorder', 240, 0.15, NULL, 1, 1, 1);
INSERT INTO `print` (`id`, `name`, `duration`, `material_consumed`, `photo_url`, `material_id`, `source_id`, `printer_id`) VALUES (2, 'Type II Phaser', 194, 0.19, NULL, 1, 2, 1);
INSERT INTO `print` (`id`, `name`, `duration`, `material_consumed`, `photo_url`, `material_id`, `source_id`, `printer_id`) VALUES (3, 'Cylon', 38, .09, NULL, 2, 1, 2);

COMMIT;

