package com.example.oficina.service;


import com.example.oficina.dao.OrdemServicoDAO;
import com.example.oficina.model.OrdemServico;

public class OrdemServicoService {

        public boolean cadastrar(OrdemServico o) {
            return new OrdemServicoDAO().salvar(o);
        }

        public boolean atualizar(OrdemServico o) {
            return new OrdemServicoDAO().atualizar(o);
        }

        public boolean deletar(OrdemServico o) {
            return new OrdemServicoDAO().deletar(o);
        }
}


