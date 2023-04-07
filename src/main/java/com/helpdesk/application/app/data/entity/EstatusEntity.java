package com.helpdesk.application.app.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "estatus")
public class EstatusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    Integer id;

    @Column(name = "Folio")
    Integer folio;

    @Column(name = "IdEstatus")
    Integer idEstatus;
/*
    @OneToOne
    CatalogoEstatusEntity catalogoEstatusEntity;*/

    @Column(name = "Anotacion")
    String anotacion;

    @Column(name = "IdUsuario")
    Integer idUsuario;

    //@Column(name = "Fecha", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    //Date fecha;

    @Column(name = "Fecha")
    @CreationTimestamp
    LocalDate fecha;

    @Override
    public String toString(){
        return "getId:"+getId()+
                ":getFolio:"+getFolio()+
                ":getIdEstatus:"+getIdEstatus()+
                ":getIdUsuario:"+getIdUsuario()+
                ":getFecha:"+getFecha()+
                ":getAnotacion:"+getAnotacion();
    }
}
