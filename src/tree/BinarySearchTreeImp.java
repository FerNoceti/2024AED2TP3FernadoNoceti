package tree;

public class BinarySearchTreeImp implements BinarySearchTree {
    private Node root;

    @Override
    public void insert(int value) {
        root = insertRecursively(root, value);
    }

    protected Node insertRecursively(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }

        if (value < node.getValue()) {
            node.setLeft(insertRecursively(node.getLeft(), value));
        } else if (value > node.getValue()) {
            node.setRight(insertRecursively(node.getRight(), value));
        } else {
            System.out.println("El valor: " + value + " ya existe en el arbol.");
        }

        return node;
    }

    @Override
    public void delete(int value) {
        root = deleteRecursively(root, value);
    }

    protected Node deleteRecursively(Node node, int value) {
        if (node == null) {
            return null;
        }

        if (value < node.getValue()) {
            node.setLeft(deleteRecursively(node.getLeft(), value));
        } else if (value > node.getValue()) {
            node.setRight(deleteRecursively(node.getRight(), value));
        } else {
            if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            }

            node.setValue(findSmallestValue(node.getRight()));
            node.setRight(deleteRecursively(node.getRight(), node.getValue()));
        }

        return node;
    }

    private int findSmallestValue(Node node) {
        return node.getLeft() == null ? node.getValue() : findSmallestValue(node.getLeft());
    }

    @Override
    public boolean search(int value) {
        return searchRecursively(root, value);
    }

    private boolean searchRecursively(Node node, int value) {
        if (node == null) {
            return false;
        }

        if (value == node.getValue()) {
            return true;
        }

        return value < node.getValue()
                ? searchRecursively(node.getLeft(), value)
                : searchRecursively(node.getRight(), value);
    }

    @Override
    public void printInOrder() {
        printInOrderRecursively(root);
    }

    private void printInOrderRecursively(Node node) {
        if (node != null) {
            printInOrderRecursively(node.getLeft());
            System.out.println("Valor: " + node.getValue());
            printInOrderRecursively(node.getRight());
        }
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    @Override
    public int getHeight() {
        return getHeightRecursively(root);
    }

    private int getHeightRecursively(Node node) {
        if (node == null) {
            return -1;
        }

        return 1 + Math.max(getHeightRecursively(node.getLeft()), getHeightRecursively(node.getRight()));
    }
}