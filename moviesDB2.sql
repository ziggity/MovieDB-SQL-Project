USE bikdplp4e0h9teynppoh;

DROP TABLE IF EXISTS movie;
DROP TABLE IF EXISTS rating;
DROP TABLE IF EXISTS genre;

CREATE table genre(
id int (11) not null auto_increment,
genre_name VARCHAR(255) not null,
PRIMARY KEY (id) 
);

insert into genre (genre_name) values ( 'Action');
insert into genre (genre_name) values ( 'Animation');
insert into genre (genre_name) values ( 'Comedy');
insert into genre (genre_name) values ( 'Crime');
insert into genre (genre_name) values ( 'Drama');
insert into genre (genre_name) values ( 'Romance');
insert into genre (genre_name) values ( 'War');

CREATE table rating(
id int (11) not null auto_increment,
rating_scale VARCHAR(100) not null,
PRIMARY KEY (id)
);

insert into rating (rating_scale) value ( 'Oscar-worthy');
insert into rating (rating_scale) value ( 'Worth the money');
insert into rating (rating_scale) value ( 'Not a complete waste of time');
insert into rating (rating_scale) value (' Take the dog for a walk instead');
insert into rating (rating_scale) value ( 'You saw this? You need to reevaluate your life');


CREATE table movie(
Id int (11) not null auto_increment,
movie_title varchar(250) not null,
movie_length int,
release_date date,
director VARCHAR(50),
lead_actor VARCHAR(50),
revenue_made VARCHAR(50),
genre_id int(11) not null,
rating_id int(11) not null,
PRIMARY KEY (id),
FOREIGN KEY (genre_id) references genre(id),
FOREIGN KEY (rating_id) references rating(id)
);

insert into movie (movie_title, movie_length, release_date, director, lead_actor, revenue_made, genre_id, rating_id) values ('Body, The', 216, '1968-01-13', 'Ursola Goldin', 'Arlene Taffs', '$75813599.61', 5, 4);
insert into movie (movie_title, movie_length, release_date, director, lead_actor, revenue_made, genre_id, rating_id) values ('Victim', 214, '1973-03-20', 'Issiah Stollenhof', 'Tiphani Capron', '$83336144.40', 7, 3);
insert into movie (movie_title, movie_length, release_date, director, lead_actor, revenue_made, genre_id, rating_id) values ('Skylab, Le', 207, '1975-10-23', 'Tammy Bartel', 'Dawn Delacroux', '$16223413.73', 4, 2);
insert into movie (movie_title, movie_length, release_date, director, lead_actor, revenue_made, genre_id, rating_id) values ('Bill Burr: Let It Go', 200, '2011-05-27', 'Maryann Dowty', 'Kory Gradwell', '$56969453.58', 5, 5);
insert into movie (movie_title, movie_length, release_date, director, lead_actor, revenue_made, genre_id, rating_id) values ('Brown''s Requiem', 221, '1966-02-18', 'Jodee Fellgatt', 'Derrick Benns', '$77645294.44', 3, 4);
insert into movie (movie_title, movie_length, release_date, director, lead_actor, revenue_made, genre_id, rating_id) values ('Monte Carlo', 250, '1951-01-13', 'Dorri Rozsa', 'Lyndsay Valiant', '$52108775.28', 2, 4);
insert into movie (movie_title, movie_length, release_date, director, lead_actor, revenue_made, genre_id, rating_id) values ('Knowing', 211, '2017-12-30', 'Gianni Philippou', 'Camala Giveen', '$48047588.07', 1, 1);
insert into movie (movie_title, movie_length, release_date, director, lead_actor, revenue_made, genre_id, rating_id) values ('Good Neighbor Sam', 216, '2000-04-22', 'Oswald Gunney', 'Anne-corinne Harcombe', '$57522129.92', 3, 2);
insert into movie (movie_title, movie_length, release_date, director, lead_actor, revenue_made, genre_id, rating_id) values ('Fantasia', 218, '2016-06-07', 'Michal Cadany', 'Elianora Samber', '$44481610.98', 5, 1);
insert into movie (movie_title, movie_length, release_date, director, lead_actor, revenue_made, genre_id, rating_id) values ('Hunger', 213, '2002-07-07', 'Oneida Geffe', 'Cristiano Hawlgarth', '$30008468.70', 6, 5);

