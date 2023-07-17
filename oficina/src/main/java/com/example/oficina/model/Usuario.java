package com.example.oficina.model;

/*

CREATE TABLE usuario(
	id_usuario serial NOT NULL PRIMARY KEY,
	nome varchar(20),
	cpf varchar(20),
	login varchar(20),
	senha varchar(20)
);
* */

public class Usuario {

    private int id;
    private String nome;
    private String cpf;
    private String login;

    private String senha;

    public Usuario(){

    }

    public Usuario(int id, String nome, String cpf, String login, String senha) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.login = login;
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }



}
