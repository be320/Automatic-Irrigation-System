CREATE SCHEMA `irrigation` ;

CREATE TABLE `irrigation`.`crop` (
  `crop_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `rate_of_irrigation` INT NOT NULL,
  `amount_of_water` INT NOT NULL,
  PRIMARY KEY (`crop_id`));

CREATE TABLE `irrigation`.`plot` (
  `plot_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `top_left_longitude` DOUBLE NOT NULL,
  `top_left_latitude` DOUBLE NOT NULL,
  `area` INT NOT NULL,
  `crop_id` INT NOT NULL,
  PRIMARY KEY (`plot_id`),
  INDEX `plot_crop_fk_idx` (`crop_id` ASC) VISIBLE,
  CONSTRAINT `plot_crop_fk`
    FOREIGN KEY (`crop_id`)
    REFERENCES `irrigation`.`crop` (`crop_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE `irrigation`.`time_slot` (
  `time_slot_id` INT NOT NULL AUTO_INCREMENT,
  `start_time` VARCHAR(255) NOT NULL,
  `end_time` VARCHAR(255) NOT NULL,
  `duration` INT NOT NULL,
  `total_water_consumed` INT NOT NULL,
  `status` VARCHAR(255) NOT NULL,
  `sensor_retries` INT NOT NULL,
  `plot_id` INT NOT NULL,
  PRIMARY KEY (`time_slot_id`),
  INDEX `plot_time_slot_fk_idx` (`plot_id` ASC) VISIBLE,
  CONSTRAINT `plot_time_slot_fk`
    FOREIGN KEY (`plot_id`)
    REFERENCES `irrigation`.`plot` (`plot_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
