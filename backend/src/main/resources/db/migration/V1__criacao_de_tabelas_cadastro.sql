CREATE TABLE IF NOT EXISTS usuario (
  id BINARY(16) NOT NULL,
  nome VARCHAR(150) NOT NULL,
  email VARCHAR(150) NOT NULL,
  senha VARCHAR(255) NOT NULL,
  foto_perfil VARCHAR(255) NULL,
  bio TEXT NULL,
  data_criacao DATE NOT NULL,
  role ENUM('USER', 'ADMIN') NOT NULL DEFAULT 'USER',
  enabled BOOLEAN NOT NULL DEFAULT TRUE,
  PRIMARY KEY (id),
  UNIQUE INDEX email_UNIQUE (email)
);

CREATE TABLE IF NOT EXISTS artista (
  id BINARY(16) NOT NULL,
  usuario_id BINARY(16) NOT NULL,
  nome_artistico VARCHAR(100) NOT NULL,
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