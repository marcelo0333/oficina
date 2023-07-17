package com.example.oficina.dao;

import com.example.oficina.model.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ClienteDAO {

    public boolean salvar(Cliente c)  {
        boolean salvou = false;

        try(Connection con = new ConectaDB().getConexao()){
            String sql = "INSERT INTO cliente (nome, cpf) " +
                    "VALUES ('"+c.getNome()+"', '"+c.getCpf()+"')";

            System.out.println("SQL: "+sql);

            PreparedStatement pt = con.prepareStatement(sql);
            pt.setString(1,c.getNome());
            pt.setString(2,c.getCpf());

            Statement stmt = new ConectaDB().getConexao().createStatement();
            stmt.execute(sql);
            salvou = true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return salvou;
    }
    public boolean deletar(int idcliente){
        boolean salvou = false;
        String sql = "DELETE FROM cliente WHERE idcliente = " +idcliente;
        System.out.println("SQL"+sql);
        try{
            Statement stmt = new ConectaDB().getConexao().createStatement();
            stmt.execute(sql);
            salvou = true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return salvou;
    }
    public boolean atualizar(String novonome,int idcliente) {
        boolean salvou = false;

        String sql = "update cliente set nomecliente = '" + novonome + "' WHERE idcliente  = " +idcliente;

        System.out.println("SQL"+sql);


        try{
            Statement stmt = new ConectaDB().getConexao().createStatement();
            stmt.execute(sql);
            salvou = true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return salvou;
    }
    public ArrayList<Cliente> getClientes(){
        return null;
    }


}
