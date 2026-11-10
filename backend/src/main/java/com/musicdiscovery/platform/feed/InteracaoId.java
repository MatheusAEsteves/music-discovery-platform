package com.musicdiscovery.platform.feed;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
public class InteracaoId implements Serializable {

    @JdbcTypeCode(SqlTypes.BINARY)
    @Column(name = "usuario_id")
    private UUID usuarioId;

    @JdbcTypeCode(SqlTypes.BINARY)
    @Column(name = "post_id")
    private UUID postId;

    protected InteracaoId() {}

    public InteracaoId(UUID usuarioId, UUID postId) {
        this.usuarioId = usuarioId;
        this.postId = postId;
    }

    public UUID getUsuarioId() { return usuarioId; }
    public UUID getPostId() { return postId; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InteracaoId that)) return false;
        return Objects.equals(usuarioId, that.usuarioId) && Objects.equals(postId, that.postId);
    }

    @Override
    public int hashCode() { return Objects.hash(usuarioId, postId); }
}
