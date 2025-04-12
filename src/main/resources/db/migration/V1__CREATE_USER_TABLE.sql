CREATE TABLE IF NOT EXISTS usuarios (
  id SERIAL PRIMARY KEY,
  nome VARCHAR(100) NOT NULL,
  email VARCHAR(100) NOT NULL UNIQUE,
  senha VARCHAR(200) NOT NULL,
  status VARCHAR(50),
  permissao VARCHAR(50)
  -- ...
);

INSERT INTO usuarios(email,senha)
VALUES('email@example.com','$2a$10$gIBGL7D7tu.VR0fV65y/MuYy8022yuXeoqefz3D4P0IuSoRz/LAKO')