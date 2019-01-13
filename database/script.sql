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

CREATE TABLE employees (
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