package com.example.oficina.service;

import com.example.oficina.dao.UsuarioDAO;
import com.example.oficina.model.Usuario;

public class UsuarioService {
    public boolean autenticar(Usuario u) {

        new UsuarioDAO().getUsuario(u);
        if (u.getNome() == null) {
            System.out.println("usuário null -> " + u.toString());
            return false;
        } else {
            if (u.getLogin().equals(u.getLogin()) && u.getSenha().equals(u.getSenha())) {

                return true;
            } else {
                return false;
            }
        }
    }
        public boolean cadastrar(Usuario u){

       return new UsuarioDAO().salvar(u);

    }
    public boolean deletar(Usuario u){

        return new UsuarioDAO().deletar(u);

    }
    public boolean atualizar(Usuario u){

        return new UsuarioDAO().atualizar(u);

    }

}
