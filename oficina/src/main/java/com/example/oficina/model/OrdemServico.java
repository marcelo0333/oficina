package com.example.oficina.model;

import java.sql.Date;
import java.time.LocalDate;

public class OrdemServico {
    public int getIdOrdem() {
        return idOrdem;
    }

    public void setIdOrdem(int idOrdem) {
        this.idOrdem = idOrdem;
    }

    public int getIdMaquina() {
        return idMaquina;
    }

    public void setIdMaquina(int idMaquina) {
        this.idMaquina = idMaquina;
    }






    public double getPrecoFinal() {
        return precoFinal;
    }

    public void setPrecoFinal(double precoFinal) {
        this.precoFinal = precoFinal;
    }

    private int idOrdem;
    private int idMaquina;

    public int getIdMec() {
        return idMec;
    }

    public void setIdMec(int idMec) {
        this.idMec = idMec;
    }

    private int idMec;
    private String dataRecebimento;

    public String getDataRecebimento() {
        return dataRecebimento;
    }

    public void setDataRecebimento(String dataRecebimento) {
        this.dataRecebimento = dataRecebimento;
    }

    public String getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(String dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    private String dataConclusao;
    private double precoFinal;




    private  String nomeMec;

    public String getNomeMec() {
        return nomeMec;
    }

    public void setNomeMec(String nomeMec) {
        this.nomeMec = nomeMec;
    }

    public String getNomeMaq() {
        return nomeMaq;
    }

    public void setNomeMaq(String nomeMaq) {
        this.nomeMaq = nomeMaq;
    }

    private  String nomeMaq;
}

