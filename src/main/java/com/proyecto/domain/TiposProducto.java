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
@Table(name="sc_tipos_productos")
public class TiposProducto implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    private String COD_TIPO_PRODUCTO;
    private String DESCRIPCION;
    private String ESTADO;
    private double PORC_DESCUENTO;

    public TiposProducto() {
    }

    public TiposProducto(String COD_TIPO_PRODUCTO, String DESCRIPCION, String ESTADO, double PORC_DESCUENTO) {
        this.COD_TIPO_PRODUCTO = COD_TIPO_PRODUCTO;
        this.DESCRIPCION = DESCRIPCION;
        this.ESTADO = ESTADO;
        this.PORC_DESCUENTO = PORC_DESCUENTO;
    }
}
