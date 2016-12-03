CREATE TABLE country
(
  country_id INT(11) PRIMARY KEY NOT NULL,
  country_name VARCHAR(300)
);
CREATE UNIQUE INDEX country_name ON country (country_name);