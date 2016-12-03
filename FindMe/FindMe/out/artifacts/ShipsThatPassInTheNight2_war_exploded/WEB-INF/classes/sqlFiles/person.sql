create table person
(user_id varchar(100),
password char(15),
first_name varchar(255),
last_name varchar(255),
country varchar(255),
city varchar(255),
primary key (user_id));

--change user_id to number  and varchar user will be unique key
--change country & city to their ids and add foreign key for them