package com.proyecto.controller;

import com.proyecto.domain.TiposProducto;
import com.proyecto.service.TiposProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TiposProductoController {
    @Autowired
    private TiposProductoService productoService;
    
    @GetMapping("/tipoProducto/nuevo")
    public String nuevoTipoProducto(TiposProducto tiposProducto){
        
        return "/tipoProducto/modificarTiposProducto";
    }
    
    @PostMapping("/tipoProducto/guardar")
    public String guardarTipoProducto(TiposProducto tiposProducto){
        productoService.save(tiposProducto);
        return "redirect:/tipoProducto/tiposProducto/";
    }
    
    @GetMapping("/modificarTipoProducto/{COD_TIPO_PRODUCTO}")
    public String modificarTipoProducto(TiposProducto tiposProducto, Model model){
        tiposProducto = productoService.getTiposProducto(tiposProducto);
        model.addAttribute("producto", tiposProducto);
        return "tipoProducto/modificarProducto";
    }
    
    @GetMapping("/eliminarTipoProducto/{COD_TIPO_PRODUCTO}")
    public String eliminarTipoProducto(TiposProducto tiposProducto){
        productoService.delete(tiposProducto);
        return "redirect:/tipoProducto/tiposProducto/";
    }
}
