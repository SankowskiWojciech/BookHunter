INSERT INTO USER_AUTHENTICATION (USER_NAME, PASSWORD, EMAIL_ADDRESS) VALUES ('test1', '$2a$11$EK9Pd3oqp.eCmcN8p./m5.vUBhI18vqpH7o4C46KTnPT5qLfSQrvK', 'test1@gmail.com');
INSERT INTO USER_AUTHENTICATION (USER_NAME, PASSWORD, EMAIL_ADDRESS) VALUES ('test2', '$2a$11$fdopn/kREcecXxVytgiDt.HSIMXfyV0CrzTC9iEfavIksn/MQsXuO', 'test2@gmail.com');
INSERT INTO USER_AUTHENTICATION (USER_NAME, PASSWORD, EMAIL_ADDRESS) VALUES ('test3', '$2a$11$jzr7uyY0LVdqgGehTcsZQ.xoBot/J3Kxlgdn7QkLoCx48L16O86aK', 'test3@gmail.com');

INSERT INTO AUTHOR (ID, NAME, SURNAME, BIRTH_YEAR, DEATH_YEAR, PROFILE_PHOTO, DESCRIPTION, CATEGORIES) VALUES (1, 'test name', 'test surname', '1996', '2106', NULL, 'test description', 'SCIENCE_FICTION BIOGRAPHY');

INSERT INTO BOOK (ISBN, TITLE, ORIGINAL_TITLE, RELEASE_YEAR, CATEGORIES, DESCRIPTION, COUNTRY_CODE, COVER_IMAGE) VALUES ('1234567890123', 'Test Title', 'Test Original Title', '1996', 'SCIENCE_FICTION BIOGRAPHY', 'Test Description', 'PL', NULL);
INSERT INTO BOOK (ISBN, TITLE, ORIGINAL_TITLE, RELEASE_YEAR, CATEGORIES, DESCRIPTION, COUNTRY_CODE, COVER_IMAGE) VALUES ('0987654321098', 'Test Title 2', 'Test Original Title 2', '2009', 'ROMANCE BIOGRAPHY RELIGION', 'Test Description 2', 'RU', NULL);

INSERT INTO BOOK_AUTHOR_RELATIONS (ID, BOOK_ID, AUTHOR_ID) VALUES (1, '1234567890123', '1');