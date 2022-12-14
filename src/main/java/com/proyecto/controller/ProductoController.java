package com.proyecto.controller;

import com.proyecto.domain.Producto;
import com.proyecto.service.ProductoService;
import com.proyecto.service.TiposProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductoController {
    @Autowired
    private ProductoService productoService;
    
    @Autowired
    private TiposProductoService tiposProductoService;
    
    @GetMapping("/productos/nuevo")
    public String nuevoProducto(Producto producto, Model model){
        var tiposProducto = tiposProductoService.getTiposProductos();
        model.addAttribute("tiposProductos", tiposProducto);
        return "/productos/modificarProducto";
    }
    
    @PostMapping("/productos/guardar")
    public String guardarProducto(Producto producto){
        productoService.save(producto);
        return "redirect:/productos/producto/";
    }
    
    @GetMapping("/productos/modificarProducto/{ID_PRODUCTO}")
    public String modificarProducto(Producto producto, Model model){
        producto = productoService.getProducto(producto);
        var tiposProducto = tiposProductoService.getTiposProductos();
        model.addAttribute("tiposProductos", tiposProducto);
        model.addAttribute("producto", producto);
        return "/productos/modificarProducto";
    }
    
    @GetMapping("/productos/eliminarProducto/{ID_PRODUCTO}")
    public String eliminarProducto(Producto producto){
        productoService.delete(producto);
        return "redirect:/productos/producto/";
    }
}
