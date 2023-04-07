package com.helpdesk.application.app.data.DAO;

import com.helpdesk.application.app.data.entity.EstatusEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EstatusDAO{
    Integer id;
    Integer folio;
    Integer idEstatus;
    String nombre;
    String anotacion;
    Integer idUsuario;
    String nombrePropio;
    //Date fecha;
    LocalDate fecha;

    public EstatusEntity getEntity(){
        EstatusEntity estatusEntity = new EstatusEntity();
        estatusEntity.setId(getId());
        estatusEntity.setFolio(getFolio());
        estatusEntity.setIdEstatus(getIdEstatus());
        estatusEntity.setAnotacion(getAnotacion());
        estatusEntity.setIdUsuario(getIdUsuario());
        estatusEntity.setFecha(getFecha());

        return estatusEntity;
    }
}
