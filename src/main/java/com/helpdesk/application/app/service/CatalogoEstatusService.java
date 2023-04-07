package com.helpdesk.application.app.service;

import com.helpdesk.application.app.data.entity.CatalogoEstatusEntity;
import com.helpdesk.application.app.facade.CatalogoEstatusFacade;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogoEstatusService {
    private CatalogoEstatusFacade catalogoEstatusFacade;
    public CatalogoEstatusService(CatalogoEstatusFacade catalogoEstatusFacade) {
        this.catalogoEstatusFacade = catalogoEstatusFacade;
    }

    public List<CatalogoEstatusEntity> findAll(){
        return catalogoEstatusFacade.findAll();
    }
}
