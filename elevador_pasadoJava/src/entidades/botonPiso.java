package entidades;

import java.util.*;

public class BotonPiso {

    private int numeroPiso; // n�mero de piso del bot�n
    private boolean presionado; // estado del bot�n

    // referencia al elevador utilizado para llamar
    // al elevado al piso
    private Elevador refElevador = new Elevador();
    
    public BotonPiso() {
    }

// constructor
    public BotonPiso(int piso, Elevador manipulaElevador) {
        numeroPiso = piso;
        presionado = false;
        this.refElevador = manipulaElevador;
        System.out.print("boton del piso "+numeroPiso+" construido\n");

    } // fin del constructor BotonPiso

    // presiona el boton
    public void presionaBoton() {
        presionado = true;
        System.out.print("boton del piso "+numeroPiso+" llama al elevador\n");

        // llama al elevador a este piso

        refElevador.llamaElevador(numeroPiso);

    } //fin de la funci�n presionaBoton

    // restablece el bot�n
    public void restableceBoton() {
        presionado = false;

    } // fin de la funci�n restableceBoton

///////////////////////////////////////////
    

    public int getNumeroPiso() {
        return numeroPiso;
    }

    public void setNumeroPiso(int numeroPiso) {
        this.numeroPiso = numeroPiso;
    }

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
} // fin de la clase botonPiso
