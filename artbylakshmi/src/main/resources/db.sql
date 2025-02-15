
use artbylakshmi;
create database artbylakshmi;

CREATE TABLE order_details (
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    caption VARCHAR(255),
    phone_number VARCHAR(15),
    delivery_address TEXT,
    status VARCHAR(255) NOT NULL,
    order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    estimated_delivery_date DATE
);

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,      -- Unique user ID
    username VARCHAR(255) NOT NULL UNIQUE,  -- Username for login
    password VARCHAR(255) NOT NULL,         -- Hashed password
    email VARCHAR(255) NOT NULL UNIQUE,     -- Email (optional, can be used for registration)
    first_name VARCHAR(255),                -- First name (optional)
    last_name VARCHAR(255),                 -- Last name (optional)
    role VARCHAR(50) DEFAULT 'USER',        -- User role (e.g., USER, ADMIN, etc.)
    account_enabled BOOLEAN DEFAULT TRUE,   -- Whether the account is enabled or not
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- Account creation time
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP  -- Last update time
);


CREATE TABLE arts (
    art_id INT AUTO_INCREMENT PRIMARY KEY,  -- Auto-increment for unique ID
    name VARCHAR(255) NOT NULL,             -- Art name
    price DECIMAL(10, 2) NOT NULL,          -- Art price with two decimal places
    art_size VARCHAR(100),                  -- Art size (e.g., '12x12 inches', 'A4', etc.)
    art_description TEXT,                   -- Description of the art
    copy_or_original VARCHAR(10) NOT NULL, -- Enum to define if the art is a Copy or Original
    uploaded_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP -- Automatically sets the current timestamp for when the art is uploaded
);

