package com.example.oficina.service;

import com.example.oficina.dao.MecanicoDAO;
import com.example.oficina.model.Mecanico;

public class MecanicoService {

    public boolean cadastrar(Mecanico m) {

        return new MecanicoDAO().salvar(m);
    }

    public boolean deletar(Mecanico m) {

        return new MecanicoDAO().deletar(m);

    }

    public boolean atualizar(Mecanico m) {

        return new MecanicoDAO().atualizar(m);

    }
}

