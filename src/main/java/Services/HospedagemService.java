package Services;

import Classes.Cliente;
import Classes.Hospedagem;
import Dao.HospedagemDao;
import Dao.OcupacaoDao;
import Exceptions.EntidadeNaoEncontradaException;
import Principal.FabricaDeDaos;

import java.util.List;

public class HospedagemService {

    private final HospedagemDao hospedagemDao = FabricaDeDaos.getDAO(HospedagemDao.class);

    public Hospedagem incluirHospedagem(Hospedagem hospedagem) {
        return hospedagemDao.incluir(hospedagem);
    }

    public Hospedagem recuperarHospedagemPorId(int id) throws EntidadeNaoEncontradaException {
        return hospedagemDao.recuperarPorId(id).orElseThrow(() -> new EntidadeNaoEncontradaException("hospedagem número " + id + "não encontrado."));
    }

    public List<Hospedagem> recuperarHospedagens() {
        return hospedagemDao.recuperarTodos();
    }


    public void removerHospedagem(int id) throws EntidadeNaoEncontradaException {
        hospedagemDao.remover(id);
    }

    public void imprimirHospedagem() {
        List<Hospedagem> hospedagem = recuperarHospedagens();
        for (Hospedagem h : hospedagem) {
            System.out.println(h);
        }
    }

}
