CREATE TABLE flights (
    id VARCHAR PRIMARY KEY,                  -- Unique identifier for each flight
    airline VARCHAR(100) NOT NULL,          -- Name of the airline (e.g., Vietnam Airlines)
    origin VARCHAR(3) NOT NULL,             -- IATA code for departure airport
    destination VARCHAR(3) NOT NULL,        -- IATA code for arrival airport
    duration INTERVAL NOT NULL,             -- Flight duration (e.g., 02:30 for 2 hours 30 mins)
    created_at TIMESTAMP DEFAULT NOW(),     -- Timestamp for record creation
    updated_at TIMESTAMP DEFAULT NOW()      -- Timestamp for last update
);

CREATE TABLE flight_schedule (
    id VARCHAR PRIMARY KEY,                  -- Unique identifier for each schedule
    flight_id VARCHAR NOT NULL REFERENCES flights(id) ON DELETE CASCADE, -- Link to flights table
    departure_time TIMESTAMP NOT NULL,      -- Scheduled departure time
    arrival_time TIMESTAMP NOT NULL,        -- Scheduled arrival time
    created_at TIMESTAMP DEFAULT NOW(),     -- Timestamp for record creation
    updated_at TIMESTAMP DEFAULT NOW()      -- Timestamp for last update
);

CREATE TABLE inventory (
    id VARCHAR PRIMARY KEY,                  -- Unique identifier for inventory record
    schedule_id VARCHAR NOT NULL REFERENCES flight_schedule(id) ON DELETE CASCADE, -- Link to flight schedule
    total_seats INT NOT NULL,               -- Total seats available on the flight
    available_seats INT NOT NULL,           -- Seats still available for booking
    price NUMERIC(10, 2) NOT NULL,          -- Price per seat
    created_at TIMESTAMP DEFAULT NOW(),     -- Timestamp for record creation
    updated_at TIMESTAMP DEFAULT NOW()      -- Timestamp for last update
);
