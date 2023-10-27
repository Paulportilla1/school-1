CREATE TABLE IF NOT EXISTS Students (
    id SERIAL,
    fullname VARCHAR(100) NOT NULL,
    address VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
    );

CREATE TABLE IF NOT EXISTS Subject (
    id SERIAL,
    fullname VARCHAR(100) NOT NULL,
    date1 VARCHAR(100) NOT NULL,
    Course_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (Subject_id ) REFERENCES Subject(id)
    );