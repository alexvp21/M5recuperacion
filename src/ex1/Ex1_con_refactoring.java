import java.util.Scanner;

public class Ex1 {
	private static Scanner entrada = new Scanner(System.in);
	
	public static void main(String[] args) {
		int decision = numeroUsuario();

		if (decision == 1) {

			pedirDatos();

		} else {

			System.out.println("Adios");

			System.exit(0);
		}

		entrada.close();

	}

	static void pedirDatos() {

		Scanner entrada = new Scanner(System.in);

		System.out.println("Introduce tu nombre, por favor");

		String nombre_usuario = entrada.nextLine();

		System.out.println("Introduce edad, por favor");

		int edad = 0;
				
		try {
			edad = entrada.nextInt();
			System.out.println("Hola " + nombre_usuario + ". El año que viene tendrás " + (edad + 1) + " años");
		}
		catch (Exception e) {
			System.err.println("Introduciste un dato erroneo");
		}

		entrada.close();

		System.out.println("Hemos terminado");

	}

	static int numeroUsuario() {
		System.out.println("¿Qué deseas hacer?");
		System.out.println("1. Introducir datos");
		System.out.println("2. Salir del programa");
		int decision = entrada.nextInt();
		return decision;
	}
}
