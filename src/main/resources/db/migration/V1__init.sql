CREATE TABLE IF NOT EXISTS Students (
    id SERIAL,
    fullname VARCHAR(100) NOT NULL,
    address VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
    );

CREATE TABLE IF NOT EXISTS Subject (
    id SERIAL,
    nombre VARCHAR(100) NOT NULL,
    fecha date NOT NULL,
    Students_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (Students_id) REFERENCES students(id)
    );