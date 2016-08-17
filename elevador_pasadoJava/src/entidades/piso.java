package entidades;

import java.util.*;

public class Piso {

    ////////////////////////publics////////////////////////
    public static final int PISO1 = 1;
    public static final int PISO2 = 2;
    public BotonPiso botonPiso = new BotonPiso();
    ////////////////////////privates////////////////////////
    private int numeroPiso; //final?
    private Elevador refElevador; // referencia al elevador
    private Persona ptrOcupante;// = new Persona(); // apuntador a la persona en el piso
    private Luz luz;// = new Luz(); // objeto luz

    public Piso() {
    }

    // constructor
    public Piso(int numero, Elevador manipulaElevador) {//HASTA AQUI REVISE GABRIEL
        numeroPiso = numero; // los n�meros de piso
        botonPiso = new BotonPiso(numero, manipulaElevador);

        refElevador = manipulaElevador;
        ptrOcupante = new Persona(numeroPiso);
        luz = new Luz(numeroPiso);

        System.out.print("piso " + numeroPiso + " construido\n");

    } // fin del constructor Piso

    public boolean estaOcupado() {
        return (ptrOcupante.getID() != 0);
    }

    public int obtieneNumero() {
        return numeroPiso;

    } // fin de la funci�n obtieneNumero

    // pasa un manipulador a la una nueva persona que entra al piso
    // la persona llega al piso
    public void llegaPersona(Persona ptrPersona) {
        ptrOcupante = ptrPersona;

    } // fin de la funci�n llegaPersona

    // notifica al piso que el elevador lleg�
    public Persona llegaElevador() {
        //botonPiso = new BotonPiso();
        System.out.print("piso "+numeroPiso+" restablece su boton\n");

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
        ptrOcupante.setID(0); // la persona ya no se encuentra en el piso

    } // fin de la funci�n personaAbordaElevador
    
    ///////////////////////////////////////////////////
    //////////Getters y Setters///////////
    
    public BotonPiso getBotonPiso() {
        return botonPiso;
    }

    public void setBotonPiso(BotonPiso botonPiso) {
        this.botonPiso = botonPiso;
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
