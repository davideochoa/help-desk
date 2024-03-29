package com.helpdesk.application.app.service;

import com.helpdesk.application.app.data.entity.AreaEntity;
import com.helpdesk.application.app.facade.AreaFacade;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaService {
    private final AreaFacade areaFacade;
    public AreaService(AreaFacade areaFacade) {
        this.areaFacade = areaFacade;
    }

    public List<AreaEntity> findAll(){
        return areaFacade.findAll();
    }

    public List<AreaEntity> findByidUnidad(int idUnidad){
        return areaFacade.findByidUnidad(idUnidad);
    }

    public AreaEntity findByIdAndIdUnidad(Integer IdUnidad,Integer IdArea){
        return areaFacade.findByIdAndIdUnidad(IdUnidad,IdArea);
    }

    public AreaEntity save(AreaEntity areaEntity){
        return areaFacade.save(areaEntity);
    }
}
