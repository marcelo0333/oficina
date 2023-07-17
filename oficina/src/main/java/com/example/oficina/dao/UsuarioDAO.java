package com.example.oficina.dao;

import com.example.oficina.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UsuarioDAO {


    public Usuario getUsuario(Usuario u){
        try(Connection con = new ConectaDB().getConexao()){

            String sql = "SELECT * " +
                    "FROM usuario WHERE login = ?";

            PreparedStatement pt = con.prepareStatement(sql);
            pt.setString(1, u.getLogin());
            System.out.println("sql: "+pt.toString());
            ResultSet rs = pt.executeQuery();

            while (rs.next()){
                u.setId(rs.getInt("id_usuario"));
                u.setNome(rs.getString("nome_user"));
                u.setCpf(rs.getString("cpf"));
                u.setLogin(rs.getString("login"));
                u.setSenha(rs.getString("senha"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Nome do usuario: "+u.getNome());

        return u;
    }
    public boolean salvar(Usuario u){
        boolean salvou = true;

        try (Connection con = new ConectaDB().getConexao()){
            String sql = "INSERT INTO usuario(nome_user, cpf, senha, login) VALUES (?, ?, ?, ?)";
            PreparedStatement pt = con.prepareStatement(sql);
            pt.setString(1,u.getNome());
            pt.setString(2, u.getCpf());
            pt.setString(3,u.getSenha());
            pt.setString(4,u.getLogin());

            System.out.println("sql: "+pt.toString());
            ResultSet rs = pt.executeQuery();

        } catch (Exception e){
            e.printStackTrace();
        }
        return salvou;

    }
    public ArrayList<Usuario> getAllUsers(){


        ArrayList<Usuario> usuarios = new ArrayList<>();

        try(Connection con = new ConectaDB().getConexao()){

            String sql = "SELECT * " +
                    "FROM usuario";

            PreparedStatement pt = con.prepareStatement(sql);

            System.out.println("sql: "+pt.toString());
            ResultSet rs = pt.executeQuery();

            while (rs.next()){
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id_usuario"));
                usuario.setNome(rs.getString("nome_user"));
                usuario.setCpf(rs.getString("cpf"));
                usuario.setLogin(rs.getString("login"));
                usuario.setSenha(rs.getString("senha"));

                usuarios.add(usuario);

            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return usuarios;

    }
    public boolean deletar(Usuario u){
        boolean salvou = true;
        String sql = "DELETE FROM usuario WHERE id_usuario= "+u.getId();
        try(Connection con = new ConectaDB().getConexao()){
            PreparedStatement pt = con.prepareStatement(sql);
            System.out.println("sql: "+pt.toString());
            ResultSet rs = pt.executeQuery();

        } catch (Exception e){
            e.printStackTrace();
        }
        return salvou;
    }
    public boolean atualizar(Usuario u) {
        boolean salvou = false;

        String sql = "update usuario set nome_user = '" + u.getNome()+ "' WHERE id_usuario  = "+u.getId();


        try(Connection con = new ConectaDB().getConexao()){
            PreparedStatement pt = con.prepareStatement(sql);
            System.out.println("sql: "+pt.toString());
            ResultSet rs = pt.executeQuery();

        } catch (Exception e){
            e.printStackTrace();
        }
        return salvou;

    }
}


