package com.proyecto.service;

import com.proyecto.dao.ProductoDao;
import com.proyecto.domain.Producto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoServiceImpl implements ProductoService {
    
    @Autowired
    private ProductoDao productoDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Producto> getProductos(){
        return (List<Producto>)productoDao.findAll();
    }
    
    @Override
    @Transactional(readOnly = true)
    public Producto getProducto(Producto producto){
        return productoDao.findById(producto.getID_PRODUCTO()).orElse(null);
    }
    
    @Override
    @Transactional
    public void save(Producto producto){
        productoDao.save(producto);
    }
    
    @Override
    @Transactional
    public void delete (Producto producto){
        productoDao.delete(producto);
    }
    
    @Override
    public Producto getProductoPorDescripcion (String descripcion){
        return productoDao.findByDESCRIPCION(descripcion);
    }
}
