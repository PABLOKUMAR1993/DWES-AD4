package com.uf6.ad4.services;
import com.uf6.ad4.model.entity.ComercialEntity;
import com.uf6.ad4.repository.ComercialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


/**
 * Esta clase implementa los métodos de la interfaz ComercialServices.
 *
 * @author Raúl Herrera
 * @author Pavlo Dudnyk
 * @version 1.0
 */
@Service
public class ComercialServicesImpl implements ComercialServices {


    //Atributos


    @Autowired
    private ComercialRepository comercial;


    //Métodos Implementados


    /**
     * Este método devuelve un comercial de la base de datos, indicado por si id.
     *
     * @param idComercial id del comercial que quieres consultar.
     * @return ComercialEntity o null si no existe.
     */
    @Override
    public ComercialEntity findById(int idComercial) {
        return comercial.findById(idComercial).orElse(null);
    }

    /**
     * Este método crear un comercial en la base de datos.
     *
     * @return true si se ha creado correctamente, false si no.
     */
    @Override
    public boolean crearUno(ComercialEntity comercial) {

        try {
            this.comercial.save(comercial);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * Este método devuelve una lista de todos los comerciales de la base de datos.
     *
     * @return List<ComercialEntity>, la lista puede llegar vacía en caso de no haber comerciales.
     */
    @Override
    public List<ComercialEntity> findAll() {
        return this.comercial.findAll();
    }

    /**
     * Este método borra un comercial de la base de datos.
     *
     * @param idComercial id del comercial que quieres borrar.
     * @return true si se ha borrado correctamente, false si no.
     */
    @Override
    public boolean borrarUno(int idComercial) {

        try {
            this.comercial.deleteById(idComercial);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * Este método devuelve una lista de comerciales de la base de datos, que han vendido a un cliente identificado
     * por su id.
     *
     * @param idCliente id del cliente que quieres consultar.
     * @return List<ComercialEntity> si hay comerciales que han vendido a ese cliente o null si no.
     */
    @Override
    public List<ComercialEntity> comercialQueVendeACliente(int idCliente) {

        try {
            return this.comercial.comercialQueVendeACliente(idCliente);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * Este método devuelve una lista de comerciales de la base de datos, que han realizado alguna venta.
     *
     * @return List<ComercialEntity> si hay comerciales con ventas o null si no.
     */
    @Override
    public List<ComercialEntity> comercialesConPedidos() {

        try {
            return this.comercial.comercialesConPedidos();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }


}
