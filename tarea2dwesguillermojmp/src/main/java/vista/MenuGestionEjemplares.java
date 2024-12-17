package vista;

import modelo.Ejemplar;
import servicioimpl.GestionEjemplaresServiceImpl;

import java.util.List;
import java.util.Scanner;

public class MenuGestionEjemplares {
    private static final GestionEjemplaresServiceImpl gestionEjemplares = new GestionEjemplaresServiceImpl();
    private static final Scanner scanner = new Scanner(System.in);

    public static void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n--- GESTIÓN DE EJEMPLARES ---");
            System.out.println("1. Insertar Ejemplar");
            System.out.println("2. Actualizar Ejemplar");
            System.out.println("3. Eliminar Ejemplar");
            System.out.println("4. Obtener Ejemplar por ID");
            System.out.println("5. Mostrar Ejemplares por Código de Planta");
            System.out.println("6. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (opcion) {
                    case 1:
                        insertarEjemplar();
                        break;
                    case 2:
                        actualizarEjemplar();
                        break;
                    case 3:
                        eliminarEjemplar();
                        break;
                    case 4:
                        obtenerEjemplarPorId();
                        break;
                    case 5:
                        mostrarEjemplaresPorPlanta();
                        break;
                    case 6:
                        System.out.println("Volviendo al Menú Principal...");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (opcion != 6);
    }

    private static void insertarEjemplar() throws Exception {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Código de Planta: ");
        String codigoPlanta = scanner.nextLine();
        Ejemplar ejemplar = new Ejemplar(null, nombre, codigoPlanta);
        gestionEjemplares.insertarEjemplar(ejemplar);
        System.out.println("Ejemplar insertado correctamente.");
    }

    private static void actualizarEjemplar() throws Exception {
        System.out.print("ID del Ejemplar: ");
        Long id = scanner.nextLong();
        scanner.nextLine();
        System.out.print("Nuevo Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Código de Planta: ");
        String codigoPlanta = scanner.nextLine();
        Ejemplar ejemplar = new Ejemplar(id, nombre, codigoPlanta);
        gestionEjemplares.actualizarEjemplar(ejemplar);
        System.out.println("Ejemplar actualizado correctamente.");
    }

    private static void eliminarEjemplar() throws Exception {
        System.out.print("ID a eliminar: ");
        Long id = scanner.nextLong();
        gestionEjemplares.eliminarEjemplar(id);
        System.out.println("Ejemplar eliminado correctamente.");
    }

    private static void obtenerEjemplarPorId() throws Exception {
        System.out.print("ID del Ejemplar: ");
        Long id = scanner.nextLong();
        Ejemplar ejemplar = gestionEjemplares.obtenerEjemplarPorId(id);
        if (ejemplar != null) {
            System.out.println("ID: " + ejemplar.getId() + ", Nombre: " + ejemplar.getNombre());
        } else {
            System.out.println("Ejemplar no encontrado.");
        }
    }

    private static void mostrarEjemplaresPorPlanta() throws Exception {
        System.out.print("Código de Planta: ");
        String codigoPlanta = scanner.nextLine();
        List<Ejemplar> ejemplares = gestionEjemplares.obtenerEjemplaresPorPlanta(codigoPlanta);
        ejemplares.forEach(e -> System.out.println("ID: " + e.getId() + ", Nombre: " + e.getNombre()));
    }
}
