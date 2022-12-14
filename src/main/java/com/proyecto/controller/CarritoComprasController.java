package com.proyecto.controller;

import com.proyecto.service.CarritoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CarritoComprasController {
    
    @Autowired
    private CarritoService carritoService;
    
   
    
    @GetMapping("/carritos/catalogo/")
    public String IrCatalogo(Model model){
        
        var carritos = carritoService.getCarritos();
        
        model.addAttribute("carritos", carritos);
        
        return "/carritos/catalogo";
    }
    
    @GetMapping("/carritos/carrito/")
    public String IrCarritos(Model model){
        
        var carritos = carritoService.getCarritos();
        
        model.addAttribute("carritos", carritos);
        
        return "/carritos/carrito";
    }
    
    @GetMapping("/tipoCarrito/tiposCarrito")
    public String IrTiposCarritos(Model model){
        
        var tiposCarritos = tiposCarritoService.getTiposCarritos();
        
        model.addAttribute("tiposCarritos", tiposCarritos);
        
        return "/tipoCarrito/tiposCarrito";
    }
    
    @GetMapping("/carrito/carritoCompras/")
    public String IrCarrito(Model model){
        
        //var tiposCarritos = tiposCarritoService.getTiposCarritos();
        
        //model.addAttribute("tiposCarritos", tiposCarritos);
        
        return "/carrito/carritoCompras";
    }
    
}



