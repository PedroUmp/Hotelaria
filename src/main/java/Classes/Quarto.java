package Classes;

import Dao.ClienteDao;

public class Quarto {
    private static int contador;
    private int id;
    private double valorDiaria;
    private int numero;
    private Cliente cliente;


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

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
