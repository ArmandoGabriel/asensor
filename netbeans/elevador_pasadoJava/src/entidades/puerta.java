package entidades;
 
import java.util.*;

public class puerta
{
   // constructor
   public puerta()
   {
	   this.abierta = false;
	  System.out.print("puerta construida");
	  System.out.print("\n");

   } // fin del constructor Puerta




   // abre la puerta
   public void abrePuerta(persona ptrPasajero, persona ptrSiguientePasajero, piso pisoActual, elevador elevador)
   {
	  if (!abierta)
	  { // si la puerta no est� abierta, abre la puerta
		 abierta = true;

		 System.out.print("el elevador abre su puerta en el piso ");
		 System.out.print(pisoActual.obtieneNumero());
		 System.out.print("\n");

		 // si el psajero est� en el elevador, le indica que salga
		 if (ptrPasajero != null)
		 {
			ptrPasajero.saleElevador(pisoActual, elevador);
			if (ptrPasajero != null)
				ptrPasajero.dispose();// el pasajero abandona el elevador

		 } // fin de if

		 // si el pasajero est� esperando el elevador
		 // le indica que entre
		 if (ptrSiguientePasajero != null)
		 {
			ptrSiguientePasajero.entraElevador(elevador, pisoActual);
		 }

	  } // fin del if externo

   } // fin de la funci�n abrePuerta

   // cierra la puerta
   public final void cierraPuerta(piso pisoActual)
   {
	  if (abierta)
	  { // si la puerta est� abierta, la cierra
		 abierta = false;
		 System.out.print("el elevador cierra sus puertas en el piso ");
		 System.out.print(pisoActual.obtieneNumero());
		 System.out.print("\n");

	  } // fin de if

   } // fin de la funci�n cierraPuerta

   public boolean abierta; // abierto o cerrado

   ////////////////////////////////////////////////////////////////////////////
   
   //////////////////////////////////////////////////////////////////////////

    public boolean isAbierta() {
        return abierta;
    }

    public void setAbierta(boolean abierta) {
        this.abierta = abierta;
    }
   
   
   
}