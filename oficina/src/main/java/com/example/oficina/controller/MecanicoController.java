package com.example.oficina.controller;


import com.example.oficina.dao.MecanicoDAO;
import com.example.oficina.dao.UsuarioDAO;
import com.example.oficina.model.Mecanico;
import com.example.oficina.model.Usuario;
import com.example.oficina.service.MecanicoService;
import com.example.oficina.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;


@Controller
@RequestMapping("/usuario/principal")
public class MecanicoController{
    @GetMapping("/registroMecanico")
    public String cadastrarMecanicoView(Model model){

        model.addAttribute("mecanicos", new MecanicoDAO().getAllMecanicos());
        System.out.println("entrou no view mecanico");
        model.addAttribute("mecanico", new Mecanico());
        return "registro_mecanico";
    }
    @PostMapping("/registroMecanico")
    public RedirectView cadastrarMecanicoView(@ModelAttribute("mecanico")Mecanico mecanico, RedirectAttributes redirectAttributes){

        System.out.println("Chamou Post mecanico");
        RedirectView redirectView = null;

        boolean verifica;
        verifica = new MecanicoService().cadastrar(mecanico);

        if(verifica == true){
            redirectView = new RedirectView("/usuario/principal/registroMecanico",true);
            System.out.println("cadastrou");
        }
        else{
            redirectView = new RedirectView("/usuario/principal");
            redirectAttributes.addFlashAttribute("msgServidor", false);
            System.out.println("NÃO CADASTROU");
        }
        return redirectView;
    }

    @RequestMapping( "/excluirMecanico")
    public RedirectView excluirMecanicoView(@RequestParam("idMec") int id, RedirectAttributes redirectAttributes){

        RedirectView redirectView = null;
        Mecanico m = new Mecanico();
        System.out.println("id exclusao"+m.getIdMec());
        int idM;
        m.setIdMec(Integer.parseInt(String.valueOf(id)));
        redirectView = new RedirectView("/usuario/principal/registroMecanico",true);

        if(new MecanicoDAO().deletar(m)){
            System.out.println("Excluido "+m);
        }else{
            System.out.println("Nao excluido "+m);
        }
        return redirectView;
    }

    @GetMapping("/editarMecanico")
    public String editarMecanicoView(@RequestParam("idMec") int id, Model model){
        System.out.println("Entrar no get Editar Mecanico");
        model.addAttribute("mecanico", new MecanicoDAO().GetMecanico(id));

        return "editar_mecanico";
    }
    @PostMapping("/editarMecanico")
    public RedirectView editarMecanicoView(@ModelAttribute("mecanico") Mecanico mecanico, RedirectAttributes redirectAttributes){

        System.out.println("ENTROU POST EDIT FOR");

        RedirectView redirectView = null;

        System.out.println("mecanico: "+ mecanico.getIdMec() + mecanico.getNomeMec());

        if(new MecanicoService().atualizar(mecanico)){

            redirectView = new RedirectView("/usuario/principal/registroMecanico", true);

        }else{

            redirectView = new RedirectView("/usuario/principal/registroMecanico", true);
            redirectAttributes.addFlashAttribute("msg_servidor", false);

        }

        return redirectView;
    }

}




