package com.uf6.ad4.services;
import com.uf6.ad4.model.entity.PedidoEntity;
import com.uf6.ad4.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServicesImpl implements PedidoServices {


    // Atributos

    @Autowired
    private PedidoRepository pedido;


    // Métodos Implementados


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
