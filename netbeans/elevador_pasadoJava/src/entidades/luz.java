 
package entidades;

import java.util.*;
 
public class luz
{
    
   public boolean encendida; // verdadero si est� encendida; falso si est� apagada
   public  int numeroPiso; // n�mero del piso que contiene la luz

   // constructor
   
      public luz(){
          
      }
   public luz(int numero)
   {
	   this.encendida = false;
	   this.numeroPiso = numero;
	  System.out.print("piso ");
	  System.out.print(numeroPiso);
	  System.out.print(" luz construida");
	  System.out.print("\n");

   } // fin del constructor Luz



    


   // enciende la luz
   public void enciende()
   {
	  if (!encendida)
	  { // si la luz no est� encendida, la enciende
		 encendida = true;
		 System.out.print("piso ");
		 System.out.print(numeroPiso);
		 System.out.print(" se enciende la luz");
		 System.out.print("\n");

	  } // fin de if

   } // fin de la funci�n enciende

   // apaga la luz
   public void apaga()
   {
	  if (encendida)
	  { // si la luz est� encendida, la apaga
		 encendida = false;
		 System.out.print("piso ");
		 System.out.print(numeroPiso);
		 System.out.print(" se apaga la luz");
		 System.out.print("\n");

	  } // fin de if

   } // fin de la funci�n apaga

   ///////////////////////////////////////////////
   /////////////////////////////////////////////

    public boolean isEncendida() {
        return encendida;
    }

    public void setEncendida(boolean encendida) {
        this.encendida = encendida;
    }

    public int getNumeroPiso() {
        return numeroPiso;
    }

    public void setNumeroPiso(int numeroPiso) {
        this.numeroPiso = numeroPiso;
    }
   
   
} // fin de la clase Luz