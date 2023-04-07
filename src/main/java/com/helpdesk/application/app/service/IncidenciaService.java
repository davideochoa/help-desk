package com.helpdesk.application.app.service;

import com.helpdesk.application.app.data.entity.IncidenciaEntity;
import com.helpdesk.application.app.facade.IncidenciaFacade;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IncidenciaService {
    private IncidenciaFacade incidenciaFacade;
    public IncidenciaService(IncidenciaFacade incidenciaFacade) {
        this.incidenciaFacade = incidenciaFacade;
    }

    public List<IncidenciaEntity> findAll(){
        return incidenciaFacade.findAll();
    }

    public Optional<IncidenciaEntity> findById(Integer Id){
        return incidenciaFacade.findById(Id);
    }

    public IncidenciaEntity save(IncidenciaEntity incidenciaEntity){
        return incidenciaFacade.save(incidenciaEntity);
    }
}
