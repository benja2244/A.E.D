package actividad3;
import java.util.Stack;


public class BSTree<E extends Comparable<E>> {
    class Node {
        protected E data;
        protected Node left, right;

        public Node(E data) {
            this(data, null, null);
        }

        public Node(E data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    private Node root;

    public void BStree() {
        this.root = null;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public void insert(E x) throws ItemDuplicated {
        this.root = insert(x, this.root);
    }

    private Node insert(E x, Node actual) throws ItemDuplicated {
        if (actual == null) {
            actual = new Node(x);
        } else {
            int compareResult = x.compareTo(actual.data);
            if (compareResult < 0) {
                actual.left = insert(x, actual.left);
            } else if (compareResult > 0) {
                actual.right = insert(x, actual.right);
            } else {
                throw new ItemDuplicated("ya existe el elemento en el árbol");
            }
        }
        return actual;
    }

    public E search(E x) throws ItemNoFound {
        return search(x, this.root);
    }

    private E search(E x, Node actual) throws ItemNoFound {
        if (actual == null) {
            throw new ItemNoFound("El elemento no esta en el árbol");
        } else {
            int compareResult = x.compareTo(actual.data);
            if (compareResult < 0) {
                return search(x, actual.left);
            } else if (compareResult > 0) {
                return search(x, actual.right);
            } else {
                return actual.data;
            }
        }
    }

    public void remove(E x) throws ItemNoFound {
        this.root = remove(x, this.root);
    }

    private Node remove(E x, Node actual) throws ItemNoFound {
        if (actual == null) {
            throw new ItemNoFound("El elemento no esta en el árbol");
        } else {
            int compareResult = x.compareTo(actual.data);
            if (compareResult < 0) {
                actual.left = remove(x, actual.left);
            } else if (compareResult > 0) {
                actual.right = remove(x, actual.right);
            } else if (actual.left != null && actual.right != null) {
                actual.data = findMin(actual.right).data;
                actual.right = remove(actual.data, actual.right);
            } else {
                actual = (actual.left != null) ? actual.left : actual.right;
            }
        }
        return actual;
    }

    //implementamos el metodo que va a contar nodos no-hojas 

    public int countNonLeafNodes() {
        return countNonLeafNodes(root);
    }
    
    private int countNonLeafNodes(Node actual) {
        if (actual == null || (actual.left == null && actual.right == null)) {
            return 0;
        } else {
            return 1 + countNonLeafNodes(actual.left) + countNonLeafNodes(actual.right);
        }
    }
    //eje 2

    public int getNodeHeight(E x) throws ItemNoFound {
        return getNodeHeight(x, this.root);
    }
    
    private int getNodeHeight(E x, Node actual) throws ItemNoFound {
        if (actual == null) {
            throw new ItemNoFound("El elemento no está en el árbol");
        } else {
            int compareResult = x.compareTo(actual.data);
            if (compareResult < 0) {
                return getNodeHeight(x, actual.left) + 1;
            } else if (compareResult > 0) {
                return getNodeHeight(x, actual.right) + 1;
            } else {
                return 0; // Nodo encontrado, su altura es 0
            }
        }
    }

    //eje3
    public void preOrderIterative() {
        if (root == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node current = stack.pop();
            System.out.println(current.data);

            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }
    }
    
    //eje 4
    public int getArea() {
        int leafCount = countLeaves(root);
        int height = getHeight(root);
        return leafCount * height;
    }
    
    private int countLeaves(Node actual) {
        if (actual == null) {
            return 0;
        } else if (actual.left == null && actual.right == null) {
            return 1;
        } else {
            return countLeaves(actual.left) + countLeaves(actual.right);
        }
    }
    
    //eje6
    public Node findMinNode() {
        if (root == null) {
            return null;
        }
        Node current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }
    //eje 7
    public Node findMaxNode() {
        return findMaxNode(root);
    }
    
    private Node findMaxNode(Node actual) {
        if (actual == null) {
            return null;
        } else if (actual.right == null) {
            return actual;
        } else {
            return findMaxNode(actual.right);
        }
    }
    
    //eje8
    public void parenthesize() {
        parenthesizeRecursive(root, 0);
    }

    private void parenthesizeRecursive(Node node, int level) {
        if (node == null) {
            return;
        }
        for (int i = 0; i < level; i++) {
            System.out.print("    ");
        }

        System.out.println("(" + node.data + ")");
        parenthesizeRecursive(node.left, level + 1);
        parenthesizeRecursive(node.right, level + 1);
    }
    
    //
    private int getHeight(Node actual) {
        if (actual == null) {
            return 0;
        } else {
            int leftHeight = getHeight(actual.left);
            int rightHeight = getHeight(actual.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
      
    private Node findMin(Node actual) {
        if (actual == null) {
            return null;
        } else if (actual.left == null) {
            return actual;
        } else {
            return findMin(actual.left);
        }
    }

    public String toString() {
        return toString(this.root);
    }

    private String toString(Node actual) {
        if (actual == null) {
            return "";
        } else {
            return actual.data + " " + toString(actual.left) + toString(actual.right);
        }
    }

    public void inOrder() {
        inOrder(this.root);
    }

    private void inOrder(Node actual) {
        if (actual != null) {
            inOrder(actual.left);
            System.out.println(actual.data);
            inOrder(actual.right);
        }
    }
}


