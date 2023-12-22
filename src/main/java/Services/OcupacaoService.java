package Services;

import Classes.Cliente;
import Classes.Ocupacao;
import Dao.OcupacaoDao;
import Exceptions.AtributoComOcupacaoExeption;
import Exceptions.EntidadeNaoEncontradaException;
import Principal.FabricaDeDaos;

import java.util.List;

public class OcupacaoService {

    private final OcupacaoDao ocupacaoDao = FabricaDeDaos.getDAO(OcupacaoDao.class);

    public Ocupacao incluirOcupacao(Ocupacao ocupacao) {
        return ocupacaoDao.incluir(ocupacao);
    }


//    public Ocupacao recuperarOcupacaoPorCliente(int id) throws EntidadeNaoEncontradaException {
//        return ocupacaoDao.recuperarPorId(id).orElseThrow(() -> new EntidadeNaoEncontradaException("Cliente número " + id + "não encontrado."));
//    }

    public Ocupacao recuperarOcupacaoPorId(int id) throws EntidadeNaoEncontradaException {
        return ocupacaoDao.recuperarPorId(id).orElseThrow(() -> new EntidadeNaoEncontradaException("Cliente número " + id + "não encontrado."));
    }


    public List<Ocupacao> recuperarOcupacoes() {
        return ocupacaoDao.recuperarTodos();
    }

    public void removerOcupacao(int id) throws EntidadeNaoEncontradaException {
        ocupacaoDao.remover(id);
    }

    public void imprimirOcupacoes() {
        List<Ocupacao> ocupacoes = recuperarOcupacoes();
        for(Ocupacao o : ocupacoes) {
            System.out.println(o);
        }
    }
}

