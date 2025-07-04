DROP TABLE IF EXISTS address;
DROP VIEW IF EXISTS active_address;

CREATE TABLE IF NOT EXISTS address (
    id BIGINT PRIMARY KEY,
    street VARCHAR(255),
    is_soft_deleted BOOLEAN DEFAULT FALSE
);

CREATE VIEW active_address AS
SELECT * FROM address WHERE is_soft_deleted = false;
