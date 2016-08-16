package entidades;

import java.io.IOException;
import java.util.*;

public class edificio {

    /////////////////////////////////////////////////
    piso PISO1 = new piso(); // objeto piso1
    piso PISO2 = new piso(); // objeto piso2
/////////////////////////////////////////////////
    elevador elevador = new elevador(); // objeto elevador
    reloj reloj = new reloj(); // objeto  reloj
    bitacora bitacora = new bitacora();
    // constructor

    public edificio() {
        piso piso1 = new piso(piso.PISO1, elevador);
        piso piso2 = new piso(piso.PISO2, elevador);
        elevador elevador = new elevador(piso1, piso2);
        bitacora bitacora = new bitacora(piso1, piso2);
        System.out.print("edificio construido");
        System.out.print("\n");

    } // fin del constructor Edificio

    // funci�n para controlar la simulaci�n
    public void ejecutaSimulador(int tiempoTotal) throws IOException {
        int tiempoActual = 0;

        while (tiempoActual < tiempoTotal) {
            reloj.marcaSeg(); // incrementa el tiempo
            tiempoActual = reloj.obtieneTiempo(); // obtiene tiempo nuevo
            System.out.print("TIEMPO: ");
            System.out.print(tiempoActual);
            System.out.print("\n");

            // procesa la llegada de personas para tiempoActual
            bitacora.tiempoProceso(tiempoActual);

            // procesa los eventos del elevador para tiempoActual
            elevador.tiempoProceso(tiempoActual);

            // espera a que se digite una tecla, de manera que el usuario vea la salida
            //System.in.read();
        } // fin de while

    } // fin de la funci�n ejecutaSimulador

/////////////////////////////////////////////////////
    ////////////////////////////////////////////////////
    public elevador getElevador() {
        return elevador;
    }

    public void setElevador(elevador elevador) {
        this.elevador = elevador;
    }

    public reloj getReloj() {
        return reloj;
    }

    public void setReloj(reloj reloj) {
        this.reloj = reloj;
    }

    public bitacora getBitacora() {
        return bitacora;
    }

    public void setBitacora(bitacora bitacora) {
        this.bitacora = bitacora;
    }

} // fin de la clase Edificio
