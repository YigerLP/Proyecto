package com.proyecto.controller;

import com.proyecto.domain.TiposProducto;
import com.proyecto.service.ProductoService;
import com.proyecto.service.TiposProductoService;
import java.util.List;
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
    
    private List<TiposProducto> tiposProducto;
    
    @GetMapping("/")
    public String Inicio(Model model){
        tiposProducto = tiposProductoService.getTiposProductos();
        model.addAttribute("tiposProductos", tiposProducto);
        
        return "/index";
    }
    
    @GetMapping("/productos/catalogo/")
    public String IrCatalogo(Model model){
        
        var productos = productoService.getProductos();
        
        model.addAttribute("productos", productos);
        
        return "/productos/catalogo";
    }
    
    @GetMapping("/productos/producto/")
    public String IrProductos(Model model){
        
        var productos = productoService.getProductos();
        
        model.addAttribute("productos", productos);
        
        return "/productos/producto";
    }
    
    @GetMapping("/tipoProducto/tiposProducto")
    public String IrTiposProductos(Model model){
        
        var tiposProductos = tiposProductoService.getTiposProductos();
        
        model.addAttribute("tiposProductos", tiposProductos);
        
        return "/tipoProducto/tiposProducto";
    }
    
    @GetMapping("/carrito/carritoCompras/")
    public String IrCarrito(Model model){
        
        //var tiposProductos = tiposProductoService.getTiposProductos();
        
        //model.addAttribute("tiposProductos", tiposProductos);
        
        return "/carrito/carritoCompras";
    }
    
}



