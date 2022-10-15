CREATE SCHEMA `irrigation_system` ;

CREATE TABLE `irrigation_system`.`crop` (
  `crop_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`crop_id`));

CREATE TABLE `irrigation_system`.`plot` (
  `plot_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `top_left_longitude` DOUBLE NOT NULL,
  `top_left_latitude` DOUBLE NOT NULL,
  `area` DOUBLE NOT NULL,
  `crop_id` INT NULL,
  PRIMARY KEY (`plot_id`),
  INDEX `plot_crop_fk_idx` (`crop_id` ASC) VISIBLE,
  CONSTRAINT `plot_crop_fk`
    FOREIGN KEY (`crop_id`)
    REFERENCES `irrigation_system`.`crop` (`crop_id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE);

CREATE TABLE `irrigation_system`.`time_slot` (
  `time_slot_id` INT NOT NULL AUTO_INCREMENT,
  `start_date` VARCHAR(255) NOT NULL,
  `end_date` VARCHAR(255) NOT NULL,
  `irrigation_water_amount` INT NOT NULL,
  `irrigations_per_day` INT NOT NULL,
  `irrigation_duration` INT NOT NULL,
  `irrigation_days` INT NOT NULL,
  `irrigation_rate` INT NOT NULL,
  `plot_id` INT NOT NULL,
  PRIMARY KEY (`time_slot_id`),
  INDEX `time_slot_plot_fk_idx` (`plot_id` ASC) VISIBLE,
  CONSTRAINT `time_slot_plot_fk`
    FOREIGN KEY (`plot_id`)
    REFERENCES `irrigation_system`.`plot` (`plot_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE `irrigation_system`.`irrigation_process` (
  `irrigation_process_id` INT NOT NULL AUTO_INCREMENT,
  `start_time` VARCHAR(255) NOT NULL,
  `end_time` VARCHAR(255) NOT NULL,
  `duration` INT NOT NULL,
  `status` VARCHAR(255) NOT NULL,
  `sensor_retries` INT NOT NULL,
  `time_slot_id` INT NOT NULL,
  PRIMARY KEY (`irrigation_process_id`),
  INDEX `time_slot_irrigation_process_fk_idx` (`time_slot_id` ASC) VISIBLE,
  CONSTRAINT `time_slot_irrigation_process_fk`
    FOREIGN KEY (`time_slot_id`)
    REFERENCES `irrigation_system`.`time_slot` (`time_slot_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

