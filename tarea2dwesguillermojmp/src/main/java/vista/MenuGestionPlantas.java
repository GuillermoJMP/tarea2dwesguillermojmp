package vista;

import modelo.Planta;
import servicioimpl.GestionPlantasServiceImpl;

import java.util.List;
import java.util.Scanner;

public class MenuGestionPlantas {
    private static final GestionPlantasServiceImpl gestionPlantas = new GestionPlantasServiceImpl();
    private static final Scanner scanner = new Scanner(System.in);

    public static void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n--- GESTIÓN DE PLANTAS ---");
            System.out.println("1. Insertar Planta");
            System.out.println("2. Actualizar Planta");
            System.out.println("3. Eliminar Planta");
            System.out.println("4. Obtener Planta por Código");
            System.out.println("5. Mostrar Todas las Plantas");
            System.out.println("6. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            try {
                switch (opcion) {
                    case 1:
                        insertarPlanta();
                        break;
                    case 2:
                        actualizarPlanta();
                        break;
                    case 3:
                        eliminarPlanta();
                        break;
                    case 4:
                        obtenerPlantaPorCodigo();
                        break;
                    case 5:
                        mostrarTodasLasPlantas();
                        break;
                    case 6:
                        System.out.println("Volviendo al Menú Principal...");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente nuevamente.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (opcion != 6);
    }

    private static void insertarPlanta() throws Exception {
        System.out.print("Código: ");
        String codigo = scanner.nextLine();
        System.out.print("Nombre Común: ");
        String nombreComun = scanner.nextLine();
        System.out.print("Nombre Científico: ");
        String nombreCientifico = scanner.nextLine();
        Planta planta = new Planta(codigo, nombreComun, nombreCientifico);
        gestionPlantas.insertarPlanta(planta);
        System.out.println("Planta insertada correctamente.");
    }

    private static void actualizarPlanta() throws Exception {
        System.out.print("Código: ");
        String codigo = scanner.nextLine();
        System.out.print("Nuevo Nombre Común: ");
        String nombreComun = scanner.nextLine();
        System.out.print("Nuevo Nombre Científico: ");
        String nombreCientifico = scanner.nextLine();
        Planta planta = new Planta(codigo, nombreComun, nombreCientifico);
        gestionPlantas.actualizarPlanta(planta);
        System.out.println("Planta actualizada correctamente.");
    }

    private static void eliminarPlanta() throws Exception {
        System.out.print("Código de la planta a eliminar: ");
        String codigo = scanner.nextLine();
        gestionPlantas.eliminarPlanta(codigo);
        System.out.println("Planta eliminada correctamente.");
    }

    private static void obtenerPlantaPorCodigo() throws Exception {
        System.out.print("Código: ");
        String codigo = scanner.nextLine();
        Planta planta = gestionPlantas.obtenerPlantaPorCodigo(codigo);
        if (planta != null) {
            System.out.println("Código: " + planta.getCodigo());
            System.out.println("Nombre Común: " + planta.getNombreComun());
            System.out.println("Nombre Científico: " + planta.getNombreCientifico());
        } else {
            System.out.println("Planta no encontrada.");
        }
    }

    private static void mostrarTodasLasPlantas() throws Exception {
        List<Planta> plantas = gestionPlantas.obtenerTodasLasPlantas();
        if (plantas.isEmpty()) {
            System.out.println("No hay plantas registradas.");
        } else {
            plantas.forEach(p -> System.out.println("Código: " + p.getCodigo() +
                    ", Nombre Común: " + p.getNombreComun() +
                    ", Nombre Científico: " + p.getNombreCientifico()));
        }
    }
}
