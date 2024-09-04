package tree;

public class BinarySearchTreeImp implements BinarySearchTree {
    private Node root;

    public BinarySearchTreeImp() {
        this.root = null;
    }

    public Node getRoot() {
        return this.root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }


    @Override
    public void insert(int value) {
        this.root = insertRecursively(this.root, value);
    }

    private Node insertRecursively(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (value < current.getValue()) {
            current.setLeft(insertRecursively(current.getLeft(), value));
        } else if (value > current.getValue()) {
            current.setRight(insertRecursively(current.getRight(), value));
        } else {
            System.out.println("El valor: " + value + " ya existe en el arbol.");
        }

        return current;
    }

    @Override
    public void delete(int value) {
        this.root = deleteRecursively(this.root, value);
    }

    private Node deleteRecursively(Node current, int value) {
        if (current == null) {
            return null;
        }

        if (value == current.getValue()) {
            if (current.getLeft() == null && current.getRight() == null) {
                return null;
            }

            if (current.getRight() == null) {
                return current.getLeft();
            }

            if (current.getLeft() == null) {
                return current.getRight();
            }

            int smallestValue = findSmallestValue(current.getRight());
            current.setValue(smallestValue);
            current.setRight(deleteRecursively(current.getRight(), smallestValue));
            return current;
        }

        if (value < current.getValue()) {
            current.setLeft(deleteRecursively(current.getLeft(), value));
            return current;
        }

        current.setRight(deleteRecursively(current.getRight(), value));
        return current;
    }

    private int findSmallestValue(Node root) {
        return root.getLeft() == null ? root.getValue() : findSmallestValue(root.getLeft());
    }

    @Override
    public boolean search(int value) {
        return searchRecursively(this.root, value);
    }

    private boolean searchRecursively(Node current, int value) {
        if (current == null) {
            return false;
        }

        if (value == current.getValue()) {
            return true;
        }

        return value < current.getValue()
                ? searchRecursively(current.getLeft(), value)
                : searchRecursively(current.getRight(), value);
    }

    @Override
    public void printInOrder() {
        printInOrderRecursively(this.root);
    }

    private void printInOrderRecursively(Node current) {
        if (current != null) {
            printInOrderRecursively(current.getLeft());
            System.out.println("Valor: " + current.getValue());
            printInOrderRecursively(current.getRight());
        }
    }
}
