
package com.mycompany.dsdtrabalho1;


public class Desenvolvedor extends Pessoa {
    private String habilidadeTecnica;

    public Desenvolvedor(String cpf, String nome, String endereco, String contato, int idUnico, String habilidadeTecnica) {
        super(cpf, nome, endereco, contato, idUnico);
        this.habilidadeTecnica = habilidadeTecnica;
    }

    public String getHabilidadeTecnica() {
        return habilidadeTecnica;
    }

    public void setHabilidadeTecnica(String habilidadeTecnica) {
        this.habilidadeTecnica = habilidadeTecnica;
    }
}

