CREATE TABLE `person_v2`
(
    `id`                BIGINT      NOT NULL AUTO_INCREMENT,
    `first_name`       VARCHAR(45) NOT NULL,
    `last_name` VARCHAR(45) NOT NULL,
    `date_created`      DATETIME(3) DEFAULT CURRENT_TIMESTAMP(3),
    `last_updated`      DATETIME(3) DEFAULT CURRENT_TIMESTAMP(3),
    PRIMARY KEY (`id`)
);

CREATE TABLE `person_v3`
(
    `id`                BIGINT      NOT NULL AUTO_INCREMENT,
    `first_name`        VARCHAR(45) NOT NULL,
    `last_name`         VARCHAR(45) NOT NULL,
    `email`             VARCHAR(45) NOT NULL,
    `date_created`      DATETIME(3) DEFAULT CURRENT_TIMESTAMP(3),
    `last_updated`      DATETIME(3) DEFAULT CURRENT_TIMESTAMP(3),
    PRIMARY KEY (`id`)
);