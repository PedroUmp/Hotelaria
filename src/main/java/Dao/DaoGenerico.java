package Dao;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;

public interface DaoGenerico<V> {

    int getContador();
    void setContador(int contador);
    LinkedHashMap<Integer, V> getLinkedHasmap();
    void setLinkedHashMap(LinkedHashMap<Integer, V> linkedHashMap);

    default V incluir(V obj) {
        return null;
    }

    V remover(Integer id);
    Optional<V> recuperarPorId(Integer id);
    List<V> recuperarTodos();

}
