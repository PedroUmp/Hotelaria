package Classes;
import anotacao.Id;

import java.util.Date;

public class Hospedagem {
    @Id
    int id;
    private float valor;
    private Date dataPagamento;
    private Ocupacao ocupacao;

    public Hospedagem(float valor, Date dataPagamento, Ocupacao ocupacao) {
        this.valor = valor;
        this.dataPagamento = dataPagamento;
        this.ocupacao = ocupacao;
    }

    public Hospedagem(float valor, Date dataPagamento) {
        this.valor = valor;
        this.dataPagamento = dataPagamento;
    }

    public Date getData() {
        return dataPagamento;
    }

    public float getValor() {
        return valor;
    }

    public void setData(Date data) {
        this.dataPagamento = data;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
    public Ocupacao getOcupacao() {
        return ocupacao;
    }
    public void setOcupacao(Ocupacao ocupacao) {
        this.ocupacao = ocupacao;
    }

    @Override
    public String toString() {
        return "id:" + id + "\n" + "valor: " + valor + "data: " + dataPagamento + "\n" +
                "Ocupação --> " + this.ocupacao.getId() + "Data início " + this.ocupacao.getDataInicio() + "Data término " + this.ocupacao.getDataFinal() + "\n" +
                "Quarto --> " + this.ocupacao.getQuarto().getId() + "numero: " + this.ocupacao.getQuarto().getNumero() + "valor diaria: " + this.ocupacao.getQuarto().getValorDiaria() + "\n" +
                "Cliente --> " + this.ocupacao.getCliente().getId() + "nome: " + this.ocupacao.getCliente().getNome();
    }
}
