INSERT INTO USER_AUTHENTICATION (USER_NAME, PASSWORD, EMAIL_ADDRESS) VALUES ('test1', '$2a$11$EK9Pd3oqp.eCmcN8p./m5.vUBhI18vqpH7o4C46KTnPT5qLfSQrvK', 'test1@gmail.com');
INSERT INTO USER_AUTHENTICATION (USER_NAME, PASSWORD, EMAIL_ADDRESS) VALUES ('test2', '$2a$11$fdopn/kREcecXxVytgiDt.HSIMXfyV0CrzTC9iEfavIksn/MQsXuO', 'test2@gmail.com');
INSERT INTO USER_AUTHENTICATION (USER_NAME, PASSWORD, EMAIL_ADDRESS) VALUES ('test3', '$2a$11$jzr7uyY0LVdqgGehTcsZQ.xoBot/J3Kxlgdn7QkLoCx48L16O86aK', 'test3@gmail.com');

INSERT INTO AUTHOR (ID, NAME, SURNAME, BIRTH_YEAR, DEATH_YEAR, PROFILE_PHOTO, DESCRIPTION, CATEGORIES) VALUES (1, 'test name', 'test surname', '1996', '2106', NULL, 'test description', 'SCIENCE_FICTION BIOGRAPHY');
INSERT INTO AUTHOR (ID, NAME, SURNAME, BIRTH_YEAR, DEATH_YEAR, PROFILE_PHOTO, DESCRIPTION, CATEGORIES) VALUES (2, 'Wojciech', 'Sankowski', '1996', NULL, NULL, 'Junior Java Developer', 'SCIENCE ART');
INSERT INTO AUTHOR (ID, NAME, SURNAME, BIRTH_YEAR, DEATH_YEAR, PROFILE_PHOTO, DESCRIPTION, CATEGORIES) VALUES (3, 'Matylda', 'Wacławska', '1995', NULL, NULL, 'Great chemist!', 'ART CLASSIC');

INSERT INTO BOOK (ISBN, TITLE, ORIGINAL_TITLE, RELEASE_YEAR, CATEGORIES, DESCRIPTION, COUNTRY_CODE, COVER_IMAGE) VALUES ('1234567890123', 'Brief Answers to the Big Questions', 'Brief Answers to the Big Questions', '2018', 'SCIENCE BIOGRAPHY HUMOR', 'Stephen Hawking was the most renowned scientist since Einstein, known both for his groundbreaking work in physics and cosmology and for his mischievous sense of humor. He educated millions of readers about the origins of the universe and the nature of black holes, and inspired millions more by defying a terrifying early prognosis of ALS, which originally gave him only two years to live. In later life he could communicate only by using a few facial muscles, but he continued to advance his field and serve as a revered voice on social and humanitarian issues.

Hawking not only unraveled some of the universe’s greatest mysteries but also believed science plays a critical role in fixing problems here on Earth. Now, as we face immense challenges on our planet—including climate change, the threat of nuclear war, and the development of artificial intelligence—he turns his attention to the most urgent issues facing us.

Will humanity survive? Should we colonize space? Does God exist? These are just a few of the questions Hawking addresses in this wide-ranging, passionately argued final book from one of the greatest minds in history.

Featuring a foreword by Eddie Redmayne, who won an Oscar for playing Stephen Hawking, an introduction by Nobel Laureate Kip Thorne, and an afterword from Hawking’s daughter, Lucy, Brief Answers to the Big Questions is a brilliant last message to the world. ', 'US', NULL);
INSERT INTO BOOK (ISBN, TITLE, ORIGINAL_TITLE, RELEASE_YEAR, CATEGORIES, DESCRIPTION, COUNTRY_CODE, COVER_IMAGE) VALUES ('0987654321098', 'Test Title 2', 'Test Original Title 2', '2009', 'ROMANCE BIOGRAPHY RELIGION', 'Test Description 2', 'RU', NULL);

INSERT INTO BOOK_AUTHOR_RELATIONS (ID, BOOK_ID, AUTHOR_ID) VALUES (1, '1234567890123', '1');
INSERT INTO BOOK_AUTHOR_RELATIONS (ID, BOOK_ID, AUTHOR_ID) VALUES (2, '1234567890123', '2');
INSERT INTO BOOK_AUTHOR_RELATIONS (ID, BOOK_ID, AUTHOR_ID) VALUES (3, '1234567890123', '3');