package com.helpdesk.application.app.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "catalogo_usuarios_soporte")
public class UsuarioSoporteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "NombrePropio")
    private String nombrePropio;

    @Column(name = "Correo")
    private String correo;

    @Column(name = "NombreUsuario")
    private String nombreUsuario;

    @Column(name = "Password")
    private String password;

    @Column(name = "EsAdministrador")
    private Boolean esAdministrador;

    @Column(name = "EsReseteadoPassword")
    private Boolean esReseteadoPassword;
/*
    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Role> roles;
*/
    @Column(name = "rol")
    private String rol;

    @Override
    public String toString(){
        return getId()+" : "+getNombreUsuario()+" : "+getNombrePropio()+" : "+getRol()+" : "+getEsReseteadoPassword();
    }
}
