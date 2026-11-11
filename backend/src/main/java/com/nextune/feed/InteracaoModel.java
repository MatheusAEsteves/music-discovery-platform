package com.nextune.feed;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "interacao")
public class InteracaoModel {

    @EmbeddedId
    private InteracaoId id;

    @Column(nullable = false)
    private boolean curtido = false;

    @Column(nullable = false)
    private boolean salvo = false;

    @Column(nullable = false)
    private boolean pulou = false;

    @Column(name = "segundos_ouvidos", nullable = false)
    private int segundosOuvidos = 0;

    @Column(name = "data_criacao", nullable = false, insertable = false, updatable = false)
    private LocalDate dataCriacao;

    @Column(name = "data_atualizacao", nullable = false, insertable = false, updatable = false)
    private LocalDate dataAtualizacao;

    protected InteracaoModel() {}

    public InteracaoModel(UUID usuarioId, UUID postId) {
        this.id = new InteracaoId(usuarioId, postId);
    }

    public InteracaoId getId() { return id; }
    public boolean isCurtido() { return curtido; }
    public boolean isSalvo() { return salvo; }
    public boolean isPulou() { return pulou; }
    public int getSegundosOuvidos() { return segundosOuvidos; }
    public LocalDate getDataCriacao() { return dataCriacao; }
    public LocalDate getDataAtualizacao() { return dataAtualizacao; }

    public void setCurtido(boolean curtido) { this.curtido = curtido; }
    public void setSalvo(boolean salvo) { this.salvo = salvo; }
    public void setPulou(boolean pulou) { this.pulou = pulou; }
    public void setSegundosOuvidos(int segundosOuvidos) { this.segundosOuvidos = segundosOuvidos; }
}
