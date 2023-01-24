package com.uf6.ad4.model.entity;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table( name = "comerciales" )
public class ComercialEntity implements Serializable {

    //Atributos

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comercial")
    private int idComercial;

    @Basic
    @Column(name = "nombre")
    private String nombre;

    @Basic
    @Column(name = "apellido1")
    private String apellido1;

    @Basic
    @Column(name = "apellido2")
    private String apellido2;

    @Basic
    @Column(name = "comision")
    private Double comision;


    //Constructores

    public ComercialEntity() {
    }

    public ComercialEntity(int idComercial, String nombre, String apellido1, String apellido2, Double comision) {
        this.idComercial = idComercial;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.comision = comision;
    }

    //Getters y Setters

    public int getIdComercial() {
        return idComercial;
    }

    public void setIdComercial(int idComercial) {
        this.idComercial = idComercial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public Double getComision() {
        return comision;
    }

    public void setComision(Double comision) {
        this.comision = comision;
    }

    
    //hashCode y equals


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ComercialEntity that)) return false;
        return getIdComercial() == that.getIdComercial();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdComercial());
    }


    //toString


    @Override
    public String toString() {
        return "Comercial{" +
                "idComercial=" + idComercial +
                ", nombre='" + nombre + '\'' +
                ", apellido1='" + apellido1 + '\'' +
                ", apellido2='" + apellido2 + '\'' +
                ", comisión=" + comision +
                '}';
    }

}
