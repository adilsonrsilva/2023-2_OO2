CREATE TABLE pessoa (
   id INT NOT NULL AUTO_INCREMENT,
   nome varchar (50) NOT NULL,
   idade INT,
   email varchar (50) NOT NULL,
   PRIMARY KEY (id)
);

INSERT INTO pessoa (nome, idade, email) VALUES ('Joao', 20, 'joao@gmail.com');
INSERT INTO pessoa (nome, idade, email) VALUES ('Joanna', 25, 'joanna@gmail.com');
