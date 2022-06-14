 create table reservation(
  id serial,
  checkin varchar(10),
  checkout varchar(10),
  price double precision,
  destination integer,
  primary key (id)
 );