package com.mycompany.dsdtrabalho1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Projeto {
    private String nome;
    private Date dataInicio;
    private Date dataConclusaoPrevista;
    private int equipeDevs;
    private Solicitador cliente;
    private String statusProjeto;
    private List<Projeto> projetos;

    public Projeto(String nome, Date dataInicio, Date dataConclusaoPrevista, int equipeDevs, Solicitador cliente, String statusProjeto) {
        this.nome = nome;
        this.dataInicio = dataInicio;
        this.dataConclusaoPrevista = dataConclusaoPrevista;
        this.equipeDevs = equipeDevs;
        this.cliente = cliente;
        this.statusProjeto = statusProjeto;
        this.projetos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataConclusaoPrevista() {
        return dataConclusaoPrevista;
    }

    public void setDataConclusaoPrevista(Date dataConclusaoPrevista) {
        this.dataConclusaoPrevista = dataConclusaoPrevista;
    }

    public int getEquipeDevs() {
        return equipeDevs;
    }

    public void setEquipeDevs(int equipeDevs) {
        this.equipeDevs = equipeDevs;
    }

    public Solicitador getCliente() {
        return cliente;
    }

    public void setCliente(Solicitador cliente) {
        this.cliente = cliente;
    }

    public String getStatusProjeto() {
        return statusProjeto;
    }

    public void setStatusProjeto(String statusProjeto) {
        this.statusProjeto = statusProjeto;
    }
}
