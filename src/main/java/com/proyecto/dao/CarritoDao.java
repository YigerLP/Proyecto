package com.proyecto.dao;

import com.proyecto.domain.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarritoDao extends JpaRepository<Carrito, Integer> {
}
