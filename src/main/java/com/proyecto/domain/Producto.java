package com.proyecto.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "sc_productos")
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID_PRODUCTO;
    private String COD_TIPO_PRODUCTO;
    private String DESCRIPCION;
    private String DETALLE;
    private String ESTADO;
    private double PRECIO;
    private int EXISTENCIAS;

    @Column(name = "ruta_imagen")
    private String rutaImagen;

    public Producto() {
    }

    public Producto(Long ID_PRODUCTO, String COD_TIPO_PRODUCTO, String DESCRIPCION, String DETALLE, String ESTADO, double PRECIO, int EXISTENCIAS, String rutaImagen) {
        this.ID_PRODUCTO = ID_PRODUCTO;
        this.COD_TIPO_PRODUCTO = COD_TIPO_PRODUCTO;
        this.DESCRIPCION = DESCRIPCION;
        this.DETALLE = DETALLE;
        this.ESTADO = ESTADO;
        this.PRECIO = PRECIO;
        this.EXISTENCIAS = EXISTENCIAS;
        this.rutaImagen= rutaImagen;
    }
}
