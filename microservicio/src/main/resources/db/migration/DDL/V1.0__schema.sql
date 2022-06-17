create table room
(
  id serial,
  number_guests integer,
  hotel integer,
  primary key (id)
);

create table hotel
(
  id serial,
  number_stars integer,
  primary key (id)
);

create table destination
(
  id serial,
  city varchar(100),
  country varchar(100),
  hotel integer,
  primary key (id)
);

create table reservation
(
  id serial,
  checkin varchar(12),
  checkout varchar(12),
  price double precision,
  destination integer,
  primary key (id)
);

ALTER TABLE room
   ADD CONSTRAINT fk_room_hotel
   FOREIGN KEY (hotel)
   REFERENCES hotel (id);

ALTER TABLE destination
    ADD CONSTRAINT fk_destination_hotel
    FOREIGN KEY (hotel)
    REFERENCES hotel (id);

ALTER TABLE reservation
    ADD CONSTRAINT fk_reservation_destination
    FOREIGN KEY (destination)
    REFERENCES destination (id);