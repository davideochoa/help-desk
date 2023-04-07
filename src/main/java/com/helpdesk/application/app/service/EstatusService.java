package com.helpdesk.application.app.service;

import com.helpdesk.application.app.data.DAO.EstatusDAO;
import com.helpdesk.application.app.data.entity.EstatusEntity;
import com.helpdesk.application.app.facade.EstatusFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class EstatusService {
    private final EstatusFacade estatusFacade;

    @Autowired
    public EstatusService(EstatusFacade estatusFacade) {
        this.estatusFacade = estatusFacade;
    }

    public List<EstatusEntity> findAll(){
        return estatusFacade.findAll();
    }

    public List<EstatusDAO> findAllDAO(Integer folio){
        return estatusFacade.findAllDAO(folio);
    }

    public List<EstatusEntity> findByFolioOrderByFecha(Integer Folio){
        return estatusFacade.findByFolioOrderByFecha(Folio);
    }

    public EstatusEntity save(EstatusEntity entity){
        return estatusFacade.save(entity);
    }
    public void deleteById(Integer Id){
        estatusFacade.deleteById(Id);
    }
    public void delete(EstatusEntity entity){
        estatusFacade.delete(entity);
    }

}
