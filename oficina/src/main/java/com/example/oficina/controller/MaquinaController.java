package com.example.oficina.controller;

import com.example.oficina.dao.MaquinaDAO;
import com.example.oficina.dao.MecanicoDAO;
import com.example.oficina.model.Maquina;
import com.example.oficina.model.Mecanico;
import com.example.oficina.service.MaquinaService;
import com.example.oficina.service.MecanicoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;


@Controller
@RequestMapping("/usuario/principal")
public class MaquinaController{
    @GetMapping("/registroMaquina")
    public String cadastrarMaquinaView(Model model){

        model.addAttribute("maquinas", new MaquinaDAO().getAllMaquinas());
        System.out.println("entrou no view maquina");
        model.addAttribute("maquina", new Maquina());
        return "registro_maquina";
    }
    @PostMapping("/registroMaquina")
    public RedirectView cadastrarMecanicoView(@ModelAttribute("maquina")Maquina maquina, RedirectAttributes redirectAttributes){

        System.out.println("Chamou Post maquina");
        RedirectView redirectView = null;

        boolean verifica;
        verifica = new MaquinaService().cadastrar(maquina);

        if(verifica == true){
            redirectView = new RedirectView("/usuario/principal/registroMaquina",true);
            System.out.println("cadastrou");
        }
        else{
            redirectView = new RedirectView("/usuario/principal");
            redirectAttributes.addFlashAttribute("msgServidor", false);
            System.out.println("NÃO CADASTROU");
        }
        return redirectView;
    }

    @RequestMapping( "/excluirMaquina")
    public RedirectView excluirMaquinaView(@RequestParam("idMaquina") int id, RedirectAttributes redirectAttributes){

        RedirectView redirectView = null;
        Maquina m = new Maquina();
        System.out.println("id exclusao"+m.getIdMaquina());
        int idM;
        m.setIdMaquina(Integer.parseInt(String.valueOf(id)));
        redirectView = new RedirectView("/usuario/principal/registroMaquina",true);

        if(new MaquinaDAO().deletar(m)){
            System.out.println("Excluido "+m);
        }else{
            System.out.println("Nao excluido "+m);
        }
        return redirectView;
    }

    @GetMapping("/editarMaquina")
    public String editarMaquinaView(@RequestParam("idMaquina") int id, Model model){
        System.out.println("Entrar no get Editar maquina");
        model.addAttribute("maquina", new MaquinaDAO().GetMaquina(id));

        return "editar_maquina";
    }
    @PostMapping("/editarMaquina")
    public RedirectView editarMecanicoView(@ModelAttribute("maquina") Maquina maquina, RedirectAttributes redirectAttributes){

        System.out.println("ENTROU POST EDIT FOR");

        RedirectView redirectView = null;

        System.out.println("Maquina: "+ maquina.getIdMaquina() + maquina.getNomeMaquina());

        if(new MaquinaService().atualizar(maquina)){

            redirectView = new RedirectView("/usuario/principal/registroMaquina", true);

        }else{

            redirectView = new RedirectView("/usuario/principal/registroMaquina", true);
            redirectAttributes.addFlashAttribute("msgServidor", false);

        }

        return redirectView;
    }

}
