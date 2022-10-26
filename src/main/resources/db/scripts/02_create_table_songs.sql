create table songs(
    id int PRIMARY KEY,
    title varchar(50) NOT NULL,
    artist_id int NOT NULL,
    favourite bit
);