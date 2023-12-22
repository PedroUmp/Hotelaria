package Classes;

import anotacao.Id;

import java.io.Serializable;

public class Cliente implements Serializable {
    @Id
    private int id;
    private String nome;
    private int ocupacao = 0;



    public Cliente(String nome) {
        this.nome = nome;
    }
    public Cliente() { }

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

    public int getOcupacao() {
        return ocupacao;
    }

    public void setOcupacao(int ocupacao) {
        this.ocupacao = ocupacao;
    }

    public String toString() {
        return this.id + ". Nome: " + this.nome + ", Ocupação: " + this.ocupacao;
    }
}
