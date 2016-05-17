-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema nh_bd
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `nh_bd` ;

-- -----------------------------------------------------
-- Schema nh_bd
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `nh_bd` DEFAULT CHARACTER SET utf8 ;
USE `nh_bd` ;

-- -----------------------------------------------------
-- Table `nh_bd`.`userProfile`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nh_bd`.`userProfile` ;

CREATE TABLE IF NOT EXISTS `nh_bd`.`userProfile` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `designation` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `nh_bd`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nh_bd`.`users` ;

CREATE TABLE IF NOT EXISTS `nh_bd`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `address` VARCHAR(200) NOT NULL,
  `telephone` INT NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `nif` INT NOT NULL,
  `userProfile_id` INT NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_users_userProfile_idx` (`userProfile_id` ASC),
  CONSTRAINT `fk_users_userProfile`
    FOREIGN KEY (`userProfile_id`)
    REFERENCES `nh_bd`.`userProfile` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `nh_bd`.`orderStatus`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nh_bd`.`orderStatus` ;

CREATE TABLE IF NOT EXISTS `nh_bd`.`orderStatus` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `designation` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `nh_bd`.`orderType`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nh_bd`.`orderType` ;

CREATE TABLE IF NOT EXISTS `nh_bd`.`orderType` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `designation` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `nh_bd`.`productType`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nh_bd`.`productType` ;

CREATE TABLE IF NOT EXISTS `nh_bd`.`productType` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `designation` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `nh_bd`.`product`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nh_bd`.`product` ;

CREATE TABLE IF NOT EXISTS `nh_bd`.`product` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `designation` VARCHAR(45) NOT NULL,
  `quantity` INT NOT NULL DEFAULT 0,
  `price` FLOAT NULL,
  `productType_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_product_productType1_idx` (`productType_id` ASC),
  CONSTRAINT `fk_product_productType1`
    FOREIGN KEY (`productType_id`)
    REFERENCES `nh_bd`.`productType` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `nh_bd`.`order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nh_bd`.`order` ;

CREATE TABLE IF NOT EXISTS `nh_bd`.`order` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `dateIn` DATE NOT NULL,
  `dateOut` DATE NULL,
  `orderStatus_id` INT NOT NULL,
  `orderType_id` INT NOT NULL,
  `product_id` INT NOT NULL,
  `users_id` INT NOT NULL,
  `quantity` INT NOT NULL,
  PRIMARY KEY (`id`, `product_id`),
  INDEX `fk_order_orderStatus1_idx` (`orderStatus_id` ASC),
  INDEX `fk_order_orderType1_idx` (`orderType_id` ASC),
  INDEX `fk_order_product1_idx` (`product_id` ASC),
  INDEX `fk_order_users1_idx` (`users_id` ASC),
  CONSTRAINT `fk_order_orderStatus1`
    FOREIGN KEY (`orderStatus_id`)
    REFERENCES `nh_bd`.`orderStatus` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_orderType1`
    FOREIGN KEY (`orderType_id`)
    REFERENCES `nh_bd`.`orderType` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_product1`
    FOREIGN KEY (`product_id`)
    REFERENCES `nh_bd`.`product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_users1`
    FOREIGN KEY (`users_id`)
    REFERENCES `nh_bd`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `nh_bd`.`paymentType`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nh_bd`.`paymentType` ;

CREATE TABLE IF NOT EXISTS `nh_bd`.`paymentType` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `designation` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `nh_bd`.`sale`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nh_bd`.`sale` ;

CREATE TABLE IF NOT EXISTS `nh_bd`.`sale` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `date` DATE NOT NULL,
  `priceTotal` FLOAT NOT NULL,
  `paid` TINYINT(1) NOT NULL,
  `order_id` INT NOT NULL,
  `order_product_id` INT NOT NULL,
  `paymentType_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_sale_order1_idx` (`order_id` ASC, `order_product_id` ASC),
  INDEX `fk_sale_paymentType1_idx` (`paymentType_id` ASC),
  CONSTRAINT `fk_sale_order1`
    FOREIGN KEY (`order_id` , `order_product_id`)
    REFERENCES `nh_bd`.`order` (`id` , `product_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_sale_paymentType1`
    FOREIGN KEY (`paymentType_id`)
    REFERENCES `nh_bd`.`paymentType` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
