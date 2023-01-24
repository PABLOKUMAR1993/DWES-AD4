package com.uf6.ad4.repository;

import com.uf6.ad4.model.entity.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PedidoRepository extends JpaRepository<PedidoEntity, Integer> {

    @Query( value = "select * from pedidos where id_comercial = ?;", nativeQuery = true )
    List<PedidoEntity> pedidosDeComercial( int idComercial );

}
