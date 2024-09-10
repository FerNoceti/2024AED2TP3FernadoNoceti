package menu;

import tree.AVLTreeImp;
import util.InputValidator;

import java.util.Scanner;

public class Menu {
    private final Scanner scanner;
    private final AVLTreeImp avlTree = new AVLTreeImp();

    public Menu(Scanner scanner) {
        this.scanner = scanner;
    }

    public void displayMenu() {
        String menuOptions = "1. Insertar un dato\n" +
                "2. Borrar un dato\n" +
                "3. Mostrar todos los datos ordenados con su FE\n" +
                "4. Salir";

        int option = 0;

        while (option != 4) {
            System.out.println(menuOptions);
            option = InputValidator.getValidInt(scanner, "Ingrese una opción: ");
            handleMenuOption(option);
        }
    }

    private void handleMenuOption(int option) {
        switch (option) {
            case 1:
                insertData();
                break;
            case 2:
                deleteData();
                break;
            case 3:
                showData();
                break;
            case 4:
                System.out.println("Saliendo...");
                break;
            default:
                System.out.println("Opción inválida.");
        }
    }

    private void insertData() {
        int data = InputValidator.getValidInt(scanner, "Ingrese un dato a insertar: ");
        avlTree.insert(data);
    }

    private void deleteData() {
        int data = InputValidator.getValidInt(scanner, "Ingrese un dato a eliminar: ");
        avlTree.delete(data);
    }

    private void showData() {
        System.out.println(avlTree.toString());
    }
}
