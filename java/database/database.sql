BEGIN TRANSACTION;

DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS foodIntake CASCADE;
DROP TABLE IF EXISTS profile CASCADE;
DROP TABLE IF EXISTS hydration CASCADE;


DROP SEQUENCE IF EXISTS seq_user_id;

CREATE SEQUENCE seq_user_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;


CREATE TABLE users (
	user_id int DEFAULT nextval('seq_user_id'::regclass) NOT NULL,
	username varchar(50) UNIQUE NOT NULL,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);


CREATE TABLE foodIntake (
	food_intake_id serial NOT NULL,
	user_id int NOT NULL,
	food_type varchar(50) NOT NULL,
	serving_size NUMERIC(10,2) NOT NULL,
	number_of_servings NUMERIC(10,2) NOT NULL,
	calories NUMERIC(10,2) NOT NULL,
	carbs NUMERIC(10,2) NOT NULL,
	fats NUMERIC(10,2) NOT NULL,
	proteins NUMERIC(10,2) NOT NULL,
	meal_type varchar(10) NOT NULL,
	day_of_meal date NOT NULL,
	CONSTRAINT FK_user FOREIGN KEY (user_id) REFERENCES users(user_id),
	CONSTRAINT PK_food_intake PRIMARY KEY (food_intake_id)
);

CREATE TABLE hydration (
   hydration_id serial NOT NULL,
   user_id int NOT NULL,
   curr_date date NOT NULL,
   amount_drank NUMERIC(10,2),
   CONSTRAINT FK_user FOREIGN KEY (user_id) REFERENCES users(user_id),
   CONSTRAINT PK_hydration_id PRIMARY KEY (hydration_id)
);

CREATE TABLE profile (
	profile_id serial NOT NULL,
	user_id int NOT NULL,
	display_name varchar(64),
	age int,
	height_feet int,
	height_inches int,
	current_weight int,
	goal_weight int,
	CONSTRAINT FK_user FOREIGN KEY (user_id) REFERENCES users(user_id),
	CONSTRAINT PK_profile PRIMARY KEY (profile_id)
);

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');


--- USER SETUP (Do Not Modify)
DROP USER IF EXISTS final_capstone_owner;
DROP USER IF EXISTS final_capstone_appuser;

CREATE USER final_capstone_owner
WITH PASSWORD 'finalcapstone';

GRANT ALL
ON ALL TABLES IN SCHEMA public
TO final_capstone_owner;

GRANT ALL
ON ALL SEQUENCES IN SCHEMA public
TO final_capstone_owner;

CREATE USER final_capstone_appuser
WITH PASSWORD 'finalcapstone';

GRANT SELECT, INSERT, UPDATE, DELETE
ON ALL TABLES IN SCHEMA public
TO final_capstone_appuser;

GRANT USAGE, SELECT
ON ALL SEQUENCES IN SCHEMA public
TO final_capstone_appuser;

COMMIT TRANSACTION;