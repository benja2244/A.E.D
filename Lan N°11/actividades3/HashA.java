package actividades3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HashA<E extends Comparable<E>> {

    private int size;
    private List<List<Register<E>>> table;

    public HashA(int size) {
        this.size = size;
        this.table = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            table.add(new LinkedList<>());
        }
    }

    private int functionHash(int key) {
        return key % size;
    }

    public void insert(int key, E value) {
        int index = functionHash(key);
        List<Register<E>> chain = table.get(index);
        chain.add(new Register<>(key, value));
    }

    public E search(int key) {
        int index = functionHash(key);
        List<Register<E>> chain = table.get(index);
        for (Register<E> register : chain) {
            if (register.getKey() == key) {
                return register.value;
            }
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(i).append(" --> ");
            List<Register<E>> chain = table.get(i);
            if (chain.isEmpty()) {
                sb.append("empty");
            } else {
                for (Register<E> register : chain) {
                    sb.append(register).append(" -> ");
                }
                sb.setLength(sb.length() - 4);  // Eliminar el último " -> "
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
