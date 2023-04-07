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
@Table(name = "catalogo_estatus")
public class CatalogoEstatusEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;
/*
    @OneToOne(mappedBy="catalogoEstatusEntity")
    private EstatusEntity estatusEntity;
*/
    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Abrir")
    private Boolean abrir;

    @Column(name = "Cerrar")
    private Boolean cerrar;

    @Column(name = "Reasignar")
    private Boolean reasignar;

    @Column(name = "DiagnostinoInicial")
    private Boolean diagnostinoInicial;

    @Column(name = "DiagnostinoFinal")
    private Boolean diagnostinoFinal;
}
