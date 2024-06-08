CREATE DATABASE IF NOT EXISTS flight_DB;
use flight_db;

CREATE TABLE customers (
                           customer_id INT PRIMARY KEY AUTO_INCREMENT,
                           customer_name VARCHAR(50) NOT NULL,
                           customer_status VARCHAR(20),
                           total_customer_mileage INT
);

CREATE TABLE aircraft (
                          aircraft_id INT PRIMARY KEY AUTO_INCREMENT,
                          aircraft_name VARCHAR(50) NOT NULL,
                          total_seats INT NOT NULL
);

CREATE TABLE flights (
                         flight_id INT PRIMARY KEY AUTO_INCREMENT,
                         flight_number VARCHAR(10) NOT NULL,
                         aircraft_id INT NOT NULL,
                         flight_mileage INT NOT NULL,
                         FOREIGN KEY (aircraft_id) REFERENCES aircraft(aircraft_id)
);

CREATE TABLE tickets (
                                 customer_id INT NOT NULL,
                                 flight_id INT NOT NULL,
                                 FOREIGN KEY (customer_id) REFERENCES customers(customer_id),
                                 FOREIGN KEY (flight_id) REFERENCES flights(flight_id)
);



INSERT INTO customers (customer_name, customer_status, total_customer_mileage)
VALUES
    ('Augustine Riviera', 'Silver', 115235),
    ('Alaina Sepulvida', 'None', 6008),
    ('Tom Jones', 'Gold', 205767),
    ('Sam Rio', 'None', 2653),
    ('Jessica James', 'Silver', 127656),
    ('Ana Janco', 'Silver', 136773),
    ('Jennifer Cortez', 'Gold', 300582),
    ('Christian Janco', 'Silver', 14642);

INSERT INTO aircraft (aircraft_name, total_seats)
VALUES
    ('Boeing 747', 400),
    ('Airbus A330', 236),
    ('Boeing 777', 264);

INSERT INTO flights (flight_number, aircraft_id, flight_mileage)
VALUES
    ('DL143', (SELECT aircraft_id FROM aircraft WHERE aircraft_name = 'Boeing 747'), 135),
    ('DL122', (SELECT aircraft_id FROM aircraft WHERE aircraft_name = 'Airbus A330'), 4370),
    ('DL53', (SELECT aircraft_id FROM aircraft WHERE aircraft_name = 'Boeing 777'), 2078),
    ('DL222', (SELECT aircraft_id FROM aircraft WHERE aircraft_name = 'Boeing 777'), 1765),
    ('DL37', (SELECT aircraft_id FROM aircraft WHERE aircraft_name = 'Boeing 747'), 531);

INSERT INTO tickets (customer_id, flight_id)
VALUES
    ((SELECT customer_id FROM customers WHERE customer_name = 'Augustine Riviera'), (SELECT flight_id FROM flights WHERE flight_number = 'DL143')),
    ((SELECT customer_id FROM customers WHERE customer_name = 'Augustine Riviera'), (SELECT flight_id FROM flights WHERE flight_number = 'DL122')),
    ((SELECT customer_id FROM customers WHERE customer_name = 'Alaina Sepulvida'), (SELECT flight_id FROM flights WHERE flight_number = 'DL122')),
    ((SELECT customer_id FROM customers WHERE customer_name = 'Tom Jones'), (SELECT flight_id FROM flights WHERE flight_number = 'DL122')),
    ((SELECT customer_id FROM customers WHERE customer_name = 'Tom Jones'), (SELECT flight_id FROM flights WHERE flight_number = 'DL53')),
    ((SELECT customer_id FROM customers WHERE customer_name = 'Sam Rio'), (SELECT flight_id FROM flights WHERE flight_number = 'DL143')),
    ((SELECT customer_id FROM customers WHERE customer_name = 'Tom Jones'), (SELECT flight_id FROM flights WHERE flight_number = 'DL222')),
    ((SELECT customer_id FROM customers WHERE customer_name = 'Jessica James'), (SELECT flight_id FROM flights WHERE flight_number = 'DL143')),
    ((SELECT customer_id FROM customers WHERE customer_name = 'Ana Janco'), (SELECT flight_id FROM flights WHERE flight_number = 'DL222')),
    ((SELECT customer_id FROM customers WHERE customer_name = 'Jennifer Cortez'), (SELECT flight_id FROM flights WHERE flight_number = 'DL222')),
    ((SELECT customer_id FROM customers WHERE customer_name = 'Jessica James'), (SELECT flight_id FROM flights WHERE flight_number = 'DL122')),
    ((SELECT customer_id FROM customers WHERE customer_name = 'Sam Rio'), (SELECT flight_id FROM flights WHERE flight_number = 'DL37')),
    ((SELECT customer_id FROM customers WHERE customer_name = 'Christian Janco'), (SELECT flight_id FROM flights WHERE flight_number = 'DL222'));

SELECT * FROM customers;
SELECT * from flights;
SELECT * from tickets;

SELECT COUNT(*) AS total_flights FROM flights;

SELECT AVG(flight_mileage) AS AverageFlightDistance FROM flights;

SELECT AVG(total_seats) AS AverageSeats FROM aircraft;

SELECT c.customer_status, AVG(c.total_customer_mileage)
AS AverageMilesByStatus
FROM customers c
GROUP BY c.customer_status;

SELECT c.customer_status, MAX(c.total_customer_mileage) AS MaxMilesByStatus
FROM Customers c
GROUP BY c.customer_status;

SELECT COUNT(*) AS TotalBoeingAircraft
FROM aircraft
WHERE aircraft.aircraft_name LIKE '%Boeing%';

SELECT *
FROM flights
WHERE flights.flight_mileage BETWEEN 300 AND 2000;

SELECT
    c.customer_status,
    AVG(f.flight_mileage) AS AverageFlightDistance
FROM
    Customers c
        JOIN tickets cf ON c.customer_id = cf.customer_id
        JOIN Flights f ON cf.flight_id = f.flight_id
GROUP BY
    c.customer_status;

SELECT
    a.aircraft_name,
    COUNT(*) AS BookingCount
FROM
    Customers c
        JOIN tickets cf ON c.customer_id = cf.customer_id
        JOIN Flights f ON cf.flight_id = f.flight_id
        JOIN Aircraft a ON f.aircraft_id = a.aircraft_id
WHERE
    c.customer_status = 'Gold'
GROUP BY
    a.aircraft_name
ORDER BY
    BookingCount DESC
LIMIT 1;