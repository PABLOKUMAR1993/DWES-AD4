package com.uf6.ad4.repository;
import com.uf6.ad4.model.entity.ComercialEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface ComercialRepository extends JpaRepository<ComercialEntity, Integer> {

    @Query("select c from ComercialEntity c")
    public List<ComercialEntity> findAll();

}
