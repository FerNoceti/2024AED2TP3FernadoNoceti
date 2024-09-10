package tree;

public class AVLTreeImp extends BinarySearchTreeImp {

    @Override
    public void insert(int value) {
        setRoot(insertRecursively(getRoot(), value));
    }

    @Override
    protected Node insertRecursively(Node node, int value) {
        node = super.insertRecursively(node, value);
        node.updateHeight();
        return balance(node);
    }


    @Override
    public void delete(int value) {
        setRoot(deleteRecursively(getRoot(), value));
    }

    @Override
    protected Node deleteRecursively(Node node, int value) {
        node = super.deleteRecursively(node, value);
        if (node != null) {
            node.updateHeight();
            return balance(node);
        }
        return null;
    }

    private Node balance(Node node) {
        if (node == null) {
            return null;
        }

        node.updateHeight();
        int balance = node.getBalance();

        // Rotación a la derecha
        if (balance > 1 && node.getLeft().getBalance() >= 0) {
            return rotateRight(node);
        }
        // Rotación a la izquierda
        if (balance < -1 && node.getRight().getBalance() <= 0) {
            return rotateLeft(node);
        }
        // Rotación doble a la derecha
        if (balance > 1 && node.getLeft().getBalance() < 0) {
            return rotateLeftRight(node);
        }
        // Rotación doble a la izquierda
        if (balance < -1 && node.getRight().getBalance() > 0) {
            return rotateRightLeft(node);
        }

        return node;
    }

    private Node rotateRight(Node y) {
        Node x = y.getLeft();
        Node T2 = x.getRight();

        x.setRight(y);
        y.setLeft(T2);

        y.updateHeight();
        x.updateHeight();

        return x;
    }

    private Node rotateLeft(Node x) {
        Node y = x.getRight();
        Node T2 = y.getLeft();

        y.setLeft(x);
        x.setRight(T2);

        x.updateHeight();
        y.updateHeight();

        return y;
    }

    private Node rotateLeftRight(Node y) {
        y.setLeft(rotateLeft(y.getLeft()));
        return rotateRight(y);
    }

    private Node rotateRightLeft(Node x) {
        x.setRight(rotateRight(x.getRight()));
        return rotateLeft(x);
    }

    @Override
    public String toString() {
        return toStringRecursively(getRoot());
    }

    private String toStringRecursively(Node node) {
        if (node == null) {
            return "";
        }

        return toStringRecursively(node.getLeft()) +
                "Valor: " + node.getValue() + " FE: " + node.getBalance() + "\n" +
                toStringRecursively(node.getRight());
    }

}
