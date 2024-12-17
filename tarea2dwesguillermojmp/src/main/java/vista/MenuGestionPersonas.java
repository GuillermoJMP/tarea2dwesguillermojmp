package vista;

import modelo.Persona;
import modelo.Credenciales;
import servicioimpl.GestionPersonasServiceImpl;

import java.util.List;
import java.util.Scanner;

public class MenuGestionPersonas {
    private static final GestionPersonasServiceImpl gestionPersonas = new GestionPersonasServiceImpl();
    private static final Scanner scanner = new Scanner(System.in);

    public static void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n--- GESTIÓN DE PERSONAS ---");
            System.out.println("1. Registrar Persona");
            System.out.println("2. Actualizar Persona");
            System.out.println("3. Eliminar Persona");
            System.out.println("4. Mostrar Persona por ID");
            System.out.println("5. Mostrar Todas las Personas");
            System.out.println("6. Validar Credenciales");
            System.out.println("7. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (opcion) {
                    case 1:
                        registrarPersona();
                        break;
                    case 2:
                        actualizarPersona();
                        break;
                    case 3:
                        eliminarPersona();
                        break;
                    case 4:
                        mostrarPersonaPorId();
                        break;
                    case 5:
                        mostrarTodasLasPersonas();
                        break;
                    case 6:
                        validarCredenciales();
                        break;
                    case 7:
                        System.out.println("Volviendo al Menú Principal...");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente nuevamente.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (opcion != 7);
    }

    private static void registrarPersona() throws Exception {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Usuario: ");
        String usuario = scanner.nextLine();
        System.out.print("Contraseña: ");
        String password = scanner.nextLine();

        Persona persona = new Persona(null, nombre, email);
        Credenciales credenciales = new Credenciales(null, usuario, password);
        gestionPersonas.registrarPersona(persona, credenciales);
        System.out.println("Persona registrada correctamente.");
    }

    private static void actualizarPersona() throws Exception {
        System.out.print("ID de la Persona: ");
        Long id = scanner.nextLong();
        scanner.nextLine();
        System.out.print("Nuevo Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Nuevo Email: ");
        String email = scanner.nextLine();

        Persona persona = new Persona(id, nombre, email);
        gestionPersonas.actualizarPersona(persona);
        System.out.println("Persona actualizada correctamente.");
    }

    private static void eliminarPersona() throws Exception {
        System.out.print("ID de la Persona a eliminar: ");
        Long id = scanner.nextLong();
        gestionPersonas.eliminarPersona(id);
        System.out.println("Persona eliminada correctamente.");
    }

    private static void mostrarPersonaPorId() throws Exception {
        System.out.print("ID de la Persona: ");
        Long id = scanner.nextLong();
        Persona persona = gestionPersonas.obtenerPersonaPorId(id);
        System.out.println(persona != null ? "ID: " + persona.getId() + ", Nombre: " + persona.getNombre() + ", Email: " + persona.getEmail()
                : "Persona no encontrada.");
    }

    private static void mostrarTodasLasPersonas() throws Exception {
        List<Persona> personas = gestionPersonas.obtenerTodasLasPersonas();
        personas.forEach(p -> System.out.println("ID: " + p.getId() + ", Nombre: " + p.getNombre() + ", Email: " + p.getEmail()));
    }

    private static void validarCredenciales() throws Exception {
        System.out.print("Usuario: ");
        String usuario = scanner.nextLine();
        System.out.print("Contraseña: ");
        String password = scanner.nextLine();
        boolean valido = gestionPersonas.validarCredenciales(usuario, password);
        System.out.println(valido ? "Credenciales válidas." : "Credenciales inválidas.");
    }
}
