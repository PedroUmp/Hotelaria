package Dao.Implementacao;

import Dao.DaoGenerico;
import anotacao.Id;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;

public class DaoGenericoImpl<V> implements DaoGenerico<V> {

    protected LinkedHashMap<Integer, V> linkedHashMap = new LinkedHashMap<>(16);
    private int contador = 0;



    public void DAOGenericoImpl() {
        linkedHashMap = new LinkedHashMap<>(16);
        contador = 0;
    }

    @Override
    public LinkedHashMap<Integer, V> getLinkedHasmap() {
        return linkedHashMap;
    }

    @Override
    public void setLinkedHashMap(LinkedHashMap<Integer, V> linkedHashMap) {
        this.linkedHashMap = linkedHashMap;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public V incluir(V obj) {

        Field campo = recuperaCampoIdentificador(obj);
        atribuirContadorAoCampoIdentificador(campo, obj);
        return linkedHashMap.put(contador, obj);
    }

    public V remover(Integer id) {
        return linkedHashMap.remove(id);
    }

    public Optional<V> recuperarPorId(Integer id) {
        V obj = linkedHashMap.get(id);
        Optional<V> opt = Optional.ofNullable(obj);
        return opt;
    }

    public List<V> recuperarTodos() {
        // Porque List tem método get(index) que Collection não possui.
        return new ArrayList<>(linkedHashMap.values()); // .stream().toList();  // java.util.LinkedHashMap$LinkedProdutoalues
    }

    private void atribuirContadorAoCampoIdentificador(Field campo, V obj) {
        try {
            campo.setAccessible(true);
            campo.set(obj, ++contador);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private Field recuperaCampoIdentificador(V obj) {
        Field[] campos = obj.getClass().getDeclaredFields();
        for (Field campo : campos) {
            if (campo.isAnnotationPresent(Id.class)) {
                return campo;
            }
        }
        throw new RuntimeException(
                "Deve haver um campo na classe " + obj.getClass().getName() +
                        " anotado com @Id");
    }
}

