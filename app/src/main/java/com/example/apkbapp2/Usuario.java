package com.example.apkbapp2;

public class Usuario {
    int id;
    String nome, email, nomeUsuario, senha;

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return this.nome;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return this.email;
    }
    public void setNomeUsuario(String nomeUsuario){
        this.nomeUsuario = nomeUsuario;
    }
    public String getNomeUsuario(){
        return this.nomeUsuario;
    }
    public void setSenha(String Senha){
        this.senha = senha;
    }
    public String getSenha(){
        return this.senha;
    }
}
