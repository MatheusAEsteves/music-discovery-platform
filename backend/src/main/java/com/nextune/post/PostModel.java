package com.nextune.post;

import com.nextune.artista.ArtistaModel;
import com.nextune.genero.GeneroModel;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "post")
public class PostModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JdbcTypeCode(SqlTypes.BINARY)
    private UUID id;

    @Column(nullable = false, length = 150)
    private String titulo;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @Column(name = "arquivo_audio", nullable = false, length = 255)
    private String arquivoAudio;

    @Column(nullable = false, length = 255)
    private String capa;

    @Column(name = "link_musica", nullable = false, length = 255)
    private String linkMusica;

    @Column(name = "data_publicacao", nullable = false, updatable = false)
    private LocalDate dataPublicacao;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "artista_id", nullable = false, updatable = false)
    private ArtistaModel artista;

    @ManyToMany
    @JoinTable(
            name = "post_has_genero",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "genero_id")
    )
    private Set<GeneroModel> generos = new HashSet<>();

    protected PostModel() {}

    public PostModel(ArtistaModel artista, String titulo, String descricao,
                     String arquivoAudio, String capa, String linkMusica) {
        this.artista = artista;
        this.titulo = titulo;
        this.descricao = descricao;
        this.arquivoAudio = arquivoAudio;
        this.capa = capa;
        this.linkMusica = linkMusica;
        this.dataPublicacao = LocalDate.now();
    }

    public UUID getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getDescricao() { return descricao; }
    public String getArquivoAudio() { return arquivoAudio; }
    public String getCapa() { return capa; }
    public String getLinkMusica() { return linkMusica; }
    public LocalDate getDataPublicacao() { return dataPublicacao; }
    public ArtistaModel getArtista() { return artista; }
    public Set<GeneroModel> getGeneros() { return generos; }

    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public void setCapa(String capa) { this.capa = capa; }
    public void setLinkMusica(String linkMusica) { this.linkMusica = linkMusica; }

    public void addGenero(GeneroModel genero) { this.generos.add(genero); }
    public void removeGenero(GeneroModel genero) { this.generos.remove(genero); }
}