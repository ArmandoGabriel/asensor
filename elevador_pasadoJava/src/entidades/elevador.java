package entidades;

import java.util.*;
import elevador.*;

public class elevador
{
       // constantes est�ticas que representan el tiempo requerido para viajar
   // entre los pisos y las direcciones del elevador
   public final  int TIEMPO_VIAJE_ELEVADOR = 5;
   public final  int ARRIBA = 0;
   public  final int ABAJO = 1;

   // datos miembros
   public int tiempoActualRelojDelEdificio; // tiempo actual
   public boolean enMovimiento; // estado del elevador
   public int direccion; // direcci�n actual
   public int pisoActual; // ubicaci�n actual
   public int tiempoLlegada; // tiempo de llegada al piso
   public boolean piso1NecesitaServicio; // bandera de servicio del piso1
   public boolean piso2NecesitaServicio; // bandera de servicio del piso1

    piso refPiso1 = new piso(); // referencia al piso 1
   piso refPiso2 = new piso(); // referencia al piso 2
//botonElevador botonElevador = new botonElevador ();
   persona ptrPasajero = new persona();

   puerta puerta = new puerta(); // objeto puerta
   campana campana = new campana(); // objeto campana
 //  botonElevador botonElevador = new botonElevador();
// constructor
    botonElevador botonElevador;

    public elevador() {
        
    }

  
   
   
   public elevador(piso primerPiso, piso segundoPiso)
   {
	 botonElevador botonElevador = new botonElevador();
	   this.tiempoActualRelojDelEdificio = 0;
	   this.enMovimiento = false;
	   this.direccion = ARRIBA;
	   pisoActual = piso.PISO1;
	   this.tiempoLlegada = 0;
	   this.piso1NecesitaServicio = false;
	   this.piso2NecesitaServicio = false;
	    refPiso1 = primerPiso;
	    refPiso2 = segundoPiso;
	   this.ptrPasajero = new persona();
	  System.out.print("elevador construido");
	  System.out.print("\n");

   } // fin del constructor Elevador

  




   // solicita servicio del elevador
   public  void llamaElevador(int piso)
   {
       
	  // establece la bandera de servicio apropiada
	  if(piso == pisoActual){
              piso1NecesitaServicio = true;
          }
          else {
                piso2NecesitaServicio = true;
          }

   } // fin de la funci�n llamaElevador

   // se prepara para abandonar el piso
   public final void preparaParaPartir(boolean parte)
   {
	  // obtiene la referencia al piso actual
	  piso estePiso = pisoActual == piso.PISO1 ? refPiso1 : refPiso2;

	  // notifica al piso que el elevador puede partir
	  estePiso.elevadorParte();

	  puerta.cierraPuerta(estePiso);

	  if (parte) // parte, si es necesario
	  {
		 mover();
	  }

   } // fin de la funci�n preparaParaPartir

   // da tiempo al elevador
   public  void tiempoProceso(int tiempo)
   {
	  tiempoActualRelojDelEdificio = tiempo;

	  if (enMovimiento) // elevador en movimiento
	  {
		 procesaPosibleLlegada();
	  }

	  else // elevador detenido
	  {
		 procesaPosiblePartida();
	  }

	  if (!enMovimiento)
	  {
		 System.out.print("el elevador descansa en el piso ");
		 System.out.print(pisoActual);
		 System.out.print("\n");
	  }

   } // fin de la funci�n tiempoProceso

   // acepta un pasajero
   public void pasajeroEntra( persona ptrPersona)
   {
	  // el pasajero aborda
	  ptrPasajero = ptrPersona;

	  System.out.print("persona ");
	  System.out.print(ptrPasajero.obtieneID());
	  System.out.print(" entra al elevador desde el piso ");
	  System.out.print(pisoActual);
	  System.out.print("\n");

   } // fin de la funci�n pasajeroEntra

   // notifica al elevador que el pasajero va a salir
   public  void pasajeroSale()
   {
	  ptrPasajero = null;

   } // fin de la funci�n pasajeroSale

   // objeto p�blico accesible al c�digo cliente
   // con acceso al objeto Elevador
   //public botonElevador botonElevador = new botonElevador();


   // funciones de utilidad

   // cuando el elevador se encuentra en movimiento, determina si se debe detener
   private void procesaPosibleLlegada()
   {
	  // si el elevador llega al piso de destino
	  if (tiempoActualRelojDelEdificio == tiempoLlegada)
	  {

		 pisoActual = (pisoActual == piso.PISO1 ? piso.PISO2 : piso.PISO1); // actualiza el piso actual

		 direccion = (pisoActual == piso.PISO1 ? ARRIBA : ABAJO); // actualiza direcci�n

		 System.out.print("el elevador llega al piso ");
		 System.out.print(pisoActual);
		 System.out.print("\n");

		 // procesa la llegada a pisoActual
		 llegaAlPiso(pisoActual == piso.PISO1 ? refPiso1 : refPiso2);

		 return;

	  } // fin de if

	  // el elevador sigue en movimiento
	  System.out.print("elevador en movimiento ");
	  System.out.print((direccion == ARRIBA  ? "arriba" : "abajo"));
	  System.out.print("\n");

   } // fin de la funci�n procesaPosibleLlegada

   // determina si el elevador debe moverse
   private void procesaPosiblePartida()
   {
	  // �Este piso necesita servicio?
	  boolean pisoActualNecesitaServicio = pisoActual == piso.PISO1 ? piso1NecesitaServicio : piso2NecesitaServicio;

	  // �el otro piso necesita servicio?
	  boolean otroPisoNecesitaServicio = pisoActual == piso.PISO1 ? piso2NecesitaServicio : piso1NecesitaServicio;

	  // servicio en este piso (si es necesario)
	  if (pisoActualNecesitaServicio)
	  {
		 llegaAlPiso(pisoActual == piso.PISO1 ? refPiso1 : refPiso2);

		 return;
	  }

	  // servicio en el otro piso (si es necesario)
	  if (otroPisoNecesitaServicio)
	  {
		 preparaParaPartir(true);
	  }

   } // fin de la funci�n procesaPosiblePartida

   // llega a un piso en particular
   private void llegaAlPiso(piso llegaAlPiso)
   {
	  enMovimiento = false; // restablece el estado
botonElevador botonElevador = new botonElevador();
	  System.out.print("el elevador restablece su boton");
	  System.out.print("\n");
	  botonElevador.restableceBoton();

	  campana.suenaCampana();

	  // notifica al piso que el elevador lleg�
	  persona ptrPisoPersona = llegaAlPiso.llegaElevador();

	  puerta.abrePuerta(ptrPasajero, ptrPisoPersona, llegaAlPiso, this);

	  // �este piso necesita servicio?
	  boolean pisoActualNecesitaServicio = pisoActual == piso.PISO1 ? piso1NecesitaServicio : piso2NecesitaServicio;

	  // �el otro piso necesita servicio?
	  boolean otroPisoNecesitaServicio = pisoActual == piso.PISO1 ? piso2NecesitaServicio : piso2NecesitaServicio;

	  // si este piso no necesita servicio
	  // se prepara para partir hacia el otro piso
	  if (!pisoActualNecesitaServicio)
	  {
		 preparaParaPartir(otroPisoNecesitaServicio);
	  }

	  else // de lo contrario, restablece la bandera de servicio
	  {
		 if(pisoActual == piso.PISO1)
                 {piso1NecesitaServicio = false;} 
                 else
                 {piso2NecesitaServicio = false;
                 
                 }
	  }

   } // fin de la funci�n llegaAlPiso

   // va al otro piso
   private void mover()
   {
	  enMovimiento = true; // cambiar estado

	  // programa tiempo llegada
	  tiempoLlegada = tiempoActualRelojDelEdificio + TIEMPO_VIAJE_ELEVADOR;

	  System.out.print("el elevador comienza a moverse ");
	  System.out.print((direccion == ABAJO ? "abajo " : "arriba "));
	  System.out.print("al piso ");
	  System.out.print((direccion == ABAJO  ? '1' : '2'));
	  System.out.print(" (llega a tiempo ");
	  System.out.print(tiempoLlegada);
	  System.out.print(')');
	  System.out.print("\n");

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

    public piso getRefPiso1() {
        return refPiso1;
    }

    public void setRefPiso1(piso refPiso1) {
        this.refPiso1 = refPiso1;
    }

    public piso getRefPiso2() {
        return refPiso2;
    }

    public void setRefPiso2(piso refPiso2) {
        this.refPiso2 = refPiso2;
    }

    public persona getPtrPasajero() {
        return ptrPasajero;
    }

    public void setPtrPasajero(persona ptrPasajero) {
        this.ptrPasajero = ptrPasajero;
    }

    public puerta getPuerta() {
        return puerta;
    }

    public void setPuerta(puerta puerta) {
        this.puerta = puerta;
    }

    public campana getCampana() {
        return campana;
    }

    public void setCampana(campana campana) {
        this.campana = campana;
    }


} // fin de la clase Elevador