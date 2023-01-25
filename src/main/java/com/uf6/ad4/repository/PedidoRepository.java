package com.uf6.ad4.repository;
import com.uf6.ad4.model.entity.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;


/**
 * Interfaz para dar acceso a los métodos JPA y query's personalizados de la tabla pedidos.
 *
 * @author Raúl Herrera
 * @author Pavlo Dudnyk
 * @version 1.0
 */
public interface PedidoRepository extends JpaRepository<PedidoEntity, Integer> {


    @Query(value = "select * from pedidos where id_comercial = ?;", nativeQuery = true)
    List<PedidoEntity> pedidosDeComercial(int idComercial);


}
