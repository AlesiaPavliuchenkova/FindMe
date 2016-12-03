create table city
(city_id int  NOT NULL AUTO_INCREMENT,
 city_name VARCHAR(300),
 country_id int,
 PRIMARY key(city_id),
 FOREIGN key(country_id) REFERENCES country(country_id));
