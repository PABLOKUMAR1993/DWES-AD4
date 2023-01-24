package com.uf6.ad4.model.entity;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table( name = "clientes" )
public class ClienteEntity implements Serializable {

    // Atributos


    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_cliente")
    private int idCliente;

    private String nombre;

    private String apellido1;

    private String apellido2;

    private String ciudad;

    private int categoria;


    // Constructores


    public ClienteEntity() {
    }

    public ClienteEntity(int idCliente, String apellido1, String apellido2, int categoria, String ciudad, String nombre) {
        super();
        this.idCliente = idCliente;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.categoria = categoria;
        this.ciudad = ciudad;
        this.nombre = nombre;
    }


    // Getters & Setters


    public int getIdCliente() {
        return this.idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getApellido1() {
        return this.apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return this.apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public int getCategoria() {
        return this.categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public String getCiudad() {
        return this.ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    // hashCode & equals


    @Override
    public int hashCode() {
        return Objects.hash(idCliente);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof ClienteEntity))
            return false;
        ClienteEntity other = (ClienteEntity) obj;
        return idCliente == other.idCliente;
    }


    // toString


    @Override
    public String toString() {
        return "Cliente [idCliente=" + idCliente + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2="
                + apellido2 + ", ciudad=" + ciudad + ", categoria=" + categoria + ", pedidos=" + "]";
    }

}
