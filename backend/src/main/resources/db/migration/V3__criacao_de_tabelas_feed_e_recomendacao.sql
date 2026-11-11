    CREATE TABLE IF NOT EXISTS preferencia_usuario (
      id BINARY(16) NOT NULL,
      usuario_id BINARY(16) NOT NULL,
      genero_id BIGINT NOT NULL,
      pontuacao INT NOT NULL DEFAULT 0,
      data_atualizacao DATE NOT NULL,

      PRIMARY KEY (id),
      UNIQUE INDEX usuario_genero_UNIQUE (usuario_id, genero_id),
      INDEX fk_preferencia_usuario_genero_idx (genero_id),

      CONSTRAINT fk_preferencia_usuario_usuario
        FOREIGN KEY (usuario_id)
        REFERENCES usuario (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,

      CONSTRAINT fk_preferencia_usuario_genero
        FOREIGN KEY (genero_id)
        REFERENCES genero (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
    );

    CREATE TABLE IF NOT EXISTS interacao (
        usuario_id BINARY(16) NOT NULL,
        post_id BINARY(16) NOT NULL,
        curtido BOOLEAN NOT NULL DEFAULT FALSE,
        salvo BOOLEAN NOT NULL DEFAULT FALSE,
        pulou BOOLEAN NOT NULL DEFAULT FALSE,
        segundos_ouvidos INT NOT NULL DEFAULT 0,
        data_criacao DATE NOT NULL,
        data_atualizacao DATE NOT NULL,

        PRIMARY KEY (usuario_id, post_id),
        INDEX interacao_post_curtido_idx (post_id, curtido),
        INDEX interacao_usuario_data_idx (usuario_id, data_atualizacao),

        CONSTRAINT fk_interacao_usuario
        FOREIGN KEY (usuario_id) REFERENCES usuario (id)
        ON DELETE CASCADE ON UPDATE CASCADE,

        CONSTRAINT fk_interacao_post
        FOREIGN KEY (post_id) REFERENCES post (id)
        ON DELETE CASCADE ON UPDATE CASCADE
        );