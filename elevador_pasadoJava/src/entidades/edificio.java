package entidades;

import java.io.IOException;
import java.util.*;

public class Edificio {

    /////////////////////////////////////////////////
    private Piso piso1;  // objeto piso1
    private Piso piso2; // objeto piso2
    private Elevador elevador;// objeto elevador
    private Reloj reloj;// objeto  reloj
    private Bitacora bitacora;
    // constructor

    public Edificio() {
        System.out.println("########paso 1");
        piso1 = new Piso(Piso.PISO1, elevador);
        System.out.println("########paso 2");
        piso2 = new Piso(Piso.PISO2, elevador);
        System.out.println("########paso 3");
        elevador = new Elevador(piso1, piso2);
        System.out.println("########paso 4");
        bitacora = new Bitacora(piso1, piso2);
        System.out.println("########paso 5");

        System.out.print("edificio construido\n");

    } // fin del constructor Edificio

    // funci�n para controlar la simulaci�n
    public void ejecutaSimulador(int tiempoTotal) throws IOException {

        int tiempoActual = 0;
        reloj = new Reloj();
        while (tiempoActual < tiempoTotal) {

            if(true)
            {
                System.err.println("punto");
            }
            reloj.marcaSeg(); // incrementa el tiempo
            tiempoActual = reloj.obtieneTiempo(); // obtiene tiempo nuevo
            System.out.print("TIEMPO: " + tiempoActual + "\n");

            // procesa la llegada de personas para tiempoActual
            bitacora.tiempoProceso(tiempoActual);

            // procesa los eventos del elevador para tiempoActual
            elevador.tiempoProceso(tiempoActual);

            // espera a que se digite una tecla, de manera que el usuario vea la salida
            System.in.read();
        } // fin de while

    } // fin de la funci�n ejecutaSimulador


} // fin de la clase Edificio
