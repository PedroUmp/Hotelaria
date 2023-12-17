package Classes;
import java.util.Date;

public class Hospedagem {
    private float valor;
    private Date dataPagamento;

    public Hospedagem(float valor, Date dataPagamento) {

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

    public void setValor(int valor) {
        this.valor = valor;
    }
}
