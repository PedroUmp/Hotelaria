package Classes;

import anotacao.Id;

import java.io.Serializable;

public class Cliente implements Serializable {
    @Id
    private int id;
    private String nome;



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

    public String toString() {
        return "Nome: " + this.nome + ", Id: " +  this.id;
    }
}
