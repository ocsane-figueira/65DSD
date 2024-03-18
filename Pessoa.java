
package com.mycompany.dsdtrabalho1;

public class Pessoa {
   private String nome;
    private String cpf;
    private String endereco;
    String contato;
    int idUnico;

    public Pessoa(String cpf, String nome, String endereco, String contato, int idUnico) {
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
        this.contato = contato;
        this.idUnico = idUnico;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public int getIdUnico() {
        return idUnico;
    }

    public void setIdUnico(int idUnico) {
        this.idUnico = idUnico;
    }
}