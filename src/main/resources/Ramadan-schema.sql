DROP TABLE IF EXISTS `Ramadan` CASCADE;
CREATE TABLE `Ramadan`( 
    `id` BIGINT  PRIMARY KEY AUTO_INCREMENT,
    `day` INTEGER CHECK (day<=30 AND day>=1 ),
    `fajr` VARCHAR(255) NOT NULL UNIQUE,
    `dhur` VARCHAR(255),
    `asr` VARCHAR(255),
    `maghrib` VARCHAR(255),
    `isha` VARCHAR(255)  
);
 
