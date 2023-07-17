package com.example.oficina.dao;

import com.example.oficina.model.Mecanico;
import com.example.oficina.model.OrdemServico;

import java.sql.*;
import java.util.ArrayList;

public class OrdemServicoDAO {
    public boolean salvar(OrdemServico o) {
        boolean salvou = false;

        try (Connection con = new ConectaDB().getConexao()) {
            String sql = "INSERT INTO ordem_serv (fk_id_maq, fk_id_mec, data_rec, data_fim, preco_final) " +
                    "VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pt = con.prepareStatement(sql);
            pt.setInt(1, o.getIdMaquina());
            pt.setInt(2, o.getIdMec());
            pt.setString(3, o.getDataRecebimento());
            pt.setString(4, o.getDataConclusao());
            pt.setDouble(5, o.getPrecoFinal());

            salvou = true;
            ResultSet rs = pt.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return salvou;
    }

    public ArrayList<OrdemServico> getAllOrdensServico() {
        ArrayList<OrdemServico> ordens = new ArrayList<>();

        try (Connection con = new ConectaDB().getConexao()) {
            String sql = "SELECT o.id_ord, o.data_rec,o.fk_id_mec,o.fk_id_maq, o.data_fim, o.preco_final, m.nome_func as nome_func, ma.nome_maq as nome_maq\n" +
                    "FROM ordem_serv o\n" +
                    "JOIN mecanico m ON o.fk_id_mec = m.id_mec\n" +
                    "JOIN maquina ma ON o.fk_id_maq = ma.id_maq;";
            PreparedStatement pt = con.prepareStatement(sql);
            ResultSet rs = pt.executeQuery();

            while (rs.next()) {
                OrdemServico o = new OrdemServico();
                o.setIdOrdem(rs.getInt("id_ord"));
                o.setIdMaquina(rs.getInt("fk_id_maq"));
                o.setIdMec(rs.getInt("fk_id_mec"));
                o.setNomeMaq(rs.getString("nome_maq"));
                o.setNomeMec(rs.getString("nome_func"));
                o.setDataRecebimento(rs.getString("data_rec"));
                o.setDataConclusao(rs.getString("data_fim"));
                o.setPrecoFinal(rs.getDouble("preco_final"));

                ordens.add(o);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ordens;
    }

    public boolean atualizar(OrdemServico ordem) {
        boolean atualizou = false;

        try (Connection con = new ConectaDB().getConexao()) {
            String sql = "UPDATE ordem_serv SET fk_id_maq = ?, fk_id_mec = ?, data_rec = ?, " +
                    "data_fim = ?, preco_final = ? WHERE id_ord = ?";
            PreparedStatement pt = con.prepareStatement(sql);
            pt.setInt(1, ordem.getIdMaquina());
            pt.setInt(2, ordem.getIdMec());
            pt.setString(3, ordem.getDataRecebimento());
            pt.setString(4, ordem.getDataConclusao());
            pt.setDouble(5, ordem.getPrecoFinal());
            pt.setInt(6, ordem.getIdOrdem());

            System.out.println("sql "+sql);
            atualizou = true;
            ResultSet rs = pt.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return atualizou;
    }

    public boolean deletar(OrdemServico o) {
        boolean deletou = false;

        try (Connection con = new ConectaDB().getConexao()) {
            String sql = "DELETE FROM ordem_serv WHERE id_ord = ?";
            PreparedStatement pt = con.prepareStatement(sql);
            pt.setInt(1, o.getIdOrdem());
            System.out.println("sql "+sql);

            deletou = true;
            ResultSet rs = pt.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return deletou;
    }
    public OrdemServico GetOrdem(int id) {

        OrdemServico o = new OrdemServico();
        try (Connection con = new ConectaDB().getConexao()) {
            String sql = "SELECT o.*, m.nome_func, ma.nome_maq\n" +
                    "FROM ordem_serv o\n" +
                    "JOIN mecanico m ON o.fk_id_mec = m.id_mec\n" +
                    "JOIN maquina ma ON o.fk_id_maq = ma.id_maq\n" +
                    "WHERE o.id_ord = ?;";



            PreparedStatement pt = con.prepareStatement(sql);
            pt.setInt(1, id);
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                o.setIdMec(rs.getInt("fk_id_mec"));
                o.setIdMaquina(rs.getInt("fk_id_maq"));
                o.setNomeMec(rs.getString("nome_func"));
                o.setNomeMaq(rs.getString("nome_maq"));
                o.setDataRecebimento(rs.getString("data_rec"));
                o.setDataConclusao(rs.getString("data_fim"));
                o.setPrecoFinal(rs.getDouble("preco_final"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return o;
    }
}

