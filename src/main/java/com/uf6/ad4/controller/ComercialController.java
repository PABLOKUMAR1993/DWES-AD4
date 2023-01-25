package com.uf6.ad4.controller;
import com.uf6.ad4.model.entity.ComercialEntity;
import com.uf6.ad4.model.entity.PedidoEntity;
import com.uf6.ad4.services.ComercialServices;
import com.uf6.ad4.services.PedidoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


/**
 * Clase encargada de dar soporte a las peticiones REST relacionadas con los comerciales.
 *
 * @author Raúl Herrera
 * @author Pavlo Dudnyk
 * @version 1.0
 */
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


    /**
     * Método que crea un comercial nuevo con datos pre-establecido, en la base de datos.
     *
     * @return el comercial que se acaba de crear o null si no se ha podido crear.
     */
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

    /**
     * Método que crea un comercial nuevo en la base de datos, con datos los datos pasados por params.
     *
     * @param nombre nombre del comercial.
     * @param apellido1 primer apellido del comercial.
     * @param apellido2 segundo apellido del comercial.
     * @param comision comisión del comercial.
     * @return el comercial que se acaba de crear o null si no se ha podido crear.
     */
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

    /**
     * Método que devuelve un comercial de la base de datos, indicado por su id.
     *
     * @param idComercial id del comercial a consultar
     * @return El comercial indicado o null si no existe.
     */
    @GetMapping("/verUno/{id}")
    public ComercialEntity verUno( @PathVariable( "id" ) int idComercial ) {
        return comercial.findById(idComercial);
    }

    /**
     * Método que elimina un comercial de la base de datos, indicado por su id.
     *
     * @param idComercial id del comercial a eliminar.
     * @return mensaje de éxito o fracaso.
     */
    @DeleteMapping("/borrarUno/{id}")
    public String borraUno( @PathVariable( "id" ) int idComercial ) {

        if ( this.comercial.borrarUno( idComercial ) ) {
            return "Comercial eliminado con éxito.";
        } else {
            return "No se ha podido eliminar el comercial.";
        }

    }

    /**
     * Método que devuelve todos los comerciales que han realizado una venta a un cliente concreto indicado por si id.
     *
     * @param idCliente del cliente sobre el que se quiere consultar.
     * @return lista de comerciales que han vendido a ese cliente.
     */
    @GetMapping( "/porCliente/{id}" )
    public List<ComercialEntity> porComercial( @PathVariable( "id" ) int idCliente ) {
        return this.comercial.comercialQueVendeACliente( idCliente );
    }

    /**
     * Método que devuelve todos los comerciales que han realizado una venta a algún cliente.
     *
     * @return lista de comerciales que han vendido a algún cliente.
     */
    @GetMapping( "/conPedidos" )
    public List<ComercialEntity> conPedidos() {
        return this.comercial.comercialesConPedidos();
    }

    /**
     * Método todos los pedidos de un comercial concreto, indicado por su id.
     *
     * @param idComercial id del comercial que quieres consultar.
     * @return lista de pedidos del comercial indicado.
     */
    @GetMapping( "/pedidos/{id}" )
    public List<PedidoEntity> pedidos( @PathVariable( "id" ) int idComercial ) {
        return this.pedido.pedidosDeComercial( idComercial );
    }

}
