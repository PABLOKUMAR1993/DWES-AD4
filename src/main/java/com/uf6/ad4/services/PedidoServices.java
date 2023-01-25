package com.uf6.ad4.services;
import com.uf6.ad4.model.entity.PedidoEntity;
import java.util.List;


/**
 * Interfaz de servicios para la entidad Pedidos.
 *
 * @author Raul Herrera
 * @author Pavlo Dudnyk
 * @version 1.0
 */
public interface PedidoServices {


    List<PedidoEntity> pedidosDeComercial( int idComercial );


}
