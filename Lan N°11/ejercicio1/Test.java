package ejercicio1;

public class Test {
    public static void main(String[] args) {
        HashC<String> hashTable = new HashC<>(11);

        hashTable.insert(34, "Reg 1");
        hashTable.insert(3, "Reg 2");
        hashTable.insert(7, "Reg 3");
        hashTable.insert(30, "Reg 4");
        hashTable.insert(11, "Reg 5");
        hashTable.insert(8, "Reg 6");
        hashTable.insert(7, "Reg 7");
        hashTable.insert(23, "Reg 8");
        hashTable.insert(41, "Reg 9");
        hashTable.insert(16, "Reg 10");
        hashTable.insert(34, "Reg 11");

        System.out.println(hashTable.toString());
    }
}
