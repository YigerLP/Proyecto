package com.proyecto.dao;

import com.proyecto.domain.TiposProducto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TiposProductoDao extends JpaRepository<TiposProducto, String> {
    
}
