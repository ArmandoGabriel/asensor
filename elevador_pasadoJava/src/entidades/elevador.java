package entidades;

import java.util.*;
import elevador.*;

public class Elevador {
    // constantes est�ticas que representan el tiempo requerido para viajar
    // entre los pisos y las direcciones del elevador

    public BotonElevador botonElevador;

    private static final int TIEMPO_VIAJE_ELEVADOR = 5;
    private static final int ARRIBA = 0;
    private static final int ABAJO = 1;

    // datos miembros
    private int tiempoActualRelojDelEdificio; // tiempo actual
    private boolean enMovimiento; // estado del elevador
    private int direccion; // direcci�n actual
    private int pisoActual; // ubicaci�n actual
    private int tiempoLlegada; // tiempo de llegada al piso
    private boolean piso1NecesitaServicio; // bandera de servicio del piso1
    private boolean piso2NecesitaServicio; // bandera de servicio del piso1

    private Piso refPiso1;// = new Piso(); // referencia al piso 1
    private Piso refPiso2;// = new Piso(); // referencia al piso 2
//botonElevador botonElevador = new botonElevador ();
    private Persona ptrPasajero;// = new Persona();

    private Puerta puerta = new Puerta(); // objeto puerta
    private Campana campana = new Campana(); // objeto campana
    //  botonElevador botonElevador = new botonElevador();
// constructor

    public Elevador() {

    }

    public Elevador(Piso primerPiso, Piso segundoPiso) {
        botonElevador = new BotonElevador();
        this.tiempoActualRelojDelEdificio = 0;
        this.enMovimiento = false;
        this.direccion = ARRIBA;
        pisoActual = Piso.PISO1;
        this.tiempoLlegada = 0;
        this.piso1NecesitaServicio = false;
        this.piso2NecesitaServicio = false;
        refPiso1 = primerPiso;
        refPiso2 = segundoPiso;
        ptrPasajero = new Persona();
        System.out.print("elevador construido\n");

    } // fin del constructor Elevador

    // solicita servicio del elevador
    public void llamaElevador(int piso) {

        // establece la bandera de servicio apropiada
        if (piso == Piso.PISO1) {
            piso1NecesitaServicio = true;
        } else {
            piso2NecesitaServicio = true;
        }

    } // fin de la funci�n llamaElevador

    // se prepara para abandonar el piso
    public final void preparaParaPartir(boolean parte) {
        // obtiene la referencia al piso actual
        Piso estePiso = pisoActual == Piso.PISO1 ? refPiso1 : refPiso2;

        // notifica al piso que el elevador puede partir
        estePiso.elevadorParte();

        puerta.cierraPuerta(estePiso);

        if (parte) // parte, si es necesario
        {
            mover();
        }

    } // fin de la funci�n preparaParaPartir

    // da tiempo al elevador
    public void tiempoProceso(int tiempo) {
        tiempoActualRelojDelEdificio = tiempo;

        if (enMovimiento) // elevador en movimiento
        {
            procesaPosibleLlegada();
        } else // elevador detenido
        {
            procesaPosiblePartida();
        }

        if (!enMovimiento) {
            System.out.print("el elevador descansa en el piso " + pisoActual + "\n");
        }

    } // fin de la funci�n tiempoProceso

    // acepta un pasajero
    public void pasajeroEntra(Persona ptrPersona) {
        // el pasajero aborda
        ptrPasajero = ptrPersona;

        System.out.print("persona " + ptrPasajero.obtieneID()
                + " entra al elevador desde el piso " + pisoActual + "\n");

    } // fin de la funci�n pasajeroEntra

    // notifica al elevador que el pasajero va a salir
    public void pasajeroSale() {
        ptrPasajero = null;

    } // fin de la funci�n pasajeroSale

    // objeto p�blico accesible al c�digo cliente
    // con acceso al objeto Elevador
    //public botonElevador botonElevador = new botonElevador();
    // funciones de utilidad
    // cuando el elevador se encuentra en movimiento, determina si se debe detener
    private void procesaPosibleLlegada() {
        // si el elevador llega al piso de destino
        if (tiempoActualRelojDelEdificio == tiempoLlegada) {

            pisoActual = (pisoActual == Piso.PISO1 ? Piso.PISO2 : Piso.PISO1); // actualiza el piso actual

            direccion = (pisoActual == Piso.PISO1 ? ARRIBA : ABAJO); // actualiza direcci�n

            System.out.print("el elevador llega al piso " + pisoActual + "\n");

            // procesa la llegada a pisoActual
            llegaAlPiso(pisoActual == Piso.PISO1 ? refPiso1 : refPiso2);

            return;

        } // fin de if

        // el elevador sigue en movimiento
        System.out.print("elevador en movimiento " + (direccion == ARRIBA ? "arriba" : "abajo") + "\n");

    } // fin de la funci�n procesaPosibleLlegada

    // determina si el elevador debe moverse
    private void procesaPosiblePartida() {
        // �Este piso necesita servicio?
        boolean pisoActualNecesitaServicio = pisoActual == Piso.PISO1 ? piso1NecesitaServicio : piso2NecesitaServicio;

        // �el otro piso necesita servicio?
        boolean otroPisoNecesitaServicio = pisoActual == Piso.PISO1 ? piso2NecesitaServicio : piso1NecesitaServicio;

        // servicio en este piso (si es necesario)
        if (pisoActualNecesitaServicio) {
            llegaAlPiso(pisoActual == Piso.PISO1 ? refPiso1 : refPiso2);

            return;
        }

        // servicio en el otro piso (si es necesario)
        if (otroPisoNecesitaServicio) {
            preparaParaPartir(true);
        }

    } // fin de la funci�n procesaPosiblePartida

    // llega a un piso en particular
    private void llegaAlPiso(Piso llegaAlPiso) {
        enMovimiento = false; // restablece el estado
        //botonElevador = new BotonElevador();
        System.out.print("el elevador restablece su boton\n");
        botonElevador.restableceBoton();

        campana.suenaCampana();

        // notifica al piso que el elevador lleg�
        Persona ptrPisoPersona = llegaAlPiso.llegaElevador();

        puerta.abrePuerta(ptrPasajero, ptrPisoPersona, llegaAlPiso, this);

        // �este piso necesita servicio?
        boolean pisoActualNecesitaServicio = pisoActual == Piso.PISO1 ? piso1NecesitaServicio : piso2NecesitaServicio;

        // �el otro piso necesita servicio?
        boolean otroPisoNecesitaServicio = pisoActual == Piso.PISO1 ? piso2NecesitaServicio : piso2NecesitaServicio;

        // si este piso no necesita servicio
        // se prepara para partir hacia el otro piso
        if (!pisoActualNecesitaServicio) {
            preparaParaPartir(otroPisoNecesitaServicio);
        } else // de lo contrario, restablece la bandera de servicio
        {
            if (pisoActual == Piso.PISO1) {
                piso1NecesitaServicio = false;
            } else {
                piso2NecesitaServicio = false;

            }
        }

    } // fin de la funci�n llegaAlPiso

    // va al otro piso
    private void mover() {
        enMovimiento = true; // cambiar estado

        // programa tiempo llegada
        tiempoLlegada = tiempoActualRelojDelEdificio + TIEMPO_VIAJE_ELEVADOR;

        System.out.print("el elevador comienza a moverse "+
                (direccion == ABAJO ? "abajo " : "arriba ")+"al piso "+
                (direccion == ABAJO ? '1' : '2')+" (llega a tiempo "+
                tiempoLlegada+')'+"\n");

    } // fin de la funci�n mueve

    // constantes est�ticas que representan el tiempo requerido para viajar
    // entre los pisos y las direcciones del elevador
/////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////
    public int getTiempoActualRelojDelEdificio() {
        return tiempoActualRelojDelEdificio;
    }

    public void setTiempoActualRelojDelEdificio(int tiempoActualRelojDelEdificio) {
        this.tiempoActualRelojDelEdificio = tiempoActualRelojDelEdificio;
    }

    public boolean isEnMovimiento() {
        return enMovimiento;
    }

    public void setEnMovimiento(boolean enMovimiento) {
        this.enMovimiento = enMovimiento;
    }

    public int getDireccion() {
        return direccion;
    }

    public void setDireccion(int direccion) {
        this.direccion = direccion;
    }

    public int getPisoActual() {
        return pisoActual;
    }

    public void setPisoActual(int pisoActual) {
        this.pisoActual = pisoActual;
    }

    public int getTiempoLlegada() {
        return tiempoLlegada;
    }

    public void setTiempoLlegada(int tiempoLlegada) {
        this.tiempoLlegada = tiempoLlegada;
    }

    public boolean isPiso1NecesitaServicio() {
        return piso1NecesitaServicio;
    }

    public void setPiso1NecesitaServicio(boolean piso1NecesitaServicio) {
        this.piso1NecesitaServicio = piso1NecesitaServicio;
    }

    public boolean isPiso2NecesitaServicio() {
        return piso2NecesitaServicio;
    }

    public void setPiso2NecesitaServicio(boolean piso2NecesitaServicio) {
        this.piso2NecesitaServicio = piso2NecesitaServicio;
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

    public Persona getPtrPasajero() {
        return ptrPasajero;
    }

    public void setPtrPasajero(Persona ptrPasajero) {
        this.ptrPasajero = ptrPasajero;
    }

    public Puerta getPuerta() {
        return puerta;
    }

    public void setPuerta(Puerta puerta) {
        this.puerta = puerta;
    }

    public Campana getCampana() {
        return campana;
    }

    public void setCampana(Campana campana) {
        this.campana = campana;
    }

} // fin de la clase Elevador
