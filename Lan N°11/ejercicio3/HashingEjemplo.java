package ejercicio3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class HashingEjemplo {
    private static final int LOAD_FACTOR_PERCENT = 40;

    public static void main(String[] args) {
        String filename = "D:\\2023 impar - IV\\F3\\Algoritmos - 05\\codigos\\Lan N\u00B011\\ejercicio3\\EMPLEADOS.TXT";
        int numElements = getNumElements(filename);
        int m = getPrimeNumber(numElements + calculateAdditionalCapacity(numElements));
        Employee[] hashTable = new Employee[m];

        readEmployeesFromFile(filename, hashTable, m);
        displayHashTable(hashTable);
    }

    private static int getNumElements(String filename) {
        int numElements = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            numElements = Integer.parseInt(br.readLine().split(",")[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return numElements;
    }

    private static int calculateAdditionalCapacity(int numElements) {
        return (numElements * LOAD_FACTOR_PERCENT) / 100;
    }

    private static int getPrimeNumber(int num) {
        while (!isPrime(num)) {
            num++;
        }
        return num;
    }

    private static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static void readEmployeesFromFile(String filename, Employee[] hashTable, int m) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            br.readLine(); // Skip the first line (number of elements)
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int code = Integer.parseInt(data[0]);
                String name = data[1];
                String address = data[2];
                insertEmployee(hashTable, m, code, name, address);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void insertEmployee(Employee[] hashTable, int m, int code, String name, String address) {
        int hash = hashFunction(code, m);
        int index = hash;
        int i = 1;
        while (hashTable[index] != null) {
            index = (hash + (int) Math.pow(i, 2)) % m;
            i++;
        }
        hashTable[index] = new Employee(code, name, address);
    }

    private static int hashFunction(int code, int m) {
        return code % m;
    }

    private static void displayHashTable(Employee[] hashTable) {
        System.out.println("Hash Table:");
        System.out.println("Index\tCode\tName\tAddress\t\tHash\tReal\tProbe Length");
        for (int i = 0; i < hashTable.length; i++) {
            Employee employee = hashTable[i];
            String code = "";
            String name = "";
            String address = "";
            String hash = "";
            String real = "";
            String probeLength = "";
            if (employee != null) {
                code = Integer.toString(employee.getCode());
                name = employee.getName();
                address = employee.getAddress();
                hash = Integer.toString(hashFunction(employee.getCode(), hashTable.length));
                real = Integer.toString(i);
                probeLength = Integer.toString(calculateProbeLength(hashTable, employee.getCode()));
            }
            System.out.println(i + "\t" + code + "\t" + name + "\t" + address + "\t\t" + hash + "\t" + real + "\t" + probeLength);
        }
    }

    private static int calculateProbeLength(Employee[] hashTable, int code) {
        int hash = hashFunction(code, hashTable.length);
        int index = hash;
        int i = 1;
        while (hashTable[index] != null && hashTable[index].getCode() != code) {
            index = (hash + (int) Math.pow(i, 2)) % hashTable.length;
            i++;
        }
        return i;
    }

    private static class Employee {
        private int code;
        private String name;
        private String address;

        public Employee(int code, String name, String address) {
            this.code = code;
            this.name = name;
            this.address = address;
        }

        public int getCode() {
            return code;
        }

        public String getName() {
            return name;
        }

        public String getAddress() {
            return address;
        }
    }
}
