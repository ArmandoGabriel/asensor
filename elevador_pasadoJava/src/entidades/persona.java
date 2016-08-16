 
package entidades;

import java.util.*;

public class Persona
{
	public  int cuentaPersonas = 0; // n�mero total de gente
	public int ID; // N�mero de ID �nico de la persona
	public  int pisoDestino; // n�mero de piso de destino

   // constructor

    public Persona() {
    }
        
public Persona(int pisoDestino)
   {
	   this.ID = ++cuentaPersonas;
	   this.pisoDestino = pisoDestino;
	  System.out.print("persona ");
	  System.out.print(ID);
	  System.out.print(" construida");
	  System.out.print("\n");

   } // fin del constructor Persona

   // destructor
   public void dispose()
   {
	  System.out.print("(persona ");
	  System.out.print(ID);
	  System.out.print(" destructor invocado)");
	  System.out.print("\n");

   } // fin del destructor ~Persona


   public int obtieneID()
   {
	  return ID;

   } // fin de la funci�n obtieneID


//piso piso = new piso();   // la persona entra al piso
   public  void entraAlPiso(Piso piso)
   {

       // notifica al piso que viene la persona
	  System.out.print("la persona ");
	  System.out.print(ID);
	  System.out.print(" entra al piso ");
	  System.out.print(piso.obtieneNumero());
	  System.out.print("\n");
	  piso.llegaPersona(this);

	  // presiona bot�n del piso
	  System.out.print("persona ");
	  System.out.print(ID);
	  System.out.print(" presiona el boton de piso en el piso ");
	  System.out.print(piso.obtieneNumero());
	  System.out.print("\n");
          piso.botonPiso.presionaBoton();

   } // fin de la funci�n entraAlPiso

   // la persona entra al elevador
   public  void entraElevador(Elevador elevador, Piso piso)
   {
	  piso.personaAbordaElevador(); // la persona abandona el piso

	  elevador.pasajeroEntra(this); // la persona entra al elevador

	  // presiona bot�n del elevador
	  System.out.print("persona ");
	  System.out.print(ID);
	  System.out.print(" presiona el boton del elevador");
	  System.out.print("\n");
	  elevador.botonElevador.presionaBoton();

   } // fin de la funci�n entraElevador

   // la persona sale del elevador
//ORIGINAL LINE: void saleElevador(const Piso &piso, Elevador &elevador) const
   public final void saleElevador(Piso piso, Elevador elevador)
   {
	  System.out.print("persona ");
	  System.out.print(ID);
	  System.out.print(" sale del elevador en el piso ");
	  System.out.print(piso.obtieneNumero());
	  System.out.print("\n");
	  elevador.pasajeroSale();

   } // fin de la funci�n saleElevador

///////////////////////////////////////////////////////////
   

    public int getCuentaPersonas() {
        return cuentaPersonas;
    }

    public void setCuentaPersonas(int cuentaPersonas) {
        this.cuentaPersonas = cuentaPersonas;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getPisoDestino() {
        return pisoDestino;
    }

    public void setPisoDestino(int pisoDestino) {
        this.pisoDestino = pisoDestino;
    }
   

} // fin de la clase Persona
