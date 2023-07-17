package com.example.oficina.model;

public class Mecanico {



    public String getNomeMec() {
        return nomeMec;
    }

    public void setNomeMec(String nomeMec) {
        this.nomeMec = nomeMec;
    }

    public String getCpfMec() {
        return cpfMec;
    }

    public void setCpfMec(String cpfMec) {
        this.cpfMec = cpfMec;
    }

    public int getIdMec() {
        return idMec;
    }

    public void setIdMec(int idMec) {
        this.idMec = idMec;
    }

    private int idMec;
    private String nomeMec;
    private String cpfMec;

}
