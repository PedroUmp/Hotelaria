package Classes;

import Dao.ClienteDao;
import anotacao.Id;

import java.io.Serializable;

public class Quarto implements Serializable {
    @Id
    private int id;
    private int valorDiaria;
    private int numero;
    private int ocupacao = 0;


    public Quarto(int numero, int valorDiaria) {
        this.numero = numero;
        this.valorDiaria = valorDiaria;
    }
    public Quarto() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setValorDiaria(int valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public int getOcupacao() {
        return ocupacao;
    }

    public void setOcupacao(int ocupacao) {
        this.ocupacao = ocupacao;
    }

    @Override
    public String toString() {
        return this.id + ". Número: " + this.numero + ", Valor diária: " + this.valorDiaria + ", Ocupação: " + this.ocupacao;
    }
}
