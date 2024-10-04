CREATE TABLE IF NOT EXISTS Acessos (
    id BIGSERIAL PRIMARY KEY,
    nivel VARCHAR(50) NOT NULL UNIQUE,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);


CREATE TABLE IF NOT EXISTS Users (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    email VARCHAR NOT NULL UNIQUE,
    encrypted_password VARCHAR(255) NOT NULL,
    acesso_id INTEGER NOT NULL,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    FOREIGN KEY (acesso_id) REFERENCES Acessos(id)
);

