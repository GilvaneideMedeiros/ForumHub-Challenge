-- Tabela de Cursos
CREATE TABLE cursos (
                        id BIGINT NOT NULL AUTO_INCREMENT,
                        nome VARCHAR(100) NOT NULL,
                        categoria VARCHAR(100) NOT NULL,
                        PRIMARY KEY (id)
);

-- Tabela de Usuários
CREATE TABLE usuarios (
                          id BIGINT NOT NULL AUTO_INCREMENT,
                          nome VARCHAR(100) NOT NULL,
                          email VARCHAR(100) NOT NULL UNIQUE,
                          senha VARCHAR(255) NOT NULL,
                          PRIMARY KEY (id)
);

-- Tabela de Perfis (Roles)
CREATE TABLE perfis (
                        id BIGINT NOT NULL AUTO_INCREMENT,
                        nome VARCHAR(100) NOT NULL,
                        PRIMARY KEY (id)
);

-- Tabela de Junção entre Usuários e Perfis
CREATE TABLE usuarios_perfis (
                                 usuario_id BIGINT NOT NULL,
                                 perfil_id BIGINT NOT NULL,
                                 PRIMARY KEY (usuario_id, perfil_id),
                                 FOREIGN KEY (usuario_id) REFERENCES usuarios(id),
                                 FOREIGN KEY (perfil_id) REFERENCES perfis(id)
);

-- Tabela de Tópicos
CREATE TABLE topicos (
                         id BIGINT NOT NULL AUTO_INCREMENT,
                         titulo VARCHAR(100) NOT NULL UNIQUE,
                         mensagem TEXT NOT NULL,
                         data_criacao DATETIME NOT NULL,
                         estado VARCHAR(100) NOT NULL,
                         autor VARCHAR(100) NOT NULL,
                         curso_id BIGINT NOT NULL,
                         PRIMARY KEY (id),
                         FOREIGN KEY (curso_id) REFERENCES cursos(id)
);

-- Inserindo dados iniciais
-- Perfil padrão
INSERT INTO perfis(id, nome) VALUES (1, 'ROLE_USER');

-- Usuário padrão (admin)
INSERT INTO usuarios(id, nome, email, senha) VALUES(1, 'Admin User', 'admin@forumhub.com', '$2a$10$Y50UaMFOxteibQEYLrwuHeehHYfcoafCopUazP12.rqB41bsolF5.');

-- Associando o usuário admin ao perfil ROLE_USER
INSERT INTO usuarios_perfis(usuario_id, perfil_id) VALUES(1, 1);

-- Inserindo um curso de exemplo
INSERT INTO cursos(nome, categoria) VALUES('Spring Boot 3', 'BACK_END');

-- Inserindo um tópico de exemplo associado ao curso e ao usuário admin
INSERT INTO topicos(titulo, mensagem, data_criacao, estado, autor, curso_id)
VALUES('Dúvida sobre Injeção de Dependência', 'Qual a diferença real entre @Autowired em campo e injeção por construtor?', '2025-08-16 22:30:00', 'NAO_RESPONDIDO', 'Admin User', 1);