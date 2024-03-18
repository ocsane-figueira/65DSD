

package com.mycompany.dsdtrabalho1;


  public class Solicitador extends Pessoa {
    private int historicoDeSolicitacoes;

    public Solicitador(String cpf, String nome, String endereco, String contato, int idUnico, int historicoDeSolicitacoes) {
        super(cpf, nome, endereco, contato, idUnico);
        this.historicoDeSolicitacoes = historicoDeSolicitacoes;
    }

    public int getHistoricoDeSolicitacoes() {
        return historicoDeSolicitacoes;
    }

    public void setHistoricoDeSolicitacoes(int historicoDeSolicitacoes) {
        this.historicoDeSolicitacoes = historicoDeSolicitacoes;
    }
}


