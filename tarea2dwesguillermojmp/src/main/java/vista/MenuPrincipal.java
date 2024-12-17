package vista;

import vista.MenuGestionPlantas;
import vista.MenuGestionEjemplares;
import vista.MenuGestionMensajes;
import vista.MenuGestionPersonas;

import java.util.Scanner;

public class MenuPrincipal {
    private static final Scanner scanner = new Scanner(System.in);

    public static void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Gestionar Plantas");
            System.out.println("2. Gestionar Ejemplares");
            System.out.println("3. Gestionar Mensajes");
            System.out.println("4. Gestionar Personas");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    MenuGestionPlantas.mostrarMenu();
                    break;
                case 2:
                    MenuGestionEjemplares.mostrarMenu();
                    break;
                case 3:
                    MenuGestionMensajes.mostrarMenu();
                    break;
                case 4:
                    MenuGestionPersonas.mostrarMenu();
                    break;
                case 5:
                    System.out.println("¡Gracias por usar la aplicación!");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        } while (opcion != 5);
    }
}
