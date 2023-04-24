INSERT INTO client (id, name)
VALUES (1, 'Mohamad Jordan'),
       (2, 'Jamil Coffey'),
       (3, 'Ellena Stein'),
       (4, 'Michael Bennett'),
       (5, 'Abbas Russell');

INSERT INTO planet (id, name)
VALUES ('MERCURY', 'Mercury'),
       ('VENUS', 'Venus'),
       ('EARTH', 'Earth'),
       ('MARS', 'Mars'),
       ('JUPITER', 'Jupiter'),
       ('SATURN', 'Saturn'),
       ('URANUS', 'Uranus'),
       ('NEPTUNE', 'Neptune');

INSERT INTO ticket (id, client_id, from_planet_id, to_planet_id, created_at)
VALUES (1, 3, 'MERCURY', 'EARTH', '2018-01-05 22:00:00'),
       (2, 3, 'EARTH', 'URANUS', '2022-02-03 10:20:00'),
       (3, 1, 'SATURN', 'EARTH', '2022-02-04 11:45:00'),
       (4, 3, 'URANUS', 'EARTH', '2022-03-24 02:00:00'),
       (5, 5, 'EARTH', 'NEPTUNE', '2022-03-30 16:15:00'),
       (6, 1, 'EARTH', 'MARS', '2022-05-13 15:00:00'),
       (7, 4, 'MERCURY', 'VENUS', '2022-05-13 22:00:00'),
       (8, 3, 'EARTH', 'URANUS', '2022-05-14 00:00:00'),
       (9, 1, 'MARS', 'EARTH', '2022-07-17 12:00:00'),
       (10, 5, 'NEPTUNE', 'JUPITER', '2023-04-01 11:11:11');