package Dao;

import Classes.Quarto;

import java.util.List;

public interface QuartoDao {
    Quarto inserir(Quarto quarto);
    Quarto alterar(Quarto quarto);
    Quarto remover(Integer id);
    Quarto recupearPorId(Integer id);

    List<Quarto> recuperarTodos();
}
