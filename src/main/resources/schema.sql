DROP TABLE IF EXISTS SECTOR CASCADE;
DROP TABLE IF EXISTS ANIMAL CASCADE;

CREATE TABLE SECTOR (
 SECTOR_ID BIGINT PRIMARY KEY AUTO_INCREMENT,
 NAME VARCHAR(50) NOT NULL,
 ANIMALS BIGINT ARRAY[3]
);

CREATE TABLE ANIMAL(
 ANIMAL_ID BIGINT PRIMARY KEY AUTO_INCREMENT,
 NAME VARCHAR(50) NOT NULL,
 KARMA_UNITS INT,
 TYPE VARCHAR(50),
 SECTOR_ID BIGINT,
 FOREIGN KEY (SECTOR_ID) REFERENCES SECTOR(SECTOR_ID)
);

INSERT INTO SECTOR(NAME, ANIMALS) VALUES('SAHARA', NULL);
INSERT INTO SECTOR(NAME, ANIMALS) VALUES('TUNDRA', NULL);

INSERT INTO ANIMAL(NAME, KARMA_UNITS, TYPE, SECTOR_ID) VALUES ('MIETEK', 11, 'LION', 1);
INSERT INTO ANIMAL(NAME, KARMA_UNITS, TYPE, SECTOR_ID) VALUES ('WICI', 4, 'RABBIT', 1);
INSERT INTO ANIMAL(NAME, KARMA_UNITS, TYPE, SECTOR_ID) VALUES ('KICI', 20, 'ELEPHANT', 1);
INSERT INTO ANIMAL(NAME, KARMA_UNITS, TYPE, SECTOR_ID) VALUES ('DREM', 20, 'RABBIT', 2);

UPDATE SECTOR
SET ANIMALS = ARRAY[1,2,3]
WHERE NAME = 'SAHARA';