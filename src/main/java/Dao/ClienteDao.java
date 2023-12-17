package Dao;

import Classes.Cliente;
import Classes.Quarto;

import java.util.List;

public interface ClienteDao extends DaoGenerico<Cliente>  {
    int recuperarPorNome(String nome);
}
