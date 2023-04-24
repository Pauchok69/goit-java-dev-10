CREATE TABLE IF NOT EXISTS client
(
    `id`   BIGINT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(200) NOT NULL,
    CONSTRAINT client_check_name CHECK (LENGTH(`name`) >= 3)
);

CREATE TABLE IF NOT EXISTS planet
(
    `id`   VARCHAR PRIMARY KEY,
    `name` VARCHAR(500) NOT NULL,
    CONSTRAINT worker_check_name CHECK (LENGTH(`name`) >= 1),
    CONSTRAINT worker_check_id CHECK (`id` = UPPER(`id`))
);

CREATE TABLE IF NOT EXISTS ticket
(
    `id`             BIGINT AUTO_INCREMENT PRIMARY KEY,
    `client_id`      BIGINT    NOT NULL,
    `from_planet_id` VARCHAR   NOT NULL,
    `to_planet_id`   VARCHAR   NOT NULL,
    `created_at`     DATETIME NOT NULL,
    FOREIGN KEY (`client_id`) REFERENCES client (`id`),
    FOREIGN KEY (`from_planet_id`) REFERENCES planet (`id`),
    FOREIGN KEY (`to_planet_id`) REFERENCES planet (`id`)
);