package tree;

public interface BinarySearchTree {
    void insert(int value); // Inserta un valor en el árbol

    void delete(int value); // Elimina un valor del árbol

    boolean search(int value); // Busca un valor en el árbol y devuelve true si existe, de lo contrario false

    void printInOrder(); // Imprime los valores del árbol en orden ascendente

    int getHeight(); // Devuelve la altura del árbol
}
