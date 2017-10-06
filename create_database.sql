USE test;

DROP TABLE IF EXISTS book;
CREATE TABLE book(
 id INT(11) NOT NULL AUTO_INCREMENT,
 title VARCHAR(255),
 description VARCHAR(255),
 author VARCHAR(100),
 isbn VARCHAR(20),
 printYear INT,
 readAlready BIT NOT NULL DEFAULT 0,
PRIMARY KEY (id))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


INSERT INTO book (title, description, author, isbn, printYear, readAlready) VALUES
("Book 1", "Description 1", "Author 1", "978-3-16-148410-0", 2017, 0),
("Book 2", "Description 2", "Author 2", "978-3-16-148411-0", 2010, 0),
("Book 3", "Description 3", "Author 1", "978-3-16-148411-0", 2012, 1),
("Book 4", "Description 4", "Author 2", "978-3-16-148413-0", 2008, 1),
("Book 5", "Description 5", "Author 4", "978-3-16-148414-0", 1996, 0),
("Book 6", "Description 6", "Author 3", "978-3-16-148415-0", 2017, 0),
("Book 7", "Description 7", "Author 1", "978-3-16-148416-0", 2016, 0),
("Book 8", "Description 8", "Author 5", "978-3-16-148417-0", 2010, 0),
("Book 9", "Description 9", "Author 1", "978-3-16-148418-0", 2013, 0),
("Book 10", "Description 10", "Author 1", "978-3-16-148419-0", 2012, 0),
("Book 11", "Description 11", "Author 2", "978-3-16-148420-0", 1993, 0),
("Book 12", "Description 12", "Author 3", "978-3-16-148421-0", 1995, 0),
("Book 13", "Description 13", "Author 5", "978-3-16-148422-0", 1996, 0),
("Book 14", "Description 14", "Author 4", "978-3-16-148423-0", 1995, 0),
("Book 15", "Description 15", "Author 4", "978-3-16-148424-0", 1994, 0),
("Book 16", "Description 16", "Author 3", "978-3-16-148425-0", 2001, 0),
("Book 17", "Description 17", "Author 5", "978-3-16-148426-0", 2001, 0),
("Book 18", "Description 18", "Author 8", "978-3-16-148427-0", 2002, 0),
("Book 19", "Description 19", "Author 22", "978-3-16-148428-0", 2017, 0),
("Book 20", "Description 20", "Author 21", "978-3-16-148429-0", 2015, 0),
("Book 21", "Description 21", "Author 23", "978-3-16-148411-0", 1980, 0),
("Book 22", "Description 22", "Author 2", "978-3-16-148411-0", 1979, 0);

