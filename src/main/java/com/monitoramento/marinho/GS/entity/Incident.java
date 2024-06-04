package com.monitoramento.marinho.GS.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="GS_INCIDENTE")
@SequenceGenerator(name="incidente", sequenceName = "SQ_GS_INCIDENTE", allocationSize = 1)
public class Incident {

    @Id
    @Column(name="id_incidente")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "incidente")
    private Long id;

    @Column (name = "tipo", nullable = false)
    @NotBlank
    private String tipo;

    @Column(length = 1000)
    private String descricao;

    @Column(nullable = false)
    private String lugar;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false)
    private User usuario;


    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }


    public Incident(String tipo, String descricao, String lugar, LocalDateTime timestamp, User usuario) {
        this.tipo = tipo;
        this.descricao = descricao;
        this.lugar = lugar;
        this.timestamp = timestamp;
        this.usuario = usuario;
    }

    public Incident(String tipo, String descricao, String lugar, LocalDateTime timestamp) {
        this.tipo = tipo;
        this.descricao = descricao;
        this.lugar = lugar;
        this.timestamp = timestamp;
    }

    public Incident(){

    }
}
