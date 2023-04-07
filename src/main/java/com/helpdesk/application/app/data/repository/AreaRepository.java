package com.helpdesk.application.app.data.repository;

import com.helpdesk.application.app.data.entity.AreaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface AreaRepository extends JpaRepository<AreaEntity, Integer> {
    List<AreaEntity> findByIdUnidadOrderByNombre(Integer IdUnidad);

    AreaEntity findByIdAndIdUnidad(Integer IdArea,Integer IdUnidad);
}
