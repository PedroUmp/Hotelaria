package Principal;

import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
public class FabricaDeDaos {
    private static final Map<Class<?>, Object> MAP = new HashMap<>();

    public static <T> T getDAO(Class<T> classeDaInterface) {
        Reflections reflections = new Reflections("Dao.Implementacao");
        Set<Class<? extends T>> conjunto = reflections.getSubTypesOf(classeDaInterface);
        if (conjunto.size() != 1) {
            throw new RuntimeException(
                    "Deve haver uma e apenas uma classe que implemente a interface " + classeDaInterface.getName());
        }
        Class<? extends T> classeQueImplementainterface = conjunto.iterator().next();

        T obj = (T) MAP.get(classeQueImplementainterface);
        if (obj == null) {
            try {
                obj = classeQueImplementainterface.getDeclaredConstructor().newInstance();
                MAP.put(classeQueImplementainterface, obj);
                System.out.printf("foi");
            } catch (InstantiationException |    // tentando instanciar uma interface
                     IllegalAccessException |    // construtor privado
                     InvocationTargetException | // empacota a exceção lançada pelo construtor
                     NoSuchMethodException e) {  // não tem construtor padrão
                System.out.printf("nao conseguiu");
                throw new RuntimeException(e);
            }
        }
        return obj;
    }
}

