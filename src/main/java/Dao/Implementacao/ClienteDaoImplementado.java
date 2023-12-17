package Dao.Implementacao;

import Classes.Cliente;
import Dao.ClienteDao;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ClienteDaoImplementado extends DaoGenericoImpl<Cliente> implements ClienteDao {
    public int recuperarPorNome(String nome) {
        int contadorRemocoes = 0;

        // Iterar sobre os valores do linkedHashMap
        for (Map.Entry<Integer, Cliente> entry : linkedHashMap.entrySet()) {
            Cliente cliente = entry.getValue();

            // Verificar se o nome corresponde e remover o cliente
            if (cliente.getNome().equals(nome)) {
                return cliente.getId();
            }
        }
        return -1;
    }
}
