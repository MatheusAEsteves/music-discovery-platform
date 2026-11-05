CREATE TABLE IF NOT EXISTS usuario (
  id BINARY(16) NOT NULL,
  nome VARCHAR(150) NOT NULL,
  email VARCHAR(150) NOT NULL,
  senha VARCHAR(255) NOT NULL,
  foto_perfil VARCHAR(255) NOT NULL,
  bio TEXT NULL,
  tipo ENUM('USER', 'ARTIST') NOT NULL,
  data_criacao DATETIME NOT NULL,
  role VARCHAR(30) NOT NULL,
  enabled TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY (id),
  UNIQUE INDEX email_UNIQUE (email)
);

CREATE TABLE IF NOT EXISTS artista (
  id BINARY(16) NOT NULL,
  usuario_id BINARY(16) NOT NULL,
  nome_artistico VARCHAR(100) NOT NULL,
  descricao TEXT NULL,
  instagram_url VARCHAR(255) NULL,
  spotify_url VARCHAR(255) NULL,
  youtube_url VARCHAR(255) NULL,

  PRIMARY KEY (id),
  UNIQUE INDEX usuario_id_UNIQUE (usuario_id),

  CONSTRAINT fk_artista_usuario
    FOREIGN KEY (usuario_id)
    REFERENCES usuario (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);