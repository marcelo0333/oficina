package com.example.oficina.controller;

import com.example.oficina.dao.UsuarioDAO;
import com.example.oficina.model.Usuario;
import com.example.oficina.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @GetMapping("/cadastrarUsuario")
    public String cadastrarUsuarioView(Model model){

        System.out.println("chamou o get de cadastrar usuario");
        model.addAttribute("usuario", new Usuario());
        return "registrar";
    }

    @PostMapping("/cadastrarUsuario")
    public RedirectView cadastrarUsuarioView(@ModelAttribute("usuario")Usuario usuario, RedirectAttributes redirectAttributes) {

        System.out.println("chamou o POST de cadastrar usuario");
        RedirectView redirectView = null;

        boolean verifica;
        verifica = new UsuarioService().cadastrar(usuario);

        if (verifica == true) {
            redirectView = new RedirectView("/usuario/login", true);
            System.out.println("CADASTROU");
        } else {
            redirectView = new RedirectView("/usuario/cadastrarUsuario");
            redirectAttributes.addFlashAttribute("msgServidor", false);
            System.out.println("NÃO CADASTROU");
        }

        System.out.println("Usuario:" + usuario);

        return redirectView;
    }

    @GetMapping("/login")
    public String loginUsuarioView(Model model){
        model.addAttribute("usuario", new Usuario());
        System.out.println("ENTROU NO GET LOGIN");

        return "index";
    }

    @PostMapping("/login")
    public RedirectView loginUsuarioView(@ModelAttribute("usuario")Usuario usuario, RedirectAttributes redirectAttributes){

        System.out.println(("CHAMOU O POST DE LOGIN"));
        RedirectView redirectView = null;

        boolean verifica;

        verifica = new UsuarioService().autenticar(usuario);

        if(verifica == false){

            redirectView = new RedirectView("/usuario/login", true);
            System.out.println("Nao entrou");

        }
        else{
            redirectView = new RedirectView("/usuario/principal", true);
            redirectAttributes.addFlashAttribute("msgServidor", false);
            System.out.println("ENTROU");
        }

        return redirectView;
    }

    @GetMapping("/principal")
    public String principalView(Model model){
        model.addAttribute("usuario", new Usuario());
        System.out.println("Entrou em get principal");

        return "principal";
    }


}


