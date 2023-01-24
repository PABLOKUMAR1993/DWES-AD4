package com.uf6.ad4.model.entity;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table( name = "pedidos" )
public class PedidoEntity implements Serializable {


    //Atributos


    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private int idPedido;

    @Basic
    @Column(name = "total")
    private double total;

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha")
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private ClienteEntity clienteEntity;

    @ManyToOne
    @JoinColumn(name = "id_comercial", nullable = false)
    private ComercialEntity comercialEntity;


    //Constructores


    public PedidoEntity() {
    }

    public PedidoEntity(int idPedido, double total, Date fecha, ClienteEntity clienteEntity, ComercialEntity comercialEntity) {
        this.idPedido = idPedido;
        this.total = total;
        this.fecha = fecha;
        this.clienteEntity = clienteEntity;
        this.comercialEntity = comercialEntity;
    }


    //Getters y Setters


    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public ClienteEntity getCliente() {
        return clienteEntity;
    }

    public void setCliente(ClienteEntity clientesByIdClienteEntity) {
        this.clienteEntity = clientesByIdClienteEntity;
    }

    public ComercialEntity getComercial() {
        return comercialEntity;
    }

    public void setComercial(ComercialEntity comercialesByIdComercialEntity) {
        this.comercialEntity = comercialesByIdComercialEntity;
    }


    //hashCode y equals


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PedidoEntity that)) return false;
        return getIdPedido() == that.getIdPedido();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdPedido());
    }


    //toString


    @Override
    public String toString() {
        return "PedidosEntity{" +
                "idPedido=" + idPedido +
                ", total=" + total +
                ", fecha=" + fecha +
                ", clientesByIdCliente=" + clienteEntity +
                ", comercialesByIdComercial=" + comercialEntity +
                '}';
    }

}
