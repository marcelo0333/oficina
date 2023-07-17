package com.example.oficina.dao;

import com.example.oficina.model.Mecanico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MecanicoDAO {

    public boolean salvar(Mecanico m) {

        boolean salvou = true;

        try (Connection con = new ConectaDB().getConexao()) {

            String sql = "INSERT INTO mecanico(nome_func, cpf) VALUES(?, ?) ";

            PreparedStatement pt = con.prepareStatement(sql);
            pt.setString(1, m.getNomeMec());
            pt.setString(2, m.getCpfMec());

            System.out.println("sql:" + pt.toString());

            ResultSet rs = pt.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return salvou;
    }

    public boolean deletar(Mecanico m) {
        boolean deletou = true;

        try (Connection con = new ConectaDB().getConexao()) {
            String sql = "DELETE FROM mecanico WHERE id_mec = ?";
            PreparedStatement pt = con.prepareStatement(sql);
            pt.setInt(1, m.getIdMec());
            System.out.println("sql:" + pt.toString());
            ResultSet rs = pt.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return deletou;
    }

    public boolean atualizar(Mecanico m) {
        boolean atualizou = true;

        try (Connection con = new ConectaDB().getConexao()) {
            String sql = "UPDATE mecanico SET nome_func = ?, cpf = ? WHERE id_mec = ?";
            PreparedStatement pt = con.prepareStatement(sql);
            pt.setString(1, m.getNomeMec());
            pt.setString(2, m.getCpfMec());
            pt.setInt(3, m.getIdMec());
            System.out.println("sql:" + pt.toString());
            ResultSet rs = pt.executeQuery();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Mecanico> getAllMecanicos() {
        ArrayList<Mecanico> mecanicos = new ArrayList<>();

        try (Connection con = new ConectaDB().getConexao()) {
            String sql = "SELECT * FROM mecanico";
            PreparedStatement pt = con.prepareStatement(sql);
            System.out.println("sql: " + pt.toString());
            ResultSet rs = pt.executeQuery();

            while (rs.next()) {
                Mecanico mecanico = new Mecanico();
                mecanico.setIdMec(rs.getInt("id_mec"));
                mecanico.setNomeMec(rs.getString("nome_func"));
                mecanico.setCpfMec(rs.getString("cpf"));
                mecanicos.add(mecanico);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return mecanicos;
    }

    public ArrayList<Mecanico> buscarTodosNomes() {
        ArrayList<Mecanico> nomesMecanicos = new ArrayList<>();

        try (Connection con = new ConectaDB().getConexao()) {
            String sql = "SELECT nome_func FROM mecanico";

            PreparedStatement pt = con.prepareStatement(sql);
            ResultSet rs = pt.executeQuery();

            while (rs.next()) {
                Mecanico mecanico = new Mecanico();

                mecanico.setNomeMec(rs.getString("nome_func"));
                nomesMecanicos.add(mecanico);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return nomesMecanicos;
    }

    public Mecanico GetMecanico(int id) {

        ArrayList<Mecanico> dadosMecanico = new ArrayList<>();
        Mecanico m = new Mecanico();
        try (Connection con = new ConectaDB().getConexao()) {
            String sql = "SELECT * FROM mecanico WHERE id_mec = ?";



            PreparedStatement pt = con.prepareStatement(sql);
            pt.setInt(1, id);
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                m.setNomeMec(rs.getString("nome_func"));
                m.setCpfMec(rs.getString("cpf"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return m;
    }

}