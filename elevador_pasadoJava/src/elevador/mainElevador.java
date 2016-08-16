package elevador;

import entidades.Edificio;
import java.util.*;

import java.io.*;

public class mainElevador {

    public static void main(String[] args) throws IOException {

        Edificio edificio = null;

        int duracion = 0;// longitud de la simulaci�n en segundos
        System.out.print("Introduzca tiempo de ejecución: ");

        Scanner capt = new Scanner(System.in);
        try {
            duracion = capt.nextInt();
            edificio = new Edificio();
        } catch (Exception e) {
            System.out.println("Error, solo ingresar números enteros");
            System.exit(0);//sale del sistema al detectar el error
        }

        System.out.print("\n*** COMIENZA LA SIMULACION DEL ELEVADOR ***\n\n");

        edificio.ejecutaSimulador(duracion); // comienza la simulaci�n

        System.out.print("*** TERMINA LA SIMULACION DEL ELEVADOR ***\n");

    }

}
