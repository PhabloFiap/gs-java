package com.monitoramento.marinho.GS.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//import lombok.Getter;
//import lombok.Setter;
//import lombok.NoArgsConstructor;
//import lombok.AllArgsConstructor;
//import lombok.EqualsAndHashCode;

@Entity
@Table(name = "GS_USUARIO")
@SequenceGenerator(name="usuario", sequenceName = "SQ_GS_USUARIO", allocationSize = 1)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_usuario")
    private Long id;

    @Column(name ="nm_usuario", nullable = false)
    private String usuario;

    @Column(name ="senha", nullable = false)
    private String senha;

    @Column(name="role") //role: O papel do usuário no sistema (por exemplo, Admin, Researcher, Public).
    private String role;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.MERGE)
    @JsonIgnoreProperties("usuario")
    private List<Incident> incidents = new ArrayList<>();
//    private Set<Incident> incidents = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

//    public Set<Incident> getIncidents() {
//        return incidents;
//    }

//    public void setIncidents(Set<Incident> incidents) {
//        this.incidents = incidents;
//    }


    public List<Incident> getIncidents() {
        return incidents;
    }

    public void setIncidents(List<Incident> incidents) {
        this.incidents = incidents;
    }

    public User(){
    }

    public User(String usuario, String senha, String role, List<Incident> incidents) {
        this.usuario = usuario;
        this.senha = senha;
        this.role = role;
        this.incidents = incidents;
    }

    public User(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }
    //    public User(String usuario, String senha, String role, Set<Incident> incidents) {
//        this.usuario = usuario;
//        this.senha = senha;
//        this.role = role;
//        this.incidents = incidents;
//    }
}
