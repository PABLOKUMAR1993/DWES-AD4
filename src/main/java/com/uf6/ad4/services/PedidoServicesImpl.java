package com.uf6.ad4.services;
import com.uf6.ad4.model.entity.PedidoEntity;
import com.uf6.ad4.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


/**
 * Esta clase implementa los métodos de la interfaz PedidoServices.
 *
 * @author Raúl Herrera
 * @author Pavlo Dudnyk
 * @version 1.0
 */
@Service
public class PedidoServicesImpl implements PedidoServices {


    // Atributos

    @Autowired
    private PedidoRepository pedido;


    // Métodos Implementados


    /**
     * Este método devuelve una lista de pedidos de la base de datos, de un comercial por indicado por su id.
     *
     * @param idComercial id del comercial del cual quieres consultar los pedidos.
     * @return List<PedidoEntity> o null si no si no hay pedidos hechos.
     */
    @Override
    public List<PedidoEntity> pedidosDeComercial( int idComercial ) {

        try {
            return this.pedido.pedidosDeComercial( idComercial );
        } catch ( Exception e ){
            e.printStackTrace();
            return null;
        }

    }

}
