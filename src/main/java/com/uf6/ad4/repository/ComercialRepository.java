package com.uf6.ad4.repository;
import com.uf6.ad4.model.entity.ComercialEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;


/**
 * Interfaz para dar acceso a los métodos JPA y query's personalizados de la tabla comerciales.
 *
 * @author Raúl Herrera
 * @author Pavlo Dudnyk
 * @version 1.0
 */
public interface ComercialRepository extends JpaRepository<ComercialEntity, Integer> {


    @Query(value = "select * from comerciales where id_comercial in" +
            "(select id_comercial from pedidos where id_cliente = ?)", nativeQuery = true)
    List<ComercialEntity> comercialQueVendeACliente(int idCliente);

    @Query(value = "select * from comerciales where id_comercial in (select id_comercial from pedidos)" +
            "order by id_comercial", nativeQuery = true)
    List<ComercialEntity> comercialesConPedidos();


}
