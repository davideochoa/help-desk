package com.helpdesk.application.app.data.repository;

import com.helpdesk.application.app.data.DAO.EstatusDAO;
import com.helpdesk.application.app.data.entity.EstatusEntity;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import java.util.List;

public interface EstatusRepository extends JpaRepository<EstatusEntity, Integer> {
    public List<EstatusEntity> findByFolioOrderByFecha(Integer Folio);

    @Query("SELECT new com.helpdesk.application.app.data.DAO.EstatusDAO( " +
            "e.id, " +
            "e.folio, " +
            "e.idEstatus, " +
            "ce.nombre," +
            "e.anotacion, " +
            "e.idUsuario, " +
            "cs.nombrePropio," +
            "e.fecha) " +
            "FROM EstatusEntity e,CatalogoEstatusEntity ce, UsuarioSoporteEntity cs " +
            "WHERE e.folio = :folio " +
            "AND ce.id = e.idEstatus " +
            "AND cs.id = e.idUsuario " +
            "ORDER BY e.fecha")
    public default List<EstatusDAO> findAllDAO(Integer folio) {
        return null;
    }

}
