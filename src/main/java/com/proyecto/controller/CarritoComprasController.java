package com.proyecto.controller;

import com.proyecto.domain.Carrito;
import com.proyecto.domain.Producto;
import com.proyecto.service.CarritoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CarritoComprasController {
    
    @Autowired
    private CarritoService carritoService;

//    @GetMapping("/carrito/carritoCompras/agregar/")
//    public String AgregarCarrito(Producto producto){
//        
//        var carrito = new Carrito("ADMIN", producto.getPRECIO(), 1, producto.getID_PRODUCTO(), producto.getPRECIO() * 1, producto.getCOD_TIPO_PRODUCTO());
//        carritoService.save(carrito);
//        
//        return "/carrito/carritoCompras";
//    }
    
    @GetMapping("/carrito/carritoCompras/eliminarProducto/{ID_PRODUCTO}")
    public String eliminarProducto(Carrito carrito){
        carritoService.delete(carrito);
        return "redirect:/carrito/carritoCompras/";
    }
    
//    @GetMapping("/carritos/carrito/")
//    public String IrCarritos(Model model){
//        
//        var carritos = carritoService.getCarritos();
//        
//        model.addAttribute("carritos", carritos);
//        
//        return "/carritos/carrito";
//    }
//    
//    @GetMapping("/tipoCarrito/tiposCarrito")
//    public String IrTiposCarritos(Model model){
//        
//        var tiposCarritos = tiposCarritoService.getTiposCarritos();
//        
//        model.addAttribute("tiposCarritos", tiposCarritos);
//        
//        return "/tipoCarrito/tiposCarrito";
//    }
//    
//    @GetMapping("/carrito/carritoCompras/")
//    public String IrCarrito(Model model){
//        
//        //var tiposCarritos = tiposCarritoService.getTiposCarritos();
//        
//        //model.addAttribute("tiposCarritos", tiposCarritos);
//        
//        return "/carrito/carritoCompras";
//    }
    
}



