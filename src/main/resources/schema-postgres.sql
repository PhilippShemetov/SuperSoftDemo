-- DROP TABLE IF EXISTS emp;
-- CREATE TABLE emp(id serial PRIMARY KEY, name VARCHAR(255), role VARCHAR(255));
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS tasks;
DROP TABLE IF EXISTS projects;
CREATE TABLE IF NOT EXISTS users
(
    id_user serial PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    login VARCHAR(255),
    accepted boolean,
    user_type VARCHAR(255),
    password VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS tasks
(
task_id serial PRIMARY KEY,
task_name VARCHAR (255),
description VARCHAR(1000),
task_status boolean,
assigned_to VARCHAR (255),
date_start DATE NOT NULL DEFAULT CURRENT_DATE,
date_end DATE NOT NULL
);

CREATE TABLE IF NOT EXISTS projects
(
    id_project serial PRIMARY KEY,
    project_name VARCHAR (255),
    id_manager bigint,
    description VARCHAR (1000),
    date_start DATE NOT NULL DEFAULT CURRENT_DATE,
    date_end DATE NOT NULL
);