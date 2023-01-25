package com.uf6.ad4.services;
import com.uf6.ad4.model.entity.ComercialEntity;
import java.util.List;


/**
 * Interfaz de servicios para la entidad Comercial.
 *
 * @author Raul Herrera
 * @author Pavlo Dudnyk
 * @version 1.0
 */
public interface ComercialServices {


    ComercialEntity findById(int idComercial);
    boolean crearUno(ComercialEntity comercial);
    List<ComercialEntity> findAll();
    boolean borrarUno(int idComercial);
    List<ComercialEntity> comercialQueVendeACliente(int idCliente);
    List<ComercialEntity> comercialesConPedidos();


}
