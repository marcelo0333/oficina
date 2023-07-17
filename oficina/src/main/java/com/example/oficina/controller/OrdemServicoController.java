package com.example.oficina.controller;
import com.example.oficina.dao.MaquinaDAO;
import com.example.oficina.dao.MecanicoDAO;
import com.example.oficina.dao.OrdemServicoDAO;
import com.example.oficina.model.Maquina;
import com.example.oficina.model.Mecanico;
import com.example.oficina.model.OrdemServico;
import com.example.oficina.service.MecanicoService;
import com.example.oficina.service.OrdemServicoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/*
@WebServlet("/ordem-servico")
public class OrdemServicoController extends HttpServlet {



    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String opcao = req.getParameter("opcao");

        if (opcao != null && opcao.equals("excluir")) {
            String id = req.getParameter("id");
            OrdemServico o = new OrdemServico();
            o.setIdOrdem(Integer.parseInt(id));

            RequestDispatcher dispatcher;
            if (new OrdemServicoService().deletar(o)) {
                dispatcher = req.getRequestDispatcher("/ordem_servico.jsp");
            } else {
                dispatcher = req.getRequestDispatcher("/error.jsp");
            }
            dispatcher.forward(req, resp);
        } else if (opcao != null && opcao.equals("editar")) {
            String idOrdem = req.getParameter("id");
            int id = Integer.parseInt(idOrdem);

            OrdemServico ordemServico = new OrdemServico();
            ordemServico.setIdOrdem(id);
            ordemServico.setIdMaquina(Integer.parseInt(req.getParameter("idMaquina")));
            ordemServico.setIdMecanico(Integer.parseInt(req.getParameter("idMecanico")));
            ordemServico.setDataRecebimento(req.getParameter("dataRecebimento"));
            ordemServico.setDataConclusao(req.getParameter("dataConclusao"));
            ordemServico.setPrecoFinal(Double.parseDouble(req.getParameter("precoFinal")));

            RequestDispatcher dispatcher;
            if (new OrdemServicoService().atualizar(ordemServico)) {
                dispatcher = req.getRequestDispatcher("/ordem_servico.jsp");
            } else {
                dispatcher = req.getRequestDispatcher("/error.jsp");
            }
            dispatcher.forward(req, resp);
        } else {
            int idMaquina = Integer.parseInt(req.getParameter("idMaquina"));
            int idMecanico = Integer.parseInt(req.getParameter("idMecanico"));
            String dataRecebimento = req.getParameter("dataRecebimento");
            String dataConclusao = req.getParameter("dataConclusao");
            double precoFinal = Double.parseDouble(req.getParameter("precoFinal"));

            OrdemServico ordemServico = new OrdemServico();
            ordemServico.setIdMaquina(idMaquina);
            ordemServico.setIdMecanico(idMecanico);
            ordemServico.setDataRecebimento(dataRecebimento);
            ordemServico.setDataConclusao(dataConclusao);
            ordemServico.setPrecoFinal(precoFinal);

            RequestDispatcher dispatcher;
            if (new OrdemServicoService().cadastrar(ordemServico)) {
                dispatcher = req.getRequestDispatcher("/ordem_servico.jsp");
            } else {
                dispatcher = req.getRequestDispatcher("/error.jsp");
            }
            dispatcher.forward(req, resp);
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MecanicoDAO mecanicoDAO = new MecanicoDAO();
        ArrayList<Mecanico> nomesMecanicos = mecanicoDAO.buscarTodosNomes();
        request.setAttribute("nomesMecanicos", nomesMecanicos);

        MaquinaDAO maquinaDAO = new MaquinaDAO();
        ArrayList<Maquina> nomesMaquinas = maquinaDAO.buscarTodosNomes();
        request.setAttribute("nomesMaquinas", nomesMaquinas);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/ordem_serviço.jsp");
        dispatcher.forward(request, response);
    }
}
*/
@Controller
@RequestMapping("/usuario/principal")
public class OrdemServicoController{
    @GetMapping("/ordemServico")
    public String cadastrarOrdemView(Model model){
        System.out.println("entrou no view ordem");
        model.addAttribute("ordens", new OrdemServicoDAO().getAllOrdensServico());
        model.addAttribute("ordem", new OrdemServico());
        model.addAttribute("mecanicos", new MecanicoDAO().getAllMecanicos());
        model.addAttribute("maquinas",new MaquinaDAO().getAllMaquinas());

        return "ordem_servico";
    }
    @PostMapping("/ordemServico")
    public RedirectView cadastrarOrdemView(@ModelAttribute("ordem")OrdemServico ordemServico, RedirectAttributes redirectAttributes){

        System.out.println("Chamou Post ordem");
        RedirectView redirectView = null;

        System.out.println("Cod mecanico"+ ordemServico.getIdMec());
        System.out.println("Cod maquina"+ ordemServico.getIdMaquina());

        boolean verifica;
        verifica = new OrdemServicoService().cadastrar(ordemServico);

        if(verifica == true){
            redirectView = new RedirectView("/usuario/principal/ordemServico",true);
            System.out.println("cadastrou");
        }
        else{
            redirectView = new RedirectView("/usuario/principal");
            redirectAttributes.addFlashAttribute("msgServidor", false);
            System.out.println("NÃO CADASTROU");
        }
        return redirectView;
    }

    @RequestMapping( "/excluirOrdem")
    public RedirectView excluirOrdemView(@RequestParam("idOrdem") int id, RedirectAttributes redirectAttributes){

        RedirectView redirectView = null;
        OrdemServico o = new OrdemServico();
        o.setIdOrdem(Integer.parseInt(String.valueOf(id)));
        System.out.println("id exclusao"+o.getIdOrdem());
        redirectView = new RedirectView("/usuario/principal/ordemServico",true);

        if(new OrdemServicoDAO().deletar(o)){
            System.out.println("Excluido "+o);
        }else{
            System.out.println("Nao excluido "+o);
        }
        return redirectView;
    }

    @GetMapping("/editarOrdem")
    public String editarOrdemView(@RequestParam("idOrdem") int id, Model model){
        System.out.println("Entrar no get Editar Ordem");
        model.addAttribute("ordem", new OrdemServicoDAO().GetOrdem(id));
        model.addAttribute("mecanico", new MecanicoDAO().GetMecanico(id));
        model.addAttribute("maquina", new MaquinaDAO().GetMaquina(id));

        return "editar_ordem";
    }
    @PostMapping("/editarOrdem")
    public RedirectView editarOrdemView(@ModelAttribute("ordem") OrdemServico ordem, RedirectAttributes redirectAttributes){

        System.out.println("ENTROU POST EDIT FOR");

        RedirectView redirectView = null;

        System.out.println("Ordem: "+ ordem.getIdOrdem());

        if(new OrdemServicoService().atualizar(ordem)){

            redirectView = new RedirectView("/usuario/principal/ordemServico", true);
            System.out.println("editou");

        }else{

            redirectView = new RedirectView("/usuario/principal/ordemServico", true);
            redirectAttributes.addFlashAttribute("msgServidor", false);
            System.out.println("Nao editou");


        }

        return redirectView;
    }

}

