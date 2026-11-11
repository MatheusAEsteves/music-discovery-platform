CREATE TABLE IF NOT EXISTS post (
  id BINARY(16) NOT NULL,
  titulo VARCHAR(150) NOT NULL,
  descricao TEXT NULL,
  arquivo_audio VARCHAR(255) NOT NULL,
  capa VARCHAR(255) NOT NULL,
  link_musica VARCHAR(255) NOT NULL,
  data_publicacao DATE NOT NULL,
  artista_id BINARY(16) NOT NULL,

  PRIMARY KEY (id),
  INDEX fk_post_artista_idx (artista_id),

  CONSTRAINT fk_post_artista
    FOREIGN KEY (artista_id)
    REFERENCES artista (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS genero (
  id BIGINT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(80) NOT NULL,

  PRIMARY KEY (id),
  UNIQUE INDEX genero_nome_UNIQUE (nome)
);

CREATE TABLE IF NOT EXISTS post_has_genero (
  post_id BINARY(16) NOT NULL,
  genero_id BIGINT NOT NULL,

  PRIMARY KEY (post_id, genero_id),
  INDEX fk_post_has_genero_genero_idx (genero_id),

  CONSTRAINT fk_post_has_genero_post
    FOREIGN KEY (post_id)
    REFERENCES post (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,

  CONSTRAINT fk_post_has_genero_genero
    FOREIGN KEY (genero_id)
    REFERENCES genero (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);