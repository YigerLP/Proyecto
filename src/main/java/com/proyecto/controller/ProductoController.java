package com.proyecto.controller;

import com.proyecto.domain.Carrito;
import com.proyecto.domain.Producto;
import com.proyecto.service.CarritoService;
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
    
    @Autowired
    private CarritoService carritoService;
    
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
    
    @GetMapping("/productos/buscar")
    public String Buscar(String descripcion){
        productoService.getProductoPorDescripcion(descripcion);
        return "/productos/producto/";
    }
    
    @GetMapping("/productos/agregar/{ID_PRODUCTO}")
    public String AgregarCarrito(Producto producto){
        producto = productoService.getProducto(producto);
        var carrito = new Carrito("ADMIN", producto.getPRECIO(), 1, producto.getID_PRODUCTO(), producto.getPRECIO() * 1, producto.getCOD_TIPO_PRODUCTO(), producto.getDESCRIPCION());
        carritoService.save(carrito);
        
        return "redirect:/productos/catalogo/";
    }
}
