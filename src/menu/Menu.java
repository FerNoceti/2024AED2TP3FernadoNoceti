package menu;

import tree.AVLTreeImp;

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
            System.out.print("Ingrese una opcion: ");
            option = scanner.nextInt();

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
                System.out.println("Opcion invalida.");
        }
    }

    private void insertData() {
        System.out.print("Ingrese un dato a insertar: ");
        int data = scanner.nextInt();
        avlTree.insert(data);
    }

    private void deleteData() {
        System.out.print("Ingrese un dato a eliminar: ");
        int data = scanner.nextInt();
        avlTree.delete(data);
    }

    private void showData() {
        System.out.println(avlTree.toString());
    }
}
