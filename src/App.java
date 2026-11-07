import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Scanner leer = new Scanner(System.in);
        int cantidad = leerCantidad(leer)
        
    }

    public static int leerCantidad(Scanner leer) {

        int cantidad = 0;

        do {
            System.out.println("Ingrese la cantidad de cargas (debe estar entre 3 y 20 la cantidad): ");
            cantidad = leer.nextInt();

            if (cantidad < 3 || cantidad > 20) {
                System.out.println("error, cantidad invalida. Debe estar entre 3 y 20");
            }

        } while (cantidad < 3 || cantidad > 20);

        return cantidad;
    }

    public static boolean esPesoValido(int peso) {

        return peso >= 5 && peso <= 200;
    }



}
