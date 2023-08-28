CREATE TABLE IF NOT EXISTS continents
(
    id   BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(20) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS countries
(
    id           BIGINT AUTO_INCREMENT PRIMARY KEY,
    name         VARCHAR(60) NOT NULL,
    continent_id BIGINT,
    CONSTRAINT continentId_fk FOREIGN KEY (continent_id) REFERENCES continents (id)
);

CREATE TABLE IF NOT EXISTS cities
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    name       VARCHAR(60) NOT NULL,
    country_id BIGINT      NOT NULL,
    CONSTRAINT countryId_fk FOREIGN KEY (country_id) REFERENCES countries (id)
);
CREATE TABLE IF NOT EXISTS airports
(
    IATA    VARCHAR(3)  NOT NULL PRIMARY KEY,
    name    VARCHAR(70) NOT NULL,
    city_id BIGINT      NOT NULL,
    CONSTRAINT cityId_fk FOREIGN KEY (city_id) REFERENCES cities (id)
);

CREATE TABLE IF NOT EXISTS hotels
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(90) NOT NULL,
    city_id     BIGINT      NOT NULL,
    standard    VARCHAR(5)  NOT NULL,
    description VARCHAR(299),
    CONSTRAINT city_fk FOREIGN KEY (city_id) REFERENCES cities (id)
);

CREATE TABLE IF NOT EXISTS tours
(
    id               BIGINT AUTO_INCREMENT PRIMARY KEY,
    departure_date   DATE,
    from_city        BIGINT REFERENCES cities (id),
    from_airport     VARCHAR(3) REFERENCES airports (iata),
    to_city          BIGINT REFERENCES cities (id),
    to_airport       VARCHAR(3) REFERENCES airports (iata),
    hotel            BIGINT REFERENCES hotels (id),
    return_date      DATE,
    number_of_days   INTEGER,
    type_of_board    VARCHAR(20),
    price_for_adult  FLOAT,
    price_for_kid    FLOAT,
    is_promoted      BOOLEAN,
    number_of_adults INTEGER,
    number_of_kids   INTEGER
);

CREATE TABLE IF NOT EXISTS tour_orders
(
    id              BIGINT AUTO_INCREMENT PRIMARY KEY,
    order_date      DATE,
    tour            BIGINT REFERENCES tours (id)
);