package com.helpdesk.application.app.facade;

import com.helpdesk.application.app.data.entity.CatalogoEstatusEntity;
import com.helpdesk.application.app.data.repository.CatalogoEstatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional(readOnly = true)
public class CatalogoEstatusFacade {
    private CatalogoEstatusRepository catalogoEstatusRepository;

    @Autowired
    public CatalogoEstatusFacade(CatalogoEstatusRepository catalogoEstatusRepository) {
        this.catalogoEstatusRepository = catalogoEstatusRepository;
    }

    public List<CatalogoEstatusEntity> findAll(){
        return catalogoEstatusRepository.findAll();
    }
}
