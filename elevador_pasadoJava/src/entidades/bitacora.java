package entidades;

import elevador.RandomNumbers;
import java.util.*;
import java.util.Random;

public class Bitacora {

    private int tiempoActualDeReloj;

    private Piso refPiso1;// = new Piso();
    private Piso refPiso2;//= new Piso();

    private int tiempoLlegadaPiso1;
    private int tiempoLlegadaPiso2;

    public Bitacora() {
    }

    // constructor
    public Bitacora(Piso primerPiso, Piso segundoPiso) {
        tiempoActualDeReloj = 0;
        refPiso1 = primerPiso;
        refPiso2 = segundoPiso;
        RandomNumbers.Seed(); // semilla del generador de n�meros aleatorios
        System.out.print("bitacora construida\n");

        // programa las primeras llegadas para los pisos  1 y 2
        programaTiempo(refPiso1);
        programaTiempo(refPiso2);

    } // fin del constructor Bitacora

    // destructor
    // proporciona el tiempo a la bit�cora
    public void tiempoProceso(int tiempo) {
        tiempoActualDeReloj = tiempo; // registra el tiempo

        // manipula la llegada al piso 1
        manipulaLlegadas(refPiso1, tiempoActualDeReloj);

        // manipula la llegada al piso 2
        manipulaLlegadas(refPiso2, tiempoActualDeReloj);

    } // fin de la funci�n tiempoProceso

    // programa llegada al piso
    private void programaTiempo(Piso piso) {
        int numeroPiso = piso.obtieneNumero();

        int randomico = (5 + Math.abs(RandomNumbers.nextNumber() % 16));
        int tiempoLlegada = tiempoActualDeReloj + randomico;

        if (numeroPiso == Piso.PISO1) {
            tiempoLlegadaPiso1 = tiempoLlegada;
        } else {
            tiempoLlegadaPiso2 = tiempoLlegada;
        }

        System.out.print("(la bitacora programa a la siguiente persona para el piso "
                + numeroPiso + " en tiempo " + tiempoLlegada + ')' + "\n");

    } // fin de la funci�n programaTiempo

    // tiempo de retardo de llegada a piso
    // reprograma la llegada al piso
    private void tiempoRetardo(Piso piso) {
        int numeroPiso = piso.obtieneNumero();

        int tiempoLlegada = (numeroPiso == Piso.PISO1) ? ++tiempoLlegadaPiso1 : ++tiempoLlegadaPiso2;

        System.out.print("(la bitacora retarda a la siguiente persona para el piso "
                + numeroPiso + " hasta el tiempo " + tiempoLlegada + ')' + "\n");

    } // fin de la funci�n tiempoRetardo

    // crea nueva persona; la coloca en el piso
    // crea una nueva persona y la coloca en un piso espec�fico
    private void creaNuevaPersona(Piso piso) {
        int pisoDestino = piso.obtieneNumero() == Piso.PISO1 ? Piso.PISO2 : Piso.PISO1;

        // crea una nueva persona
        Persona ptrNuevaPersona = new Persona(pisoDestino);

        System.out.print("bitacora crea una persona "
                + ptrNuevaPersona.obtieneID() + "\n");

        // coloca a la persona en el piso apropiado
        ptrNuevaPersona.entraAlPiso(piso);

        programaTiempo(piso); // programa la siguiente llegada

    } // fin de la funci�n creaNuevaPersona

    // manipulador de llegada de la persona a un piso
    // manipula las llegadas a un piso espec�fico
    private void manipulaLlegadas(Piso piso, int tiempo) {
        int numeroPiso = piso.obtieneNumero();

        int tiempoLlegada = (numeroPiso == Piso.PISO1) ? tiempoLlegadaPiso1 : tiempoLlegadaPiso2;

        if (tiempoLlegada == tiempo) {

            if (piso.estaOcupado()) // si el piso est� ocupado,
            {
                tiempoRetardo(piso); // retarda la llegada
            } else // de lo contrario,
            {
                creaNuevaPersona(piso); // crea una nueva persona
            }

        } // fin del if externo

    } // fin de la funci�n manipulaArribos

///////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////
    public int getTiempoActualDeReloj() {
        return tiempoActualDeReloj;
    }

    public void setTiempoActualDeReloj(int tiempoActualDeReloj) {
        this.tiempoActualDeReloj = tiempoActualDeReloj;
    }

    public Piso getRefPiso1() {
        return refPiso1;
    }

    public void setRefPiso1(Piso refPiso1) {
        this.refPiso1 = refPiso1;
    }

    public Piso getRefPiso2() {
        return refPiso2;
    }

    public void setRefPiso2(Piso refPiso2) {
        this.refPiso2 = refPiso2;
    }

    public int getTiempoLlegadaPiso1() {
        return tiempoLlegadaPiso1;
    }

    public void setTiempoLlegadaPiso1(int tiempoLlegadaPiso1) {
        this.tiempoLlegadaPiso1 = tiempoLlegadaPiso1;
    }

    public int getTiempoLlegadaPiso2() {
        return tiempoLlegadaPiso2;
    }

    public void setTiempoLlegadaPiso2(int tiempoLlegadaPiso2) {
        this.tiempoLlegadaPiso2 = tiempoLlegadaPiso2;
    }

} // fin de la clase Bitacora
