package com.example.oficina.service;

import com.example.oficina.dao.MaquinaDAO;
import com.example.oficina.model.Maquina;

public class MaquinaService {

    public boolean cadastrar(Maquina m){

        return new MaquinaDAO().salvar(m);
    }

    public boolean deletar(Maquina m){

        return new MaquinaDAO().deletar(m);

    }
    public boolean atualizar(Maquina m){

        return new MaquinaDAO().atualizar(m);

    }
}
