package ejercicio4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class test {

    public static void main(String[] args) {
        String filename = "D:\\2023 impar - IV\\F3\\Algoritmos - 05\\codigos\\Lan N\u00B011\\ejercicio3\\EMPLEADOS.TXT";
        int numElements = getNumElements(filename);
        EmployeeLinkedList[] hashTable = new EmployeeLinkedList[numElements];

        readEmployeesFromFile(filename, hashTable);
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

    private static void readEmployeesFromFile(String filename, EmployeeLinkedList[] hashTable) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            br.readLine(); // Skip the first line (number of elements)
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int code = Integer.parseInt(data[0]);
                String name = data[1];
                String address = data[2];
                insertEmployee(hashTable, code, name, address);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void insertEmployee(EmployeeLinkedList[] hashTable, int code, String name, String address) {
        int hash = hashFunction(code, hashTable.length);
        if (hashTable[hash] == null) {
            hashTable[hash] = new EmployeeLinkedList();
        }
        Employee employee = new Employee(code, name, address);
        hashTable[hash].add(employee);
    }

    private static int hashFunction(int code, int m) {
        return code % m;
    }

    private static void displayHashTable(EmployeeLinkedList[] hashTable) {
        System.out.println("Hash Table:");
        for (int i = 0; i < hashTable.length; i++) {
            System.out.println("Index: " + i);
            if (hashTable[i] != null) {
                System.out.println(hashTable[i].toString());
            } else {
                System.out.println("Empty");
            }
            System.out.println("-------------------------");
        }
    }

    private static class EmployeeLinkedList {

        private List<Employee> employees;

        public EmployeeLinkedList() {
            employees = new ArrayList<>();
        }

        public void add(Employee employee) {
            employees.add(employee);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (Employee employee : employees) {
                sb.append(employee.toString()).append("\n");
            }
            return sb.toString();
        }
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

        @Override
        public String toString() {
            return "Code: " + code + ", Name: " + name + ", Address: " + address;
        }
    }
}