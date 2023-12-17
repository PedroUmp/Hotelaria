package Dao.Implementacao;

import Classes.Quarto;
import Dao.QuartoDao;

import java.util.LinkedHashMap;
import java.util.List;

public class QuartoDaoImplementado implements QuartoDao {

    //Id do quarto e o objeto quarto são armazenados juntos
    private final LinkedHashMap<Integer, Quarto> hashmapDeQuartos = new LinkedHashMap<Integer, Quarto>();

    public Quarto inserir(Quarto quarto) {
        return hashmapDeQuartos.put(quarto.getId(), quarto);
    }
    public Quarto alterar(Quarto quarto) {
        return hashmapDeQuartos.put(quarto.getId(), quarto);
    }
    public Quarto remover(Integer id) {
        return hashmapDeQuartos.remove(id);
    }

    public Quarto recupearPorId(Integer id) {
        return hashmapDeQuartos.get(id);
    }

    //Duvida nisso
    public List<Quarto> recuperarTodos() {
        return null;
    }
}
