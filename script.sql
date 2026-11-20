CREATE DATABASE IF NOT EXISTS gta6;
USE gta6;

CREATE TABLE IF NOT EXISTS personagem (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    cidade VARCHAR(50) NOT NULL,
    tipo VARCHAR(20) NOT NULL,          -- 'PERSONAGEM' ou 'CRIMINOSO'
    nivel_procurado INT,                -- só criminoso (1 a 5)
    crime_principal VARCHAR(60)         -- só criminoso
);

INSERT INTO personagem (nome, cidade, tipo, nivel_procurado, crime_principal) VALUES
('Lucia', 'Leonida', 'CRIMINOSO', 4, 'Assalto a mão armada'),
('Jason', 'Vice City', 'CRIMINOSO', 3, 'Tráfico'),
('Taxista Raul', 'Vice City', 'PERSONAGEM', NULL, NULL);

SELECT * FROM personagem;
