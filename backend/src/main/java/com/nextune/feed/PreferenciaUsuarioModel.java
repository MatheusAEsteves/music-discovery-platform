package com.nextune.feed;

import com.nextune.genero.GeneroModel;
import com.nextune.usuario.UsuarioModel;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(
        name = "preferencia_usuario",
        uniqueConstraints = @UniqueConstraint(columnNames = {"usuario_id", "genero_id"})
)
public class PreferenciaUsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JdbcTypeCode(SqlTypes.BINARY)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "usuario_id", nullable = false, updatable = false)
    private UsuarioModel usuario;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "genero_id", nullable = false, updatable = false)
    private GeneroModel genero;

    @Column(nullable = false)
    private int pontuacao = 0;

    @Column(name = "data_atualizacao", nullable = false, insertable = false, updatable = false)
    private LocalDateTime dataAtualizacao;

    protected PreferenciaUsuarioModel() {}

    public PreferenciaUsuarioModel(UsuarioModel usuario, GeneroModel genero, int pontuacao) {
        this.usuario = usuario;
        this.genero = genero;
        this.pontuacao = pontuacao;
    }

    public UUID getId() { return id; }
    public UsuarioModel getUsuario() { return usuario; }
    public GeneroModel getGenero() { return genero; }
    public int getPontuacao() { return pontuacao; }
    public LocalDateTime getDataAtualizacao() { return dataAtualizacao; }

    public void adicionarPontos(int pontos) { this.pontuacao += pontos; }
}