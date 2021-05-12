-- -----------------------------------------------------
-- Table "CATEGORY"
-- -----------------------------------------------------
CREATE TABLE  CATEGORY (
  "id_category" SERIAL NOT NULL,
  "description" VARCHAR(45) NOT NULL,
  "state" BOOLEAN NOT NULL,
  PRIMARY KEY ("id_category"));


-- -----------------------------------------------------
-- Table "PRODUCT"
-- -----------------------------------------------------
CREATE TABLE  PRODUCT (
  "id_product" SERIAL NOT NULL,
  "name" VARCHAR(45) NULL,
  "id_category" INT NOT NULL,
  "bar_code" VARCHAR(150) NULL,
  "price" DECIMAL(16,2) NULL,
  "quantity_stock" INT NOT NULL,
  "state" BOOLEAN NULL,
  PRIMARY KEY ("id_product"),
  CONSTRAINT "fk_PRODUCT_CATEGORY"
    FOREIGN KEY ("id_category")
    REFERENCES CATEGORY ("id_category")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- -----------------------------------------------------
-- Table "CLIENT"
-- -----------------------------------------------------
CREATE TABLE  CLIENT (
  "id" VARCHAR(20) NOT NULL,
  "name" VARCHAR(40) NULL,
  "lastname" VARCHAR(100) NULL,
  "cellphone" NUMERIC NULL,
  "address" VARCHAR(80) NULL,
  "email" VARCHAR(70) NULL,
  PRIMARY KEY ("id"));


-- -----------------------------------------------------
-- Table "PURCHASE"
-- -----------------------------------------------------
CREATE TABLE  PURCHASE (
  "id_purchase" SERIAL NOT NULL,
  "id_client" VARCHAR(20) NOT NULL,
  "date" TIMESTAMP NULL,
  "payment_method" CHAR(1) NULL,
  "comment" VARCHAR(300) NULL,
  "state" CHAR(1) NULL,
  PRIMARY KEY ("id_purchase"),
  CONSTRAINT "fk_PURCHASE_CLIENT1"
    FOREIGN KEY ("id_client")
    REFERENCES CLIENT ("id")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- -----------------------------------------------------
-- Table "PURCHASE_PRODUCT"
-- -----------------------------------------------------
CREATE TABLE  PURCHASE_PRODUCT (
  "id_purchase" INT NOT NULL,
  "id_product" INT NOT NULL,
  "quantity" INT NULL,
  "total" DECIMAL(16,2) NULL,
  "state" BOOLEAN NULL,
  PRIMARY KEY ("id_purchase", "id_product"),
  CONSTRAINT "fk_PURCHASE_PRODUCT_PRODUCT1"
    FOREIGN KEY ("id_product")
    REFERENCES PRODUCT ("id_product")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT "fk_PURCHASE_PRODUCT_PURCHASE1"
    FOREIGN KEY ("id_purchase")
    REFERENCES PURCHASE ("id_purchase")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);