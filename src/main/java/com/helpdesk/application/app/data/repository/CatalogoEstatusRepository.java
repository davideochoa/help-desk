package com.helpdesk.application.app.data.repository;

import com.helpdesk.application.app.data.entity.CatalogoEstatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

public interface CatalogoEstatusRepository extends JpaRepository<CatalogoEstatusEntity, Integer>{

}
