CREATE TABLE IF NOT EXISTS Pizza (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    preco DOUBLE PRECISION NOT NULL,
    disponivel BOOLEAN NOT NULL,
    tamanho VARCHAR(50) NOT NULL,
    sabor VARCHAR(50) NOT NULL
);