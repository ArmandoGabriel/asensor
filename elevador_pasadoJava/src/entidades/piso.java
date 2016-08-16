package entidades;

import java.util.*;

public class Piso {

    ////////////////////////publics////////////////////////
    public static int PISO1 = 1;
    public static int PISO2 = 2;
    public BotonPiso botonPiso;
    ////////////////////////privates////////////////////////
    private static int numeroPiso; // los n�meros de piso
    public Elevador refElevador; // referencia al elevador
    Persona ptrOcupante;// = new Persona(); // apuntador a la persona en el piso
    Luz luz;// = new Luz(); // objeto luz

    public Piso() {
    }

    // constructor
    public Piso(int numero, Elevador manipulaElevador) {//HASTA AQUI REVISE GABRIEL

        botonPiso = new BotonPiso(numero, manipulaElevador);
        numeroPiso = numero;
        refElevador = new Elevador(manipulaElevador);
        ptrOcupante = new Persona(0);//numeroPiso);
        luz = new Luz(numeroPiso);
        
        System.out.print("piso " + numeroPiso + " construido\n");

    } // fin del constructor Piso

    public boolean estaOcupado() {
        return (ptrOcupante != null);

    }

    public final int obtieneNumero() {
        return numeroPiso;

    } // fin de la funci�n obtieneNumero

    // pasa un manipulador a la una nueva persona que entra al piso
    // la persona llega al piso
    public void llegaPersona(Persona ptrPersona) {
        ptrOcupante = ptrPersona;

    } // fin de la funci�n llegaPersona

    // notifica al piso que el elevador lleg�
    public Persona llegaElevador() {
        botonPiso = new BotonPiso();
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
        Piso.PISO1 = PISO1;
    }

    public static int getPISO2() {
        return PISO2;
    }

    public static void setPISO2(int PISO2) {
        Piso.PISO2 = PISO2;
    }

    public int getNumeroPiso() {
        return numeroPiso;
    }

    public void setNumeroPiso(int numeroPiso) {
        this.numeroPiso = numeroPiso;
    }

    public Elevador getRefElevador() {
        return refElevador;
    }

    public void setRefElevador(Elevador refElevador) {
        this.refElevador = refElevador;
    }

    public Persona getPtrOcupante() {
        return ptrOcupante;
    }

    public void setPtrOcupante(Persona ptrOcupante) {
        this.ptrOcupante = ptrOcupante;
    }

    public Luz getLuz() {
        return luz;
    }

    public void setLuz(Luz luz) {
        this.luz = luz;
    }

} // fin de la clase Piso
