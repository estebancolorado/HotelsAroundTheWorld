insert into hotel(number_stars) values(3);
insert into room(number_guests, hotel) values(3, 1);
insert into destination(city, country, hotel) values('Medellin', 'Colombia', 1);
insert into reservation(checkin, checkout, price, destination) values('10/07/2022', '15/07/2022', 2535.0, 1);