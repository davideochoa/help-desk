package com.helpdesk.application.app.data.repository;

import com.helpdesk.application.app.data.entity.BienEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface BienRepository extends JpaRepository<BienEntity, Integer>{

    List<BienEntity> findByIdTipoIncidenciaOrderByNombreAsc(Integer IdTipoIncidencia);

    public BienEntity findByIdAndIdTipoIncidencia(Integer Id, Integer IdTipoIncidencia);
}
