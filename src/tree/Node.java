package tree;

public class Node {
    private int value;
    private Node left;
    private Node right;
    private int height;

    public Node() {
        this(0);
    }

    public Node(int value) {
        this.value = value;
        this.height = 1;
    }

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
        updateHeight();
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
        updateHeight();
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
        updateHeight();
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
        updateHeight();
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getBalance() {
        int leftHeight = (left == null) ? -1 : left.height;
        int rightHeight = (right == null) ? -1 : right.height;
        return leftHeight - rightHeight;
    }

    public void updateHeight() {
        int leftHeight = (left == null) ? -1 : left.height;
        int rightHeight = (right == null) ? -1 : right.height;
        height = 1 + Math.max(leftHeight, rightHeight);
    }
}
