package com.uf6.ad4.controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/")
public class HomeController {

    @GetMapping("/")
    public String home() {
        return ("""
                AD4 - API-REST
                DOCUMENTACIÓN PARA EL USO DE LA API-REST.
       
                
                /comercial/crearUno
                Te permite crear un comercial nuevo con datos preestablecidos.
                Devolverá el comercial creado o null si algo ha fallado.
                
                /comercial/crearUno/{nombre}/{apellido1}/{apellido2}/{comisión}
                Te permite crear un comercial nuevo con los datos que quieras.
                Devolverá el comercial creado o null si algo ha fallado.
                
                /comercial/borrarUno/{id}
                Te permite eliminar un comercial por su id.
                Devolverá un mensaje de confirmación si se ha borrado o no.
                
                /comercial/verUno/{id}
                Te permite ver un comercial por su id.
                Devolverá el comercial o null si no existe.
                
                /comercial/porCliente/{id}
                Te permite ver los comerciales que han vendido a un cliente por si id.
                Devolverá una lista de los comerciales que han vendido a ese cliente,
                (la lista podría estar vacía).
                
                /comercial/conPedidos
                Te permite ver los comerciales que han hecho pedidos.
                Devolverá una lista de los comerciales que han hecho pedidos,
                (la lista podría estar vacía).
                
                /comercial/pedidos/{id}
                Te permite ver los pedidos de un comercial por su id.
                Devolverá una lista de los pedidos del comercial,
                (la lista podría estar vacía).
                
                Realizado por Raúl Herrera & Pavlo Dudnyk.
                """);
    }

}