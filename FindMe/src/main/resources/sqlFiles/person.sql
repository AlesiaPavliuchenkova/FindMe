CREATE TABLE person
(
    user_id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    user_name VARCHAR(100) NOT NULL,
    password CHAR(15) NOT NULL,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    country_id INT(11),
    city_id INT(11),
    CONSTRAINT person_country_country_id_fk FOREIGN KEY (country_id) REFERENCES country (country_id),
    CONSTRAINT person_city_city_id_fk FOREIGN KEY (city_id) REFERENCES city (city_id)
);
CREATE INDEX person_city_city_id_fk ON person (city_id);
CREATE INDEX person_country_country_id_fk ON person (country_id);
CREATE UNIQUE INDEX person_user_name_uindex ON person (user_name);
ALTER TABLE db.person MODIFY password VARCHAR(100) NOT NULL;