package entidades;

import java.util.*;

public class piso {

    public static int PISO1;
    public static int PISO2;
    public int numeroPiso; // los n�meros de piso
    public elevador refElevador; // referencia al elevador
    persona ptrOcupante = new persona(); // apuntador a la persona en el piso
    luz luz = new luz(); // objeto luz
    botonPiso botonPiso;

    public piso() {
    }

    // constructor
    public piso(int numero, elevador manipulaElevador) {

        botonPiso botonPiso = new botonPiso(numero, manipulaElevador);
        this.numeroPiso = numero;
        this.refElevador = new elevador();
        ptrOcupante = new persona(numeroPiso);
        this.luz = new luz(numeroPiso);
        System.out.print("piso ");
        System.out.print(numeroPiso);
        System.out.print(" construido");
        System.out.print("\n");

    } // fin del constructor Piso

    public boolean estaOcupado() {
        return (ptrOcupante != null);

    }

    public final int obtieneNumero() {
        return numeroPiso;

    } // fin de la funci�n obtieneNumero

    // pasa un manipulador a la una nueva persona que entra al piso
    // la persona llega al piso
    public void llegaPersona(persona ptrPersona) {
        ptrOcupante = ptrPersona;

    } // fin de la funci�n llegaPersona

    // notifica al piso que el elevador lleg�
    public persona llegaElevador() {
        botonPiso botonPiso = new botonPiso();
        System.out.print("piso ");
        System.out.print(numeroPiso);
        System.out.print(" restablece su boton");
        System.out.print("\n");

        botonPiso.restableceBoton();
        luz.enciende();

        return ptrOcupante;

    } // fin de la funci�n llegaElevador

    // indica al piso que el elevador parte
    public void elevadorParte() {
        luz.apaga();

    } // fin de la funci�n elevadorParte

    // notifica al piso que la persona se va
    public void personaAbordaElevador() {
        ptrOcupante = null; // la persona ya no se encuentra en el piso

    } // fin de la funci�n personaAbordaElevador

////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////
    public static int getPISO1() {
        return PISO1;
    }

    public static void setPISO1(int PISO1) {
        piso.PISO1 = PISO1;
    }

    public static int getPISO2() {
        return PISO2;
    }

    public static void setPISO2(int PISO2) {
        piso.PISO2 = PISO2;
    }

    public int getNumeroPiso() {
        return numeroPiso;
    }

    public void setNumeroPiso(int numeroPiso) {
        this.numeroPiso = numeroPiso;
    }

    public elevador getRefElevador() {
        return refElevador;
    }

    public void setRefElevador(elevador refElevador) {
        this.refElevador = refElevador;
    }

    public persona getPtrOcupante() {
        return ptrOcupante;
    }

    public void setPtrOcupante(persona ptrOcupante) {
        this.ptrOcupante = ptrOcupante;
    }

    public luz getLuz() {
        return luz;
    }

    public void setLuz(luz luz) {
        this.luz = luz;
    }

} // fin de la clase Piso
