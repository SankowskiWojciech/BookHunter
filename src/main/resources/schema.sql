DROP TABLE USER_AUTHENTICATION;
DROP TABLE AUTHOR;

CREATE TABLE USER_AUTHENTICATION(
    USER_NAME VARCHAR(20) PRIMARY KEY NOT NULL UNIQUE,
    PASSWORD VARCHAR(60) NOT NULL,
    EMAIL_ADDRESS VARCHAR(30) NOT NULL UNIQUE
);

CREATE TABLE AUTHOR(
    ID BIGINT PRIMARY KEY NOT NULL UNIQUE,
    NAME VARCHAR(15) NOT NULL,
    SURNAME VARCHAR(20) NOT NULL,
    BIRTH_YEAR VARCHAR(4),
    DEATH_YEAR VARCHAR(4),
    IMAGE BYTEA,
    DESCRIPTION VARCHAR(5000),
    GENRES VARCHAR
);
