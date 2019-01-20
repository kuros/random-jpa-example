DROP DATABASE IF EXISTS employees;
CREATE DATABASE IF NOT EXISTS employees;
USE employees;

SELECT 'CREATING DATABASE STRUCTURE' as 'INFO';

DROP TABLE IF EXISTS dept_emp,
  dept_manager,
  titles,
  salaries,
  employees,
  departments;

/*!50503 set default_storage_engine = InnoDB */;
/*!50503 select CONCAT('storage engine: ', @@default_storage_engine) as INFO */;

CREATE TABLE employee (
                         emp_no      INT             NOT NULL AUTO_INCREMENT,
                         birth_date  DATE            NOT NULL,
                         first_name  VARCHAR(14)     NOT NULL,
                         last_name   VARCHAR(16)     NOT NULL,
                         gender      ENUM ('M','F')  NOT NULL,
                         hire_date   DATE            NOT NULL,
                         PRIMARY KEY (emp_no)
);

CREATE TABLE departments (
                           dept_no     INT         NOT NULL AUTO_INCREMENT,
                           dept_name   VARCHAR(40)     NOT NULL,
                           PRIMARY KEY (dept_no),
                           UNIQUE  KEY (dept_name)
);

CREATE TABLE dept_manager (
                            id           INT             NOT NULL AUTO_INCREMENT,
                            emp_no       INT             NOT NULL,
                            dept_no      INT         NOT NULL,
                            from_date    DATE            NOT NULL,
                            to_date      DATE            NOT NULL,
                            FOREIGN KEY (emp_no)  REFERENCES employees (emp_no)    ON DELETE CASCADE,
                            FOREIGN KEY (dept_no) REFERENCES departments (dept_no) ON DELETE CASCADE,
                            UNIQUE KEY (emp_no,dept_no),
                            PRIMARY KEY (id)
);

CREATE TABLE dept_emp (
                        id          INT             NOT NULL AUTO_INCREMENT,
                        emp_no      INT             NOT NULL,
                        dept_no     INT         NOT NULL,
                        from_date   DATE            NOT NULL,
                        to_date     DATE            NOT NULL,
                        FOREIGN KEY (emp_no)  REFERENCES employees   (emp_no)  ON DELETE CASCADE,
                        FOREIGN KEY (dept_no) REFERENCES departments (dept_no) ON DELETE CASCADE,
                        UNIQUE KEY (emp_no,dept_no),
                        PRIMARY KEY (id)
);

CREATE TABLE titles (
                      id          INT             NOT NULL AUTO_INCREMENT,
                      emp_no      INT             NOT NULL,
                      title       VARCHAR(50)     NOT NULL,
                      from_date   DATE            NOT NULL,
                      to_date     DATE,
                      FOREIGN KEY (emp_no) REFERENCES employees (emp_no) ON DELETE CASCADE,
                      UNIQUE KEY (emp_no,title, from_date),
                      PRIMARY KEY (id)
)
;

CREATE TABLE salaries (
                        id           INT             NOT NULL AUTO_INCREMENT,
                        emp_no      INT             NOT NULL,
                        salary      INT             NOT NULL,
                        from_date   DATE            NOT NULL,
                        to_date     DATE            NOT NULL,
                        FOREIGN KEY (emp_no) REFERENCES employees (emp_no) ON DELETE CASCADE,
                        UNIQUE KEY (emp_no, from_date),
                        PRIMARY KEY (id)
)
;

CREATE TABLE customer (
                         customer_no      INT             NOT NULL AUTO_INCREMENT,
                         first_name  VARCHAR(14)     NOT NULL,
                         last_name   VARCHAR(16)     NOT NULL,
                         gender      ENUM ('M','F')  NOT NULL,
                         PRIMARY KEY (customer_no)
);


CREATE TABLE play_group (
                              id           INT             NOT NULL AUTO_INCREMENT,
                              group_name   VARCHAR(40)     NOT NULL,
                              PRIMARY KEY (id),
                              UNIQUE KEY (group_name)
);

CREATE TABLE play_group_member (
                                     id           INT             NOT NULL AUTO_INCREMENT,
                                     group_id     INT             NOT NULL,
                                     member_id    INT             NOT NULL,
                                     member_type  ENUM('employee', 'customer'),
                                     FOREIGN KEY (group_id) REFERENCES play_group (id) ON DELETE CASCADE,
                               primary KEY (id)
)
;

CREATE TABLE employee_inventory_audit (
    id          INT NOT NULL AUTO_INCREMENT,
    emp_no      INT NOT NULL,
    inventory   VARCHAR(40) NOT NULL,
    quantity    INT NOT NULL,
    purchase_date DATE NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO `employees` VALUES (10001,'1953-09-02','Georgi','Facello','M','1986-06-26'),
                               (10002,'1964-06-02','Bezalel','Simmel','F','1985-11-21'),
                               (10003,'1959-12-03','Parto','Bamford','M','1986-08-28'),
                               (10004,'1954-05-01','Chirstian','Koblick','M','1986-12-01'),
                               (10005,'1955-01-21','Kyoichi','Maliniak','M','1989-09-12'),
                               (10006,'1953-04-20','Anneke','Preusig','F','1989-06-02'),
                               (10007,'1957-05-23','Tzvetan','Zielinski','F','1989-02-10'),
                               (10008,'1958-02-19','Saniya','Kalloufi','M','1994-09-15'),
                               (10009,'1952-04-19','Sumant','Peac','F','1985-02-18'),
                               (10010,'1963-06-01','Duangkaew','Piveteau','F','1989-08-24'),
                               (10011,'1953-11-07','Mary','Sluis','F','1990-01-22'),
                               (10012,'1960-10-04','Patricio','Bridgland','M','1992-12-18'),
                               (10013,'1963-06-07','Eberhardt','Terkki','M','1985-10-20'),
                               (10014,'1956-02-12','Berni','Genin','M','1987-03-11'),
                               (10015,'1959-08-19','Guoxiang','Nooteboom','M','1987-07-02');

INSERT INTO `departments` VALUES
                                (1,'Marketing'),
                                (2,'Finance'),
                                (3,'Human Resources'),
                                (4,'Production'),
                                (5,'Development'),
                                (6,'Quality Management'),
                                (7,'Sales'),
                                (8,'Research'),
                                (9,'Customer Service');


INSERT INTO `dept_manager` (emp_no, dept_no, from_date, to_date) VALUES
                            (10011, 1, '1985-01-01', '1991-10-01'),
                            (10014, 1, '1991-10-01', '9999-01-01'),
                            (10005, 2, '1985-01-01', '1989-12-17'),
                            (10008, 2, '1989-12-17', '9999-01-01');

INSERT INTO `dept_emp` (emp_no, dept_no, from_date, to_date) VALUES (10001, 1,'1986-06-26','9999-01-01'),
                              (10002, 1,'1996-08-03','9999-01-01'),
                              (10003, 2,'1995-12-03','9999-01-01'),
                              (10004, 2,'1986-12-01','9999-01-01'),
                              (10005, 1,'1980-09-12','1985-01-01'),
                              (10006, 1,'1990-08-05','9999-01-01'),
                              (10007, 2,'1989-02-10','9999-01-01'),
                              (10008, 1,'1978-03-11','1989-12-17'),
                              (10009, 2,'1985-02-18','9999-01-01'),
                              (10010, 1,'1996-11-24','2000-06-26'),
                              (10010, 2,'2000-06-26','9999-01-01'),
                              (10011, 1,'1970-01-22','1985-01-01'),
                              (10012, 1,'1992-12-18','9999-01-01'),
                              (10013, 1,'1985-10-20','9999-01-01'),
                              (10014, 1,'1983-12-29','1991-10-01'),
                              (10015, 2,'1992-09-19','1993-08-22');


INSERT INTO `titles` (emp_no, title, from_date, to_date) VALUES (10001,'Senior Engineer','1986-06-26','9999-01-01'),
                            (10002,'Staff','1996-08-03','9999-01-01'),
                            (10003,'Senior Engineer','1995-12-03','9999-01-01'),
                            (10004,'Engineer','1986-12-01','1995-12-01'),
                            (10004,'Senior Engineer','1995-12-01','9999-01-01'),
                            (10005,'Senior Staff','1996-09-12','9999-01-01'),
                            (10005,'Staff','1989-09-12','1996-09-12'),
                            (10006,'Senior Engineer','1990-08-05','9999-01-01'),
                            (10007,'Senior Staff','1996-02-11','9999-01-01'),
                            (10007,'Staff','1989-02-10','1996-02-11'),
                            (10008,'Assistant Engineer','1998-03-11','2000-07-31'),
                            (10009,'Assistant Engineer','1985-02-18','1990-02-18'),
                            (10009,'Engineer','1990-02-18','1995-02-18'),
                            (10009,'Senior Engineer','1995-02-18','9999-01-01'),
                            (10010,'Engineer','1996-11-24','9999-01-01'),
                            (10011,'Staff','1990-01-22','1996-11-09'),
                            (10012,'Engineer','1992-12-18','2000-12-18'),
                            (10012,'Senior Engineer','2000-12-18','9999-01-01'),
                            (10013,'Senior Staff','1985-10-20','9999-01-01'),
                            (10014,'Engineer','1993-12-29','9999-01-01'),
                            (10015,'Senior Staff','1992-09-19','1993-08-22');

INSERT INTO `salaries` (emp_no, salary, from_date, to_date) VALUES
                              (10001,85112,'2000-06-22','2001-06-22'),
                              (10001,85097,'2001-06-22','2002-06-22'),
                              (10001,88958,'2002-06-22','9999-01-01'),
                              (10002,69366,'1999-08-03','2000-08-02'),
                              (10002,71963,'2000-08-02','2001-08-02'),
                              (10002,72527,'2001-08-02','9999-01-01'),
                              (10003,43699,'2000-12-01','2001-12-01'),
                              (10003,43311,'2001-12-01','9999-01-01'),
                              (10004,67096,'1998-11-28','1999-11-28'),
                              (10004,69722,'1999-11-28','2000-11-27'),
                              (10004,70698,'2000-11-27','2001-11-27'),
                              (10004,74057,'2001-11-27','9999-01-01'),
                              (10005,60098,'2000-08-02','2001-08-02'),
                              (10005,59755,'2001-08-02','9999-01-01');

