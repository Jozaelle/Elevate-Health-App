BEGIN TRANSACTION;

DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS foodIntake CASCADE;
DROP TABLE IF EXISTS profile CASCADE;
DROP TABLE IF EXISTS hydration CASCADE;
DROP TABLE IF EXISTS weight CASCADE;

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
	photo varchar(500),
	birthday date,
	age int,
	height_feet int,
	height_inches int,
	current_weight int,
	goal_weight int,
	CONSTRAINT FK_user FOREIGN KEY (user_id) REFERENCES users(user_id),
	CONSTRAINT PK_profile PRIMARY KEY (profile_id)
);

CREATE TABLE weight (
   weight_id serial NOT NULL,
   user_id int NOT NULL,
   curr_date date NOT NULL,
   curr_weight NUMERIC(10,2),
   CONSTRAINT FK_user FOREIGN KEY (user_id) REFERENCES users(user_id),
   CONSTRAINT PK_weight_id PRIMARY KEY (weight_id)
);

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO profile (user_id) VALUES (1);
INSERT INTO profile (user_id) VALUES (2);

INSERT INTO foodintake (user_id, food_type, serving_size, number_of_servings, calories, carbs, fats, proteins, meal_type, day_of_meal)
VALUES (2, 'burger', 1, 1, 400, 45, 30, 25, 'lunch', '2022-04-15');
INSERT INTO foodintake (user_id, food_type, serving_size, number_of_servings, calories, carbs, fats, proteins, meal_type, day_of_meal)
VALUES (2, 'cereal', 1, 1, 250, 30, 20, 10, 'breakfast', '2022-04-15');
INSERT INTO foodintake (user_id, food_type, serving_size, number_of_servings, calories, carbs, fats, proteins, meal_type, day_of_meal)
VALUES (2, 'soup', 1, 1, 300, 25, 10, 5, 'dinner', '2022-04-14');
INSERT INTO foodintake (user_id, food_type, serving_size, number_of_servings, calories, carbs, fats, proteins, meal_type, day_of_meal)
VALUES (2, 'sandwhich', 1, 1, 275, 30, 20, 15, 'lunch', '2022-04-14');
INSERT INTO foodintake (user_id, food_type, serving_size, number_of_servings, calories, carbs, fats, proteins, meal_type, day_of_meal)
VALUES (2, 'steak', 1, 1, 400, 5, 40, 50, 'dinner', '2022-04-13');
INSERT INTO foodintake (user_id, food_type, serving_size, number_of_servings, calories, carbs, fats, proteins, meal_type, day_of_meal)
VALUES (2, 'burger', 1, 1, 400, 45, 30, 25, 'lunch', '2022-04-13');
INSERT INTO foodintake (user_id, food_type, serving_size, number_of_servings, calories, carbs, fats, proteins, meal_type, day_of_meal)
VALUES (2, 'bacon and eggs', 1, 1, 500, 25, 30, 25, 'breakfast', '2022-04-13');
INSERT INTO foodintake (user_id, food_type, serving_size, number_of_servings, calories, carbs, fats, proteins, meal_type, day_of_meal)
VALUES (2, 'potatoes', 1, 1, 300, 45, 10, 5, 'dinner', '2022-04-12');
INSERT INTO foodintake (user_id, food_type, serving_size, number_of_servings, calories, carbs, fats, proteins, meal_type, day_of_meal)
VALUES (2, 'sandwhich', 1, 1, 350, 45, 20, 10, 'lunch', '2022-04-11');
INSERT INTO foodintake (user_id, food_type, serving_size, number_of_servings, calories, carbs, fats, proteins, meal_type, day_of_meal)
VALUES (2, 'tomato soup', 1, 1, 300, 20, 20, 5, 'lunch', '2022-04-10');
INSERT INTO foodintake (user_id, food_type, serving_size, number_of_servings, calories, carbs, fats, proteins, meal_type, day_of_meal)
VALUES (2, 'salad', 1, 1, 250, 10, 25, 10, 'lunch', '2022-04-09');
INSERT INTO foodintake (user_id, food_type, serving_size, number_of_servings, calories, carbs, fats, proteins, meal_type, day_of_meal)
VALUES (2, 'burger', 1, 1, 400, 45, 30, 25, 'lunch', '2022-04-08');
INSERT INTO foodintake (user_id, food_type, serving_size, number_of_servings, calories, carbs, fats, proteins, meal_type, day_of_meal)
VALUES (2, 'sandwhich', 1, 1, 300, 25, 20, 10, 'lunch', '2022-04-07');
INSERT INTO foodintake (user_id, food_type, serving_size, number_of_servings, calories, carbs, fats, proteins, meal_type, day_of_meal)
VALUES (2, 'sandwhich', 1, 1, 350, 45, 20, 10, 'lunch', '2022-04-07');
INSERT INTO foodintake (user_id, food_type, serving_size, number_of_servings, calories, carbs, fats, proteins, meal_type, day_of_meal)
VALUES (2, 'tomato soup', 1, 1, 300, 20, 20, 5, 'lunch', '2022-04-06');
INSERT INTO foodintake (user_id, food_type, serving_size, number_of_servings, calories, carbs, fats, proteins, meal_type, day_of_meal)
VALUES (2, 'salad', 1, 1, 250, 10, 25, 10, 'lunch', '2022-04-06');
INSERT INTO foodintake (user_id, food_type, serving_size, number_of_servings, calories, carbs, fats, proteins, meal_type, day_of_meal)
VALUES (2, 'burger', 1, 1, 400, 45, 30, 25, 'lunch', '2022-04-05');
INSERT INTO foodintake (user_id, food_type, serving_size, number_of_servings, calories, carbs, fats, proteins, meal_type, day_of_meal)
VALUES (2, 'sandwhich', 1, 1, 300, 25, 20, 10, 'lunch', '2022-04-04');


INSERT INTO weight (user_id, curr_date, curr_weight)
VALUES (2, '2022-04-17', 190);

INSERT INTO weight (user_id, curr_date, curr_weight)
VALUES (2, '2022-04-16', 195);

INSERT INTO weight (user_id, curr_date, curr_weight)
VALUES (2, '2022-04-15', 200);

INSERT INTO weight (user_id, curr_date, curr_weight)
VALUES (2, '2022-04-14', 200);

INSERT INTO weight (user_id, curr_date, curr_weight)
VALUES (2, '2022-04-13', 205);

INSERT INTO weight (user_id, curr_date, curr_weight)
VALUES (2, '2022-04-12', 205);

INSERT INTO weight (user_id, curr_date, curr_weight)
VALUES (2, '2022-04-11', 210);

INSERT INTO weight (user_id, curr_date, curr_weight)
VALUES (2, '2022-04-10', 215);

INSERT INTO weight (user_id, curr_date, curr_weight)
VALUES (2, '2022-04-09', 220);



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