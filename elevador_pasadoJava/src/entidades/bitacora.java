
package entidades;


import elevador.RandomNumbers;
import java.util.*;
import java.util.Random;


public class bitacora
{
    int tiempoActualDeReloj;

    piso refPiso1 = new piso();
    piso refPiso2= new piso();

    int tiempoLlegadaPiso1;
    int tiempoLlegadaPiso2;

    public bitacora() {
    }

    
     // constructor
   public bitacora(piso primerPiso, piso segundoPiso)
   {
	   this.tiempoActualDeReloj = 0;
	   this.refPiso1 = primerPiso;
	   this.refPiso2= segundoPiso;
	  RandomNumbers.Seed(); // semilla del generador de n�meros aleatorios
	  System.out.print("bitacora construida");
	  System.out.print("\n");

	  // programa las primeras llegadas para los pisos  1 y 2
	  programaTiempo(refPiso1);
	  programaTiempo(refPiso2);

   } // fin del constructor Bitacora

   // destructor
  

   // proporciona el tiempo a la bit�cora
   public final void tiempoProceso(int tiempo)
   {
	  tiempoActualDeReloj = tiempo; // registra el tiempo

	  // manipula la llegada al piso 1
	  manipulaLlegadas(refPiso1, tiempoActualDeReloj);

	  // manipula la llegada al piso 2
	  manipulaLlegadas(refPiso2, tiempoActualDeReloj);

   } // fin de la funci�n tiempoProceso

	

   // programa llegada al piso
   public void programaTiempo(piso piso)
   {
	  int numeroPiso = piso.obtieneNumero();
	  int tiempoLlegada = tiempoActualDeReloj + (5 + RandomNumbers.nextNumber() % 16);

	  if(numeroPiso== piso.PISO1){
              tiempoLlegadaPiso1 = tiempoLlegada;
          }
          else{
                   tiempoLlegadaPiso2 = tiempoLlegada;
          }
              

	  System.out.print("(la bitacora programa a la siguiente persona para el piso ");
	  System.out.print(numeroPiso);
	  System.out.print(" en tiempo ");
	  System.out.print(tiempoLlegada);
	  System.out.print(')');
	  System.out.print("\n");

   } // fin de la funci�n programaTiempo

   // tiempo de retardo de llegada a piso

   // reprograma la llegada al piso
   public void tiempoRetardo(piso piso)
   {
	  int numeroPiso = piso.obtieneNumero();

	  int tiempoLlegada = (numeroPiso == piso.PISO1) ?++tiempoLlegadaPiso1 :++tiempoLlegadaPiso2;

	  System.out.print("(la bitacora retarda a la siguiente persona para el piso ");
	  System.out.print(numeroPiso);
	  System.out.print(" hasta el tiempo ");
	  System.out.print(tiempoLlegada);
	  System.out.print(')');
	  System.out.print("\n");

   } // fin de la funci�n tiempoRetardo

   // crea nueva persona; la coloca en el piso

   // crea una nueva persona y la coloca en un piso espec�fico
   public void creaNuevaPersona(piso piso)
   {
	  int pisoDestino = piso.obtieneNumero() == piso.PISO1 ? piso.PISO2 : piso.PISO1;

	  // crea una nueva persona
	  persona ptrNuevaPersona = new persona(pisoDestino);

	  System.out.print("bitacora crea una persona ");
	  System.out.print(ptrNuevaPersona.obtieneID());
	  System.out.print("\n");

	  // coloca a la persona en el piso apropiado
	  ptrNuevaPersona.entraAlPiso(piso);

	  programaTiempo(piso); // programa la siguiente llegada

   } // fin de la funci�n creaNuevaPersona

   // manipulador de llegada de la persona a un piso

   // manipula las llegadas a un piso espec�fico
   public void manipulaLlegadas(piso piso, int tiempo)
   {
	  int numeroPiso = piso.obtieneNumero();

	  int tiempoLlegada = (numeroPiso == piso.PISO1) ? tiempoLlegadaPiso1 : tiempoLlegadaPiso2;

	  if (tiempoLlegada == tiempo)
	  {

		 if (piso.estaOcupado()) // si el piso est� ocupado,
		 {
			tiempoRetardo(piso); // retarda la llegada
		 }

		 else // de lo contrario,
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