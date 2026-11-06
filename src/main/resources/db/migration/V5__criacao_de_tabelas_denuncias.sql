CREATE TABLE IF NOT EXISTS denuncia (
  id BINARY(16) NOT NULL,
  usuario_id BINARY(16) NOT NULL,
  post_id BINARY(16) NULL,
  artista_id BINARY(16) NULL,
  motivo VARCHAR(100) NOT NULL,
  descricao TEXT NULL,
  status ENUM('PENDENTE', 'ANALISADA', 'RESOLVIDA') NOT NULL DEFAULT 'PENDENTE',
  data_denuncia DATETIME NOT NULL,

  PRIMARY KEY (id),
  INDEX fk_denuncia_usuario_idx (usuario_id),
  INDEX fk_denuncia_post_idx (post_id),
  INDEX fk_denuncia_artista_idx (artista_id),

  CONSTRAINT fk_denuncia_usuario
    FOREIGN KEY (usuario_id)
    REFERENCES usuario (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,

  CONSTRAINT fk_denuncia_post
    FOREIGN KEY (post_id)
    REFERENCES post (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,

  CONSTRAINT fk_denuncia_artista
    FOREIGN KEY (artista_id)
    REFERENCES artista (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);