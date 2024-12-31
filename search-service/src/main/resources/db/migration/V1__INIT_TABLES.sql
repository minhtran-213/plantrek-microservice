CREATE TABLE search_requests (
    id SERIAL PRIMARY KEY,                -- Unique identifier for the search request
    user_id VARCHAR(255),                 -- User ID (optional, if logged in)
    origin VARCHAR(3) NOT NULL,           -- IATA code for the departure airport
    destination VARCHAR(3) NOT NULL,      -- IATA code for the arrival airport
    departure_date TIMESTAMP NOT NULL,         -- Desired departure date
    return_date TIMESTAMP,                     -- Desired return date (optional)
    trip_type VARCHAR(20) NOT NULL,       -- Trip type: "one-way" or "round-trip"
    filters VARCHAR,                        -- Optional filters (e.g., max price, airlines)
    created_at TIMESTAMP DEFAULT NOW(),   -- Timestamp when the search was created
    updated_at TIMESTAMP DEFAULT NOW()    -- Timestamp when the search was last updated
);
