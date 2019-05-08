/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.util.List;

/**
 *
 * @author Administrador
 */
public class Lead {
    
    int ID;
    String Nome;
    String Endereco;
    int Idade;
    String Curso;

    public Lead(int ID, String Nome, String Endereco, int Idade, String Curso) {
        this.ID = ID;
        this.Nome = Nome;
        this.Endereco = Endereco;
        this.Idade = Idade;
        this.Curso = Curso;
    }

    public Lead() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }

    public int getIdade() {
        return Idade;
    }

    public void setIdade(int Idade) {
        this.Idade = Idade;
    }

    public String getCurso() {
        return Curso;
    }

    public void setCurso(String Curso) {
        this.Curso = Curso;
    }

   
    
    
    
}
