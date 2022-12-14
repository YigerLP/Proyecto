package com.proyecto.service;

import com.proyecto.domain.Carrito;
import java.util.List;

public interface CarritoService {
    public List<Carrito> getCarritos();
    
    public Carrito getCarrito(Carrito carrito);
    
    public void save(Carrito carrito);
    
    public void delete (Carrito carrito);

}
