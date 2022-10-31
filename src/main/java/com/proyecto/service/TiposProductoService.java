package com.proyecto.service;

import com.proyecto.domain.TiposProducto;
import java.util.List;

public interface TiposProductoService {
    public List<TiposProducto> getTiposProductos();
    
    public TiposProducto getTiposProducto(TiposProducto tipoProducto);
    
    public void save(TiposProducto tipoProducto);
    
    public void delete (TiposProducto tipoProducto);
}
