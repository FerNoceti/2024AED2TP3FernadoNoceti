package menu;

import java.util.Scanner;

public class Menu {
    private final Scanner scanner;

    public Menu(Scanner scanner) {
        this.scanner = scanner;
    }

    public void displayMenu() {
        String menuOptions = "1. Insertar un dato\n" +
                "2. Borrar un dato\n" +
                "3. Mostrar todos los datos ordenados con su FE\n";

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
                System.out.println("Insertar un dato");
                break;
            case 2:
                System.out.println("Borrar un dato");
                break;
            case 3:
                System.out.println("Mostrar todos los datos ordenados con su FE");
                break;
        }
    }
}
