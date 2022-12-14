package com.proyecto;

import com.proyecto.service.TiposProductoService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {

    @Autowired
    private UserRepository userRepo;
    
    @Autowired
    private TiposProductoService tiposProductoService;

    @GetMapping("")
    public String viewHomePage() {
        return "index";
    }

    @GetMapping("/user/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());

        return "/user/signup_form";
    }

    @PostMapping("/user/process_register")
    public String processRegister(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userRepo.save(user);

        return "index";
    }

    @GetMapping("/index")
    public String listUsers(Model model) {
        List<User> listUsers = userRepo.findAll();
        model.addAttribute("listUsers", listUsers);
        var tiposProducto = tiposProductoService.getTiposProductos();
        model.addAttribute("tiposProductos", tiposProducto);

        return "index";
    }
    
    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }
}
