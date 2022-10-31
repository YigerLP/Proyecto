package com.proyecto.controller;

import com.proyecto.service.ProductoService;
import com.proyecto.service.TiposProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    
    @Autowired
    private ProductoService productoService;
    
    @Autowired
    private TiposProductoService tiposProductoService;
    
    @GetMapping("/catalogo/")
    public String IrCatalogo(Model model){
        
        var productos = productoService.getProductos();
        
        model.addAttribute("productos", productos);
        
        return "catalogo";
    }
    
    @GetMapping("/producto/")
    public String IrProductos(Model model){
        
        var productos = productoService.getProductos();
        
        model.addAttribute("productos", productos);
        
        return "producto";
    }
    
    @GetMapping("/tiposProducto/")
    public String IrTiposProductos(Model model){
        
        var tiposProductos = tiposProductoService.getTiposProductos();
        
        model.addAttribute("tiposProductos", tiposProductos);
        
        return "tiposProducto";
    }
}
