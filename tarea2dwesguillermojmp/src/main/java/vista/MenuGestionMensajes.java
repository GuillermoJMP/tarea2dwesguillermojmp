package vista;

import modelo.Mensaje;
import servicioimpl.GestionMensajesServiceImpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class MenuGestionMensajes {
    private static final GestionMensajesServiceImpl gestionMensajes = new GestionMensajesServiceImpl();
    private static final Scanner scanner = new Scanner(System.in);

    public static void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n--- GESTIÓN DE MENSAJES ---");
            System.out.println("1. Insertar Mensaje");
            System.out.println("2. Mostrar Mensajes por Ejemplar");
            System.out.println("3. Mostrar Mensajes por Persona");
            System.out.println("4. Mostrar Mensajes por Rango de Fechas");
            System.out.println("5. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            try {
                switch (opcion) {
                    case 1:
                        insertarMensaje();
                        break;
                    case 2:
                        mostrarMensajesPorEjemplar();
                        break;
                    case 3:
                        mostrarMensajesPorPersona();
                        break;
                    case 4:
                        mostrarMensajesPorFechas();
                        break;
                    case 5:
                        System.out.println("Volviendo al Menú Principal...");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente nuevamente.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (opcion != 5);
    }

    private static void insertarMensaje() throws Exception {
        System.out.print("ID del Ejemplar: ");
        Long idEjemplar = scanner.nextLong();
        scanner.nextLine();
        System.out.print("ID de la Persona: ");
        Long idPersona = scanner.nextLong();
        scanner.nextLine();
        System.out.print("Mensaje: ");
        String textoMensaje = scanner.nextLine();

        Mensaje mensaje = new Mensaje(null, LocalDateTime.now(), textoMensaje, idEjemplar, idPersona);
        gestionMensajes.insertarMensaje(mensaje);
        System.out.println("Mensaje insertado correctamente.");
    }

    private static void mostrarMensajesPorEjemplar() throws Exception {
        System.out.print("ID del Ejemplar: ");
        Long idEjemplar = scanner.nextLong();
        List<Mensaje> mensajes = gestionMensajes.obtenerMensajesPorEjemplar(idEjemplar);
        mensajes.forEach(m -> System.out.println("ID: " + m.getId() + ", Mensaje: " + m.getMensaje() + ", Fecha: " + m.getFechaHora()));
    }

    private static void mostrarMensajesPorPersona() throws Exception {
        System.out.print("ID de la Persona: ");
        Long idPersona = scanner.nextLong();
        List<Mensaje> mensajes = gestionMensajes.obtenerMensajesPorPersona(idPersona);
        mensajes.forEach(m -> System.out.println("ID: " + m.getId() + ", Mensaje: " + m.getMensaje() + ", Fecha: " + m.getFechaHora()));
    }

    private static void mostrarMensajesPorFechas() throws Exception {
        System.out.print("Fecha de inicio (YYYY-MM-DD): ");
        String fechaInicio = scanner.nextLine();
        System.out.print("Fecha de fin (YYYY-MM-DD): ");
        String fechaFin = scanner.nextLine();
        List<Mensaje> mensajes = gestionMensajes.obtenerMensajesPorFechas(fechaInicio, fechaFin);
        mensajes.forEach(m -> System.out.println("ID: " + m.getId() + ", Mensaje: " + m.getMensaje() + ", Fecha: " + m.getFechaHora()));
    }
}
