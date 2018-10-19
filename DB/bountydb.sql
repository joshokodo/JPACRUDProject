-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema bountydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `bountydb` ;

-- -----------------------------------------------------
-- Schema bountydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bountydb` DEFAULT CHARACTER SET utf8 ;
USE `bountydb` ;

-- -----------------------------------------------------
-- Table `bounty`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bounty` ;

CREATE TABLE IF NOT EXISTS `bounty` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `middle_initial` CHAR(1) NULL,
  `price` INT NOT NULL,
  `wanted_alive` CHAR(1) NOT NULL,
  `description` VARCHAR(250) NOT NULL,
  `crime` ENUM('J_WALKING', 'SWEARING', 'SPITTING', 'PUNCHING_BABIES', 'DISRESPECT_MAMA') NOT NULL,
  `nickname` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS bountyhunteruser@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'bountyhunteruser'@'localhost' IDENTIFIED BY 'onepiece';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'bountyhunteruser'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `bounty`
-- -----------------------------------------------------
START TRANSACTION;
USE `bountydb`;
INSERT INTO `bounty` (`id`, `first_name`, `last_name`, `middle_initial`, `price`, `wanted_alive`, `description`, `crime`, `nickname`) VALUES (1, 'Luffy', 'Monkey', 'D', 1500000000, 'N', 'short, black hair, wears strawhat', 'J_WALKING', NULL);
INSERT INTO `bounty` (`id`, `first_name`, `last_name`, `middle_initial`, `price`, `wanted_alive`, `description`, `crime`, `nickname`) VALUES (2, 'Zoro', 'Roranoa', NULL, 500000000, 'N', 'medium height and build, green hair, scar on eye, carries three swords', 'PUNCHING_BABIES', NULL);
INSERT INTO `bounty` (`id`, `first_name`, `last_name`, `middle_initial`, `price`, `wanted_alive`, `description`, `crime`, `nickname`) VALUES (3, 'Sanji', 'Vinsmoke', NULL, 320000000, 'N', '\"blonde hair, wears suits, cooks alot', 'SWEARING', NULL);

COMMIT;

