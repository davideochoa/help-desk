package com.helpdesk.application.app.facade;

import com.helpdesk.application.app.data.entity.PrioridadEntity;
import com.helpdesk.application.app.data.repository.PrioridadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
@Transactional(readOnly = true)
public class PrioridadFacade {
    private PrioridadRepository prioridadRepository;

    @Autowired
    public PrioridadFacade(PrioridadRepository prioridadRepository) {
        this.prioridadRepository = prioridadRepository;
    }

    public List<PrioridadEntity> findAll(){
        return prioridadRepository.findAll();
    }

    public Optional<PrioridadEntity> findById(Integer Id){
        return prioridadRepository.findById(Id);
    }
}
