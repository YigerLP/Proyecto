package com.proyecto.service;

import com.proyecto.dao.TiposProductoDao;
import com.proyecto.domain.TiposProducto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TiposProductoServiceImpl implements TiposProductoService {
    
    @Autowired
    private TiposProductoDao tipoProductoDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<TiposProducto> getTiposProductos(){
        return (List<TiposProducto>)tipoProductoDao.findAll();
    }
    
    @Override
    @Transactional(readOnly = true)
    public TiposProducto getTiposProducto(TiposProducto tipoProducto){
        return tipoProductoDao.findById(tipoProducto.getCOD_TIPO_PRODUCTO()).orElse(null);
    }
    
    @Override
    @Transactional
    public void save(TiposProducto tipoProducto){
        tipoProductoDao.save(tipoProducto);
    }
    
    @Override
    @Transactional
    public void delete (TiposProducto tipoProducto){
        tipoProductoDao.delete(tipoProducto);
    }
}
