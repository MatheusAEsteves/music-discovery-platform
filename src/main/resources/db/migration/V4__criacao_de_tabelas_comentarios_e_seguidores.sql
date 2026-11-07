CREATE TABLE IF NOT EXISTS comentario (
  id BINARY(16) NOT NULL,
  usuario_id BINARY(16) NOT NULL,
  post_id BINARY(16) NOT NULL,
  conteudo TEXT NOT NULL,
  data_comentario DATETIME NOT NULL,

  PRIMARY KEY (id),
  INDEX fk_comentario_usuario_idx (usuario_id),
  INDEX fk_comentario_post_idx (post_id),

  CONSTRAINT fk_comentario_usuario
    FOREIGN KEY (usuario_id)
    REFERENCES usuario (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,

  CONSTRAINT fk_comentario_post
    FOREIGN KEY (post_id)
    REFERENCES post (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS seguidor (
  id BINARY(16) NOT NULL,
  usuario_id BINARY(16) NOT NULL,
  artista_id BINARY(16) NOT NULL,
  data_seguimento DATETIME NOT NULL,

  PRIMARY KEY (id),
  UNIQUE INDEX usuario_artista_UNIQUE (usuario_id, artista_id),
  INDEX fk_seguidor_artista_idx (artista_id),

  CONSTRAINT fk_seguidor_usuario
    FOREIGN KEY (usuario_id)
    REFERENCES usuario (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,

  CONSTRAINT fk_seguidor_artista
    FOREIGN KEY (artista_id)
    REFERENCES artista (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);
