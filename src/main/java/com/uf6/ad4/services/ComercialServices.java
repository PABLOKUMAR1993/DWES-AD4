package com.uf6.ad4.services;
import com.uf6.ad4.model.entity.ComercialEntity;

import java.util.List;

public interface ComercialServices {

    ComercialEntity findById(int idComercial);
    boolean crearUno(ComercialEntity comercial);
    List<ComercialEntity> findAll();
    boolean borrarUno(int idComercial);

}
