package Dao.Implementacao;

import Classes.Cliente;
import Dao.ClienteDao;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ClienteDaoImplementado extends DaoGenericoImpl<Cliente> implements ClienteDao {
    public int recuperarPorNome(String nome) {
        int contadorRemocoes = 0;

        for (Map.Entry<Integer, Cliente> entry : linkedHashMap.entrySet()) {
            Cliente cliente = entry.getValue();
            if (cliente.getNome().equals(nome)) {
                return cliente.getId();
            }
        }
        return -1;
    }
}
