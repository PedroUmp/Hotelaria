package Classes;
import anotacao.Id;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;


public class Ocupacao implements Serializable {
    @Id
    private int id;
    private Date dataInicio;
    private Date dataFinal;
    private Cliente cliente;
    private Quarto quarto;

    public Ocupacao(Cliente cliente, Quarto quarto, Date dataInicio, Date dataFinal) {
        this.cliente = cliente;
        this.quarto = quarto;
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
    }

    public Ocupacao(Quarto quarto, Date dataInicio, Date dataFinal) {
        this.quarto = quarto;
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
    }
    public Ocupacao(Cliente cliente, Date dataInicio, Date dataFinal) {
        this.cliente = cliente;
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
    }

    public Ocupacao(Date dataInicio, Date dataFinal) {
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
    }


    private static final NumberFormat NF;

    static {
        NF = NumberFormat.getNumberInstance(new Locale("pt", "BR"));

        NF.setMaximumFractionDigits(2);
        NF.setMinimumFractionDigits(2);
    }


    public Cliente getCliente() {
        return cliente;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public Date getDataInicio() {
        return dataInicio;
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

    public void setDataInicio(Date dataIncio) {
        this.dataInicio = dataIncio;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Id: " + this.id + "\n" +  "Data de Início: " + this.dataInicio + "\n" + "Data de Término: " + this.dataFinal + "\n" +
                "Quarto --> " + this.quarto + "\n" + "Cliente --> " + this.cliente +"\n\n";
    }
}
