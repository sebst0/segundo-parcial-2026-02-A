import java.util.Scanner;

public class CentroReciclaje {
    public static void main(String[] args) throws Exception {
        Scanner leer = new Scanner(System.in);

        int cantidad = leerCantidad(leer);

        int[] pesos = new int[cantidad];

        cargarPesos(leer, pesos);

        int total = calcularTotal(pesos);
        int minimo = 5; 
        int maximo = 80;
        int limite = 80;
        int entreRango = contarEnRango(pesos, minimo, maximo);
        int superiores = contarMayores(pesos, limite);
        double promedio = calcularPromedio(pesos);
        int mayor = buscarMayor(pesos);
        int mayoresPromedio = contarMayores(pesos, promedio);
        int posicionMayor = buscarPrimeraPosicionMayor(pesos);

        mostrarResultados(pesos, entreRango, superiores, total, promedio, mayor, mayoresPromedio, posicionMayor);
        leer.close();

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

    public static boolean pesoValido(int peso) {

        return peso >= 5 && peso <= 200;
    }

    public static void cargarPesos( Scanner leer, int[] pesos ){
        int longPesos = pesos.length;

        for (int i = 0; i < longPesos; i++) {
            do {
                System.out.println("ingrese el peso de la carga " + (i+1));
                pesos[i] = leer.nextInt();

                if (!pesoValido(pesos[i])) {
                    System.out.println("error, peso invalido. Debe de estar entre 5 y 200kg");
                }
            } while (!pesoValido(pesos[i]));
        }
    
    }

    public static int calcularTotal(int[] pesos){
        int longPesos = pesos.length;
        int total = 0 ;
        for (int i = 0; i < longPesos; i++) {
            total += pesos[i];
        }
        return total;
    }

    public static double calcularPromedio(int[] pesos) {

        int total = calcularTotal(pesos);
        int longPesos = pesos.length;

        return (double) total / longPesos;
    }
    
    public static int contarEnRango(int[] pesos, int minimo, int maximo) {

        int contador = 0;
        int longPesos = pesos.length;

        for (int i = 0; i < longPesos; i++) {

            if (pesos[i] >= minimo && pesos[i] <= maximo) {
                contador++;
            }
        }

        return contador;
    }

    public static int contarMayores(int[] pesos, double limite) {

        int contador = 0;
        int longPesos = pesos.length;

        for (int i = 0; i < longPesos; i++) {

            if (pesos[i] > limite) {
                contador++;
            }
        }

        return contador;
    }

    public static int buscarMayor(int[] pesos) {

        int mayor = pesos[0];
        int longPesos = pesos.length;

        for (int i = 1; i < longPesos; i++) {

            if (pesos[i] > mayor) {
                mayor = pesos[i];
            }
        }

        return mayor;
    }
    
    public static int buscarPrimeraPosicionMayor(int[] pesos) {

        int mayor = buscarMayor(pesos);
        int posicion = 0;
        int longPesos = pesos.length;

        for (int i = 0; i < longPesos; i++) {

            if (pesos[i] == mayor) {
                posicion = i + 1;
                break;
            }
        }

        return posicion;
    }

    public static void mostrarResultados (
            int[] pesos,
            int entreRango,
            int superiores,
            int total,
            double promedio,
            int mayor,
            int mayoresPromedio,
            int posicionMayor 
    ){
        int longPesos = pesos.length;

        for (int i = 0; i < longPesos; i++) {
            System.out.println("el peso de la carga " + (i+1) + " es " + pesos[i]);
        }

        System.out.println("el total de todos los pesos es de: " + total + " kg");
        System.out.println("Primera carga con el mayor peso: " + posicionMayor);
        System.out.println("cargas superiores a 80 kg: " + superiores);
        System.out.println("promedio de peso: "+ promedio + " kg");
        System.out.println("mayor peso registrado " + mayor + " kg");
        System.out.println("cantidad de cargas entre 5 y 80 kg: " + entreRango);
        System.out.println("cantidad de cargas mayores al promedio: " + mayoresPromedio);

    }

}
