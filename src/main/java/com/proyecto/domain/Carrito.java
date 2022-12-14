package com.proyecto.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "carrito")
public class Carrito implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_carrito;
    private String id_usuario;
    private double precio;
    private int cantidad;
    private long id_producto;
    private double total;
    private String id_tipo_producto;

    public Carrito (int id_carrito, String id_usuario, double precio, int cantidad, long id_producto, double total, String id_tipo_producto) {
        this.id_carrito = id_carrito;
        this.id_usuario = id_usuario;
        this.precio = precio;
        this.cantidad = cantidad;
        this.id_producto = id_producto;
        this.total = total;
        this.id_tipo_producto = id_tipo_producto;
    }
}
