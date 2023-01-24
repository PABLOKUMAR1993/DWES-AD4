package com.uf6.ad4.services;
import com.uf6.ad4.model.entity.ComercialEntity;
import com.uf6.ad4.repository.ComercialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComercialServicesImpl implements ComercialServices {


    //Atributos


    @Autowired
    private ComercialRepository comercial;


    //Métodos Implementados


    @Override
    public ComercialEntity findById( int idComercial ) {
        return comercial.findById( idComercial ).orElse( null );
    }

    @Override
    public boolean crearUno( ComercialEntity comercial ) {

        try {
            this.comercial.save( comercial );
            return true;
        } catch ( Exception e ) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public List<ComercialEntity> findAll() {
        return this.comercial.findAll();
    }

    @Override
    public boolean borrarUno( int idComercial ) {

        try {
            this.comercial.deleteById( idComercial );
            return true;
        } catch ( Exception e ) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public List<ComercialEntity> comercialQueVendeACliente(int idCliente) {

        try {
            return this.comercial.comercialQueVendeACliente(idCliente);
        } catch ( Exception e ) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public List<ComercialEntity> comercialesConPedidos() {

        try {
            return this.comercial.comercialesConPedidos();
        } catch ( Exception e ) {
            e.printStackTrace();
            return null;
        }

    }


}
