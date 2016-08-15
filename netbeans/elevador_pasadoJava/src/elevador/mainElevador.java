
package elevador;
import entidades.edificio;
import java.util.*;

import java.io.*;

public class mainElevador {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) throws IOException {
        Scanner capt = new Scanner(System.in);
        
        //int duracion = input; // longitud de la simulaci�n en segundos

	   System.out.print("Introduzca tiempo de ejecución: ");
	   //cin >> duracion;
           int duracion = capt.nextInt();
	  // cin.ignore(); // ignora el car�cter devuelto

	   edificio edificio=null;//  // crea el edificio
edificio = new edificio();
	   System.out.print("\n");
	   System.out.print("*** COMIENZA LA SIMULACION DEL ELEVADOR ***");
	   System.out.print("\n");
	   System.out.print("\n");

           
	   edificio.ejecutaSimulador(duracion); // comienza la simulaci�n

	   System.out.print("*** TERMINA LA SIMULACION DEL ELEVADOR ***");
	   System.out.print("\n");

	  
    }
    
}
