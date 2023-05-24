package actividad3;

public class Test {
    public static void main(String[] args) {
        BSTree<Integer> bst = new BSTree<>();
        try {
            bst.insert(5);
            bst.insert(2);
            bst.insert(8);
            bst.insert(1);
            bst.insert(3);
            bst.insert(7);
            bst.insert(9);
        } catch (ItemDuplicated e) {
            System.out.println(e.getMessage());
        }
        System.out.println(bst);
        
        try {
            System.out.println("Buscar elemento 5: " + bst.search(5));
            System.out.println("Buscar elemento 10: " + bst.search(10));
        } catch (ItemNoFound e) {
            System.out.println(e.getMessage());
        }
        try {
            bst.remove(2);
            bst.remove(9);
        } catch (ItemNoFound e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("arbol despues del eliminar");
        System.out.println(bst);
        
        try {
            bst.insert(5);//Insertando elemento duplicado
        } catch (ItemDuplicated e) {
            System.out.println(e.getMessage());
        }
        
        try {
            bst.search(10);//elemento no existente
        } catch (ItemNoFound e) {
            System.out.println(e.getMessage());
        }
        System.out.println("-------------------------------------");
        //llamamos al metodo que cuenta nodos no-hojas

        int count = bst.countNonLeafNodes();
        System.out.println("Nro de nodos no-hojas: " + count);

        //eje2
        try {
            int height = bst.getNodeHeight(8);
            System.out.println("La altura del nodo con elemento 8 es: " + height);
        } catch (ItemNoFound e) {
            System.out.println(e.getMessage());
        }
        //eje3
        System.out.println("recorrido PreOrden");
        bst.preOrderIterative();
        
        //eje4
        int area = bst.getArea();
        System.out.println("El área del árbol binario es: " + area);

        BSTree<Integer> bst2 = new BSTree<>();
        try {
            bst2.insert(5);
            bst2.insert(48);
            bst2.insert(96);
            bst2.insert(4);
            bst2.insert(12);
        } catch (ItemDuplicated e) {
            System.out.println(e.getMessage());
        }

        //eje5
        boolean sameArea = haveSameArea(bst, bst2);
        System.out.println("Los árboles tienen la misma área: " + sameArea);
        
        //eje6
        BSTree.Node minNode = bst.findMinNode();

        // Verifica si se encontró un nodo y muestra su valor
        if (minNode != null) {
            System.out.println("el valor minimo es: " + minNode.data);
        } else {
            System.out.println("arbol vacío, no se encontró ningún valor mínimo.");
        }
        //eje7
        BSTree.Node maxNode = bst.findMaxNode();
        System.out.println("el valor más alto es: " + maxNode.data);
        //eje8
        System.out.println("impresion de metodo parenthesize");
        bst.parenthesize();
        //bst2.parenthesize();


        
    }
    //eje5
    public static <E extends Comparable<E>> boolean haveSameArea(BSTree<E> bst1, BSTree<E> bst2) {
        return bst1.getArea() == bst2.getArea();
    }
}

