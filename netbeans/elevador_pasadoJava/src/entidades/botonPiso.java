package entidades;

import java.util.*;

public class botonPiso
{
       public  int numeroPiso; // n�mero de piso del bot�n
   public boolean presionado; // estado del bot�n

   // referencia al elevador utilizado para llamar
   // al elevado al piso
    elevador refElevador  = new elevador();

    public botonPiso() {
    }

// constructor
    
	public botonPiso(int piso, elevador manipulaElevador)
	{
		this.numeroPiso = piso;
		this.presionado = false;
		this.refElevador = manipulaElevador;
	   System.out.print("boton del piso ");
	   System.out.print(numeroPiso);
	   System.out.print(" construido");
	   System.out.print("\n");

	} // fin del constructor BotonPiso




   // presiona el boton
   public  void presionaBoton()
   {
	  presionado = true;
	  System.out.print("boton del piso ");
	  System.out.print(numeroPiso);
	  System.out.print(" llama al elevador");
	  System.out.print("\n");

	  // llama al elevador a este piso
	  refElevador.llamaElevador(numeroPiso);

   } //fin de la funci�n presionaBoton

   // restablece el bot�n
   public void restableceBoton()
   {
	  presionado = false;

   } // fin de la funci�n restableceBoton

///////////////////////////////////////////
   
   
   ///////////////////////////////////////

    public int getNumeroPiso() {
        return numeroPiso;
    }

    public void setNumeroPiso(int numeroPiso) {
        this.numeroPiso = numeroPiso;
    }

    public boolean isPresionado() {
        return presionado;
    }

    public void setPresionado(boolean presionado) {
        this.presionado = presionado;
    }

    public elevador getRefElevador() {
        return refElevador;
    }

    public void setRefElevador(elevador refElevador) {
        this.refElevador = refElevador;
    }

} // fin de la clase botonPiso
