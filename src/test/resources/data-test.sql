-- Continents
INSERT INTO continents (name)
VALUES ('Europe'),
       ('North America'),
       ('South America'),
       ('Africa'),
       ('Asia'),
       ('Australia');

-- Countries
INSERT INTO countries (name, continent_id)
VALUES ('France', 1),
       ('Italy', 1),
       ('United States', 2),
       ('Brazil', 3),
       ('Egypt', 4),
       ('Japan', 5),
       ('Australia', 6);

-- Cities
INSERT INTO cities (name, country_id)
VALUES ('Paris', 1),
       ('Rome', 2),
       ('New York', 3),
       ('Rio de Janeiro', 4),
       ('Cairo', 5),
       ('Tokyo', 6),
       ('Sydney', 7);


-- Airports
INSERT INTO airports (IATA, name, city_id)
VALUES ('CDG', 'Paris Charles de Gaulle Airport', 1),
       ('FCO', 'Rome Fiumicino Airport', 2),
       ('JFK', 'John F. Kennedy International Airport', 3),
       ('GIG', 'Rio de Janeiro Galeão International Airport', 4),
       ('CAI', 'Cairo Airport', 5),
       ('HND', 'Tokyo Haneda Airport', 6),
       ('SYD', 'Sydney Kingsford Smith Airport', 7);


-- Hotels
INSERT INTO hotels (name, city_id, standard, description)
VALUES ('Luxury Eiffel Hotel', 1, '*****', 'Exclusive hotel with a view of the Eiffel Tower.'),
       ('Roman Residence', 2, '****', 'Charming hotel with traditional Italian charm.'),
       ('Central New York Resort', 3, '*****', 'Luxury hotel in the heart of New York.'),
       ('Tropical Paradise in Rio', 4, '****', 'Comfortable hotel surrounded by beaches and jungle.'),
       ('Luxury Resort in Cairo', 5, '*****', 'Elegant hotel with a view of Cairos ancient sites.'),
       ('Japanese Zen in Tokyo', 6, '*****', 'Modern hotel in Japanese style.'),
       ('Coastal Haven in Sydney', 7, '****', 'Hotel with a view of Sydneys beautiful coastline.');


-- Tours
INSERT INTO tours (departure_date, from_city, from_airport, to_city, to_airport, hotel, return_date, number_of_days,
                   type_of_board, price_for_adult, price_for_kid, is_promoted, number_of_adults, number_of_kids)
VALUES ('2023-09-10', 1, 'CDG', 2, 'FCO', 2, '2023-09-20', 10, 'All Inclusive', 2500.00, 1500.00, true, 2, 1),
       ('2023-08-15', 3, 'JFK', 4, 'GIG', 4, '2023-08-25', 10, 'Full Board', 1800.00, 1000.00, true, 2, 2),
       ('2023-09-25', 5, 'CAI', 6, 'HND', 6, '2023-10-05', 10, 'Bed and Dinner', 2200.00, 1200.00, true, 1, 2),
       ('2023-10-25', 5, 'CAI', 6, 'HND', 6, '2023-11-05', 10, 'Bed and Dinner', 2400.00, 1600.00, false, 1, 2),
       ('2023-10-10', 7, 'SYD', 1, 'CDG', 1, '2023-10-20', 10, 'All Inclusive', 2800.00, 1600.00, true, 2, 1);

-- Tour_orders
INSERT INTO tour_orders (order_date, tour)
VALUES ('2023-06-15', 1),
       ('2023-07-23', 2),
       ('2023-07-29', 3),
       ('2023-08-02', 4),
       ('2023-03-02', 5);