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
    private TiposProductoService tiposProductoService;
    
    @GetMapping("/tipoProducto/nuevo")
    public String nuevoTipoProducto(TiposProducto tiposProducto){
        
        return "/tipoProducto/modificarTiposProducto";
    }
    
    @PostMapping("/tipoProducto/guardar")
    public String guardarTipoProducto(TiposProducto tiposProducto){
        tiposProductoService.save(tiposProducto);
        return "redirect:/tipoProducto/tiposProducto/";
    }
    
    @GetMapping("/tipoProducto/modificarTipoProducto/{COD_TIPO_PRODUCTO}")
    public String modificarTipoProducto(TiposProducto tiposProducto, Model model){
        tiposProducto = tiposProductoService.getTiposProducto(tiposProducto);
        model.addAttribute("tiposProducto", tiposProducto);
        return "/tipoProducto/modificarTiposProducto";
    }
    
    @GetMapping("/tipoProducto/eliminarTipoProducto/{COD_TIPO_PRODUCTO}")
    public String eliminarTipoProducto(TiposProducto tiposProducto){
        tiposProductoService.delete(tiposProducto);
        return "redirect:/tipoProducto/tiposProducto/";
    }
}
