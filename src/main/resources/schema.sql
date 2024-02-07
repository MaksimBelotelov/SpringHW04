CREATE TABLE IF NOT EXISTS personTable ( id INT AUTO_INCREMENT PRIMARY KEY,
                                         name varchar(50) NOT NULL,
                                         phone varchar(50) NOT NULL,
                                         email varchar(50) NOT NULL,
                                         note varchar(100) NOT NULL);

INSERT INTO personTable (name, phone, email, note) VALUES ('Katty', '+79998887766','kate@mail.ru', 'Next door girl'),
                                                          ('John', '+79001112233', 'long_johnt@mail.ru', 'Work'),
                                                          ('Tom', '+79115554463','tommygun@mail.ru', 'Running together');
