package Services;

import Classes.Cliente;
import Dao.ClienteDao;
import Dao.DaoGenerico;
import Exceptions.EntidadeNaoEncontradaException;
import Principal.FabricaDeDaos;
import java.util.List;

public class ClienteService {
    private final ClienteDao clienteDao = FabricaDeDaos.getDAO(ClienteDao.class);

    public Cliente incluir(Cliente cliente) {
        return clienteDao.incluir(cliente);
    }

    public Cliente alterar(Cliente cliente, String novoNome) {
        cliente.setNome(novoNome);
        return cliente;
    }

    public Cliente recuperarClientePorId(int id) throws EntidadeNaoEncontradaException {
        Cliente cliente = clienteDao.recuperarPorId(id).orElseThrow(() -> new EntidadeNaoEncontradaException("Cliente número " + id + "não encontrado."));
        return cliente;
    }


    public List<Cliente> recuperarClientes() {
        return clienteDao.recuperarTodos();
    }

    public int recuperarPorNome(String nome) {
        return clienteDao.recuperarPorNome(nome);
    }

    public void removerCliente(int id) throws EntidadeNaoEncontradaException {
        clienteDao.remover(id);
    }

    public void imprimirClientes() {
        List<Cliente> clientes = recuperarClientes();
        for (Cliente c : clientes) {
            System.out.println(c);
        }
    }
}

