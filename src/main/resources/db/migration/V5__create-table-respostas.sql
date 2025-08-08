CREATE TABLE respostas (
    id SERIAL PRIMARY KEY,
    mensagem VARCHAR(255) NOT NULL,
    topico_id INT NOT NULL,
    data_criacao TIMESTAMP NOT NULL,
    autor_id INT NOT NULL,
    solucao VARCHAR(255) NOT NULL,
    CONSTRAINT fk_resposta_topico FOREIGN KEY (topico_id) REFERENCES topicos(id),
    CONSTRAINT fk_resposta_autor FOREIGN KEY (autor_id) REFERENCES usuarios(id)
);
