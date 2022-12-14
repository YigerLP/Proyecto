package com.proyecto.service;

import com.proyecto.dao.CarritoDao;
import com.proyecto.domain.Carrito;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CarritoServiceImpl implements CarritoService {
    
    @Autowired
    private CarritoDao carritoDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Carrito> getCarritos(){
        return (List<Carrito>)carritoDao.findAll();
    }
    
    @Override
    @Transactional(readOnly = true)
    public Carrito getCarrito(Carrito carrito){
        return carritoDao.findById(carrito.getId_carrito()).orElse(null);
    }
    
    @Override
    @Transactional
    public void save(Carrito carrito){
        carritoDao.save(carrito);
    }
    
    @Override
    @Transactional
    public void delete (Carrito carrito){
        carritoDao.delete(carrito);
    }
}
