package com.example.oficina.dao;

import com.example.oficina.model.Maquina;
import com.example.oficina.model.Mecanico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MaquinaDAO {



    public boolean salvar(Maquina m){
        boolean salvou = true;

        try(Connection con = new ConectaDB().getConexao()){

            String sql = "INSERT INTO maquina(nome_maq, descricao) VALUES(?,?)";
            PreparedStatement pt = con.prepareStatement(sql);

            pt.setString(1, m.getNomeMaquina());
            pt.setString(2, m.getDescMaquina());
            System.out.println("sql:"+pt.toString());

            ResultSet rs = pt.executeQuery();


        }catch(Exception e){
            e.printStackTrace();
        }


        return salvou;
    }
    public ArrayList<Maquina> getAllMaquinas() {

        ArrayList<Maquina> maquinas = new ArrayList<>();

        try (Connection con = new ConectaDB().getConexao()) {
            String sql = "SELECT * FROM maquina";


            PreparedStatement pt = con.prepareStatement(sql);
            System.out.println("sql: " + pt.toString());
            ResultSet rs = pt.executeQuery();

            while (rs.next()) {
                Maquina maquina = new Maquina();

                maquina.setIdMaquina(rs.getInt("id_maq"));
                maquina.setNomeMaquina(rs.getString("nome_maq"));
                maquina.setDescMaquina(rs.getString("descricao"));
                maquinas.add(maquina);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return maquinas;
    }

    public boolean deletar(Maquina m) {
        boolean deletou = true;

        try (Connection con = new ConectaDB().getConexao()) {
            String sql = "DELETE FROM maquina WHERE id_maq = ?";
            PreparedStatement pt = con.prepareStatement(sql);
            pt.setInt(1, m.getIdMaquina());
            System.out.println("sql: " + pt.toString());
            ResultSet rs = pt.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return deletou;
    }

    public boolean atualizar(Maquina m) {
        boolean atualizou = false;

        try (Connection con = new ConectaDB().getConexao()) {
            String sql = "UPDATE maquina SET nome_maq = ?, descricao = ? WHERE id_maq = ?";
            PreparedStatement pt = con.prepareStatement(sql);
            pt.setString(1, m.getNomeMaquina());
            pt.setString(2, m.getDescMaquina());
            pt.setInt(3, m.getIdMaquina());
            System.out.println("sql: " + pt.toString());
            int result = pt.executeUpdate();

            if (result > 0) {
                atualizou = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return atualizou;
    }
    public ArrayList<Maquina> buscarTodosNomes() {
        ArrayList<Maquina> nomesMaquinas = new ArrayList<>();

        try (Connection con = new ConectaDB().getConexao()) {
            String sql = "SELECT nome_maq FROM maquina";

            PreparedStatement pt = con.prepareStatement(sql);
            ResultSet rs = pt.executeQuery();

            while (rs.next()) {
                Maquina maquina = new Maquina();

                maquina.setNomeMaquina(rs.getString("nome_maq"));
                nomesMaquinas.add(maquina);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return nomesMaquinas;
    }
    public Maquina GetMaquina(int id) {

        Maquina m = new Maquina();
        try (Connection con = new ConectaDB().getConexao()) {
            String sql = "SELECT * FROM maquina WHERE id_maq = ?";



            PreparedStatement pt = con.prepareStatement(sql);
            pt.setInt(1, id);
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                m.setNomeMaquina(rs.getString("nome_maq"));
                m.setDescMaquina(rs.getString("descricao"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return m;
    }

}


