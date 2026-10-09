-- Below queries is only for creating database and for schema.
CREATE DATABASE IF NOT EXISTS studentData;

USE studentData;

CREATE TABLE IF NOT EXISTS student (
    Sid INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Sname VARCHAR(30) NOT NULL,
    Sdob DATE NOT NULL,
    Smobilenumber INT NOT NULL,
    Saddress VARCHAR(50) NOT NULL,
    Scourse VARCHAR(5) NOT NULL
);

-- If you want to test it then follow below steps--
-- 1. Open MySQL Workbench.
-- 2. Open database.sql.
-- 3. Execute the script.
-- 4. Run:

USE studentdata;
DESCRIBE student;
SELECT * FROM student;