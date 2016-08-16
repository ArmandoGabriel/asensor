
package entidades;


import java.util.*;


public class Reloj
{

      
    
   // constructor
   public Reloj()
   {
	   this.tiempo = 0;
	  System.out.print("reloj construido");
	  System.out.print("\n");

   } // fin del constructor Reloj



   // incrementa el tiempo en 1
   public final void marcaSeg()
   {
	  tiempo++;

   } // fin de la funci�n marcaSeg

   public final int obtieneTiempo()
   {
	  return tiempo;

   } // fin de la funci�n obtieneTiempo

   private int tiempo; // tiempo del reloj
////////////////////////////////////////////////
   ////////////////////////////////////////////////

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }
   
   
} // fin de la clase Reloj
