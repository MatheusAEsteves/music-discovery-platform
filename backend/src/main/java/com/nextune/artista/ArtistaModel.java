package com.nextune.artista;

import com.nextune.usuario.UsuarioModel;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@Entity
@Table(name = "artista")
public class ArtistaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JdbcTypeCode(SqlTypes.BINARY)
    private UUID id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "usuario_id", nullable = false, unique = true, updatable = false)
    private UsuarioModel usuario;

    @Column(name = "nome_artistico", nullable = false, length = 100)
    private String nomeArtistico;

    @Column(name = "instagram_url", length = 255)
    private String instagramUrl;

    @Column(name = "spotify_url", length = 255)
    private String spotifyUrl;

    @Column(name = "youtube_url", length = 255)
    private String youtubeUrl;

    protected ArtistaModel() {}

    public ArtistaModel(UsuarioModel usuario, String nomeArtistico,
                        String instagramUrl, String spotifyUrl, String youtubeUrl) {
        this.usuario = usuario;
        this.nomeArtistico = nomeArtistico;
        this.instagramUrl = instagramUrl;
        this.spotifyUrl = spotifyUrl;
        this.youtubeUrl = youtubeUrl;
    }

    public UUID getId() { return id; }
    public UsuarioModel getUsuario() { return usuario; }
    public String getNomeArtistico() { return nomeArtistico; }
    public String getInstagramUrl() { return instagramUrl; }
    public String getSpotifyUrl() { return spotifyUrl; }
    public String getYoutubeUrl() { return youtubeUrl; }

    public void setNomeArtistico(String nomeArtistico) { this.nomeArtistico = nomeArtistico; }
    public void setInstagramUrl(String instagramUrl) { this.instagramUrl = instagramUrl; }
    public void setSpotifyUrl(String spotifyUrl) { this.spotifyUrl = spotifyUrl; }
    public void setYoutubeUrl(String youtubeUrl) { this.youtubeUrl = youtubeUrl; }

}