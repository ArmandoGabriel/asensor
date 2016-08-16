package entidades;

import java.util.*;

public class BotonElevador {

    public boolean presionado; // estado del bot�n

    // referencia al elevador que contiene este bot�n
    Elevador refElevador = new Elevador();

    public BotonElevador() {
    }

    // constructor
    public BotonElevador(Elevador manipulaElevador) {
        this.presionado = false;
        this.refElevador = manipulaElevador;
        System.out.print("boton del elevador construido");
        System.out.print("\n");

    } // fin del constructor BotonElevador

    // presiona el bot�n e indica al elevador que se prepare para abandonar el piso
    public void presionaBoton() {
        presionado = true;
        System.out.print("el boton del elevador le indica al elevador que se prepare para partir");
        System.out.print("\n");
        refElevador.preparaParaPartir(true);

    } // fin de la funci�n presionaBoton

    // restablece el bot�n
    public void restableceBoton() {
        presionado = false;

    } // fin de la funci�n restableceBoton

    public boolean isPresionado() {
        return presionado;
    }

    public void setPresionado(boolean presionado) {
        this.presionado = presionado;
    }

    public Elevador getRefElevador() {
        return refElevador;
    }

    public void setRefElevador(Elevador refElevador) {
        this.refElevador = refElevador;
    }
} // fin de la clase BotonElevador
