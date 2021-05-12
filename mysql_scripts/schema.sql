-- -----------------------------------------------------
-- Table "CLIENT"
-- -----------------------------------------------------
CREATE TABLE `di-amantes`.`client` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NULL,
  `email` VARCHAR(45) NOT NULL,
  `phone_number` DOUBLE NULL,
  PRIMARY KEY (`id`));

-- -----------------------------------------------------
-- Table "PURCHASE"
-- -----------------------------------------------------
CREATE TABLE `di-amantes`.`purchase` (
  `id_purchase` INT NOT NULL AUTO_INCREMENT,
  `id_client` INT NOT NULL,
  `date` DATETIME NULL,
  `comments` VARCHAR(45) NULL,
  `status` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id_purchase`),
  INDEX `id_client_idx` (`id_client` ASC) VISIBLE,
  CONSTRAINT `id_client`
    FOREIGN KEY (`id_client`)
    REFERENCES `di-amantes`.`client` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table "CATEGORY"
-- -----------------------------------------------------
CREATE TABLE `di-amantes`.`category` (
  `id_category` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(45) NULL,
  `status` TINYINT NOT NULL,
  PRIMARY KEY (`id_category`));

-- -----------------------------------------------------
-- Table "PRODUCT"
-- -----------------------------------------------------
CREATE TABLE `di-amantes`.`product` (
  `id_product` INT NOT NULL AUTO_INCREMENT,
  `id_category` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `price` FLOAT NOT NULL,
  `stock` INT NOT NULL,
  `status` TINYINT NULL,
  PRIMARY KEY (`id_product`),
  INDEX `id_category_idx` (`id_category` ASC) VISIBLE,
  CONSTRAINT `id_category`
    FOREIGN KEY (`id_category`)
    REFERENCES `di-amantes`.`category` (`id_category`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- -----------------------------------------------------
-- Table "PURCHASE_PRODUCT"
-- -----------------------------------------------------
CREATE TABLE `di-amantes`.`purchase_product` (
  `id_purchase` INT NOT NULL,
  `id_product` INT NOT NULL,
  `quantity` INT NULL,
  `total` FLOAT NULL,
  `status` TINYINT NULL,
  PRIMARY KEY (`id_purchase`, `id_product`),
  INDEX `id_product_idx` (`id_product` ASC) VISIBLE,
  CONSTRAINT `id_purchase`
    FOREIGN KEY (`id_purchase`)
    REFERENCES `di-amantes`.`purchase` (`id_purchase`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `id_product`
    FOREIGN KEY (`id_product`)
    REFERENCES `di-amantes`.`product` (`id_product`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);