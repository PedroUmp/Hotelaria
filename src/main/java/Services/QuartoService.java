package Services;

import Classes.Cliente;
import Classes.Quarto;
import Dao.ClienteDao;
import Dao.QuartoDao;
import Exceptions.EntidadeNaoEncontradaException;
import Principal.FabricaDeDaos;

import java.util.List;

public class QuartoService {

    private final QuartoDao quartoDao = FabricaDeDaos.getDAO(QuartoDao.class);

    public Quarto incluir(Quarto quarto){
        return quartoDao.incluir(quarto);
    }

    public Quarto alterarNumero(Quarto quarto, int novoNumero) {
        quarto.setNumero(novoNumero);
        return quarto;
    }

    public Quarto alterarValorDiaria(Quarto quarto, int novoValorDiaria) {
        quarto.setValorDiaria(novoValorDiaria);
        return quarto;
    }


    public Quarto recuperarQuartoPorId(int id) throws EntidadeNaoEncontradaException {
        Quarto quarto = quartoDao.recuperarPorId(id).orElseThrow(() -> new EntidadeNaoEncontradaException("Cliente número " + id + "não encontrado."));
        return quarto;
    }

    public void removerQuarto(int id) {
        quartoDao.remover(id);
    }


    public List<Quarto> recuperarQuartos() {
        return quartoDao.recuperarTodos();
    }

    public void imprimirQuartos() {
        List<Quarto> quartos = recuperarQuartos();
        for (Quarto q : quartos) {
            System.out.println(q);
        }
    }

//    public int recuperarQuartoPorNumero(int numero) {
//        return quartoDao.recuperarPorNumero(nome);
//    }
//
//    public void removerCliente(int id) throws EntidadeNaoEncontradaException {
//        Quarto cliente = recuperarClientePorId(id);
//        quartoDao.remover(id);
//        }

}
