package actividades3;

import java.util.ArrayList;

public class HashC<E extends Comparable<E>> {

    protected class Element {

        int mark;
        Register<E> reg;

        public Element(int mark, Register<E> reg) {
            this.mark = mark;
            this.reg = reg;
        }
    }

    protected ArrayList<Element> table;
    protected int m;

    public HashC(int n) {
        this.m = findClosestPrime(n);
        this.table = new ArrayList<Element>(m);
        for (int i = 0; i < m; i++) {
            this.table.add(new Element(0, null));
        }
    }

    private int findClosestPrime(int n) {
        // Implementar este método para encontrar el primo más cercano a n
        return n;
    }

    private int functionHash(int key) {
        return key % m;
    }

    private int linearProbing(int hashedAddress, int key) {
        // Implementar este método para la técnica de resolución de colisiones Linear Probing
        return (hashedAddress + 1) % m;
    }

    public void insert(int key, E reg) {
        int hashedAddress = functionHash(key);
        int address = hashedAddress;

        while (table.get(address).mark == 1) {
            address = linearProbing(address, key);
            if (address == hashedAddress) {
                System.out.println("Tabla de hash llena. No se puede insertar el elemento.");
                return;
            }
        }

        table.set(address, new Element(1, new Register<E>(key, reg)));
    }

    public E search(int key) {
        int hashedAddress = functionHash(key);
        int address = hashedAddress;

        while (table.get(address).mark != 0) {
            if (table.get(address).mark == 1 && table.get(address).reg.getKey() == key) {
                return table.get(address).reg.value;
            }
            address = linearProbing(address, key);
            if (address == hashedAddress) {
                break;
            }
        }

        return null;
    }

    public String toString() {
        String s = "D. Real\tD. Hash\tRegister\n";
        int i = 0;
        for (Element item : table) {
            s += (i++) + " -->\t";
            if (item.mark == 1) {
                int hashedAddress = functionHash(item.reg.getKey());
                s += hashedAddress + "\t" + item.reg + "\n";
            } else {
                s += "empty\n";
            }
        }
        return s;
    }
}
