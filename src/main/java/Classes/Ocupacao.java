package Classes;
import java.util.Date;


public class Ocupacao {
    private Date dataIncio;
    private Date dataFinal;
    private Cliente cliente;
    private Quarto quarto;

    public Ocupacao(Date dataInicio, Date dataFinal, Cliente cliente, Quarto quarto) {
        this.dataFinal = dataFinal;
        this.dataIncio = dataInicio;
        this.cliente = cliente;
        this.quarto = quarto;
    }


    public Cliente getCliente() {
        return cliente;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public Date getDataIncio() {
        return dataIncio;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public void setDataIncio(Date dataIncio) {
        this.dataIncio = dataIncio;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

}
