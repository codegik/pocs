DROP TABLE IF EXISTS input_data;

CREATE TABLE IF NOT EXISTS input_data
(
    id    VARCHAR(36),
    value INT,
    name  VARCHAR(100),
    PRIMARY KEY (id)
)