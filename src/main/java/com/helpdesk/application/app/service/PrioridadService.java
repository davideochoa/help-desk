package com.helpdesk.application.app.service;

import com.helpdesk.application.app.data.entity.PrioridadEntity;
import com.helpdesk.application.app.facade.PrioridadFacade;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrioridadService {
    private PrioridadFacade prioridadFacade;
    public PrioridadService(PrioridadFacade prioridadFacade) {
        this.prioridadFacade = prioridadFacade;
    }

    public List<PrioridadEntity> findAll(){
        return prioridadFacade.findAll();
    }

    public Optional<PrioridadEntity> findById(Integer Id){
        return prioridadFacade.findById(Id);
    }
}
