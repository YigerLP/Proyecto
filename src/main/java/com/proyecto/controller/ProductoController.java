package com.proyecto.controller;

import com.proyecto.domain.Producto;
import com.proyecto.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductoController {
    @Autowired
    private ProductoService productoService;
    
    @GetMapping("/producto/nuevo")
    public String nuevoProducto(Producto producto){
        
        return "productos/modificarProducto";
    }
    
    @PostMapping("/producto/guardar")
    public String guardarProducto(Producto producto){
        productoService.save(producto);
        return "redirect:/productos/producto/";
    }
    
    @GetMapping("/modificarProducto/{ID_PRODUCTO}")
    public String modificarProducto(Producto producto, Model model){
        producto = productoService.getProducto(producto);
        model.addAttribute("producto", producto);
        return "productos/modificarProducto";
    }
    
    @GetMapping("/eliminarProducto/{ID_PRODUCTO}")
    public String eliminarProducto(Producto producto){
        productoService.delete(producto);
        return "redirect:/productos/producto/";
    }
}
