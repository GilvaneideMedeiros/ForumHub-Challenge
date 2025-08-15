CREATE TABLE cursos (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL UNIQUE,
    PRIMARY KEY (id)
);

CREATE TABLE topicos (
    id BIGINT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(100) NOT NULL UNIQUE,
    mensagem TEXT NOT NULL,
    data_criacao DATETIME NOT NULL,
    estado_topico VARCHAR(50) NOT NULL,
    autor VARCHAR(100) NOT NULL,
    curso_id BIGINT,
    PRIMARY KEY (id),
    FOREIGN KEY (curso_id) REFERENCES cursos(id)
);