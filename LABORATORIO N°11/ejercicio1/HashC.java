package ejercicio1;

import java.util.ArrayList;

public class HashC<E extends Comparable<E>> {

    protected class Register<E> {
        protected int key;
        protected E value;

        public Register(int key, E value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return this.key;
        }

        public E getValue() {
            return this.value;
        }

        public String toString() {
            return this.key + ":" + this.value.toString();
        }
    }

    protected ArrayList<Register<E>> table;
    protected int m;
    protected HashFunction hashFunction;

    public enum HashFunction {
        SQUARE_METHOD,
        FOLDING_METHOD
    }

    public HashC(int n) {
        this.m = n;
        this.table = new ArrayList<>(m);
        for (int i = 0; i < m; i++) {
            this.table.add(null);
        }
        this.hashFunction = HashFunction.SQUARE_METHOD; // Método del cuadrado por defecto
    }

    public void setHashFunction(HashFunction function) {
        this.hashFunction = function;
    }

    private int squareMethodHash(int key) {
        return (int) Math.pow(key, 2) % m;
    }

    private int foldingMethodHash(int key) {
        int sum = 0;
        while (key > 0) {
            sum += key % 100; // Suma de dígitos de dos en dos
            key /= 100;
        }
        return sum % m;
    }

    private int calculateHash(int key) {
        if (hashFunction == HashFunction.SQUARE_METHOD) {
            return squareMethodHash(key);
        } else {
            return foldingMethodHash(key);
        }
    }

    public void insert(int key, E value) {
        int hash = calculateHash(key);
        Register<E> register = new Register<>(key, value);
        table.set(hash, register);
    }

    public String toString() {
        String s = "Tabla HashC:\n";
        for (int i = 0; i < table.size(); i++) {
            Register<E> item = table.get(i);
            s += i + " --> ";
            if (item != null) {
                s += item.getKey() + " --> " + item.toString() + "\n";
            } else {
                s += "empty\n";
            }
        }
        return s;
    }
}
