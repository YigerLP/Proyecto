package com.proyecto.service;

import com.proyecto.domain.Producto;
import java.util.List;

public interface ProductoService {
    public List<Producto> getProductos();
    
    public Producto getProducto(Producto producto);
    
    public void save(Producto producto);
    
    public void delete (Producto producto);
    
    public Producto getProductoPorDescripcion(String descripcion);
}
