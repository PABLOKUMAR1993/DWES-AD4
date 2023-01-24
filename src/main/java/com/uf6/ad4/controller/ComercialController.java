package com.uf6.ad4.controller;

import com.uf6.ad4.model.entity.ComercialEntity;
import com.uf6.ad4.model.entity.PedidoEntity;
import com.uf6.ad4.services.ComercialServices;
import com.uf6.ad4.services.PedidoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/comercial")
public class ComercialController {


    //Atributos


    @Autowired
    private ComercialServices comercial;

    @Autowired
    private PedidoServices pedido;


    //Métodos


    @PostMapping("/crearUno")
    public ComercialEntity crearUno(){

        ComercialEntity comercial = new ComercialEntity();
        comercial.setNombre("Raúl");
        comercial.setApellido1("Herrera");
        comercial.setApellido2("No Me Acuerdo");
        comercial.setComision(0.20);

        if ( this.comercial.crearUno( comercial ) ) {
            return this.comercial.findById( comercial.getIdComercial() );
        } else {
            return null;
        }

    }

    @PostMapping("/crearUno/{nombre}/{apellido1}/{apellido2}/{comision}")
    public ComercialEntity crearUno( @PathVariable( "nombre" ) String nombre,
                                     @PathVariable( "apellido1" ) String apellido1,
                                     @PathVariable( "apellido2" ) String apellido2,
                                     @PathVariable( "comision" ) double comision ){

        ComercialEntity comercial = new ComercialEntity();
        comercial.setNombre(nombre);
        comercial.setApellido1(apellido1);
        comercial.setApellido2(apellido2);
        comercial.setComision(comision);

        if ( this.comercial.crearUno( comercial ) ) {
            return this.comercial.findById( comercial.getIdComercial() );
        } else {
            return null;
        }

    }

    @GetMapping("/verUno/{id}")
    public ComercialEntity verUno( @PathVariable( "id" ) int idComercial ) {
        return comercial.findById(idComercial);
    }

    @DeleteMapping("/borrarUno/{id}")
    public String borraUno( @PathVariable( "id" ) int idComercial ) {

        if ( this.comercial.borrarUno( idComercial ) ) {
            return "Comercial eliminado con éxito.";
        } else {
            return "No se ha podido eliminar el comercial.";
        }

    }

    @GetMapping( "/porCliente/{id}" )
    public List<ComercialEntity> porComercial( @PathVariable( "id" ) int idCliente ) {

        return this.comercial.comercialQueVendeACliente( idCliente );

    }

    @GetMapping( "/conPedidos" )
    public List<ComercialEntity> conPedidos() {

        return this.comercial.comercialesConPedidos();

    }

    @GetMapping( "/pedidos/{id}" )
    public List<PedidoEntity> pedidos( @PathVariable( "id" ) int idComercial ) {

        return this.pedido.pedidosDeComercial( idComercial );

    }

}
