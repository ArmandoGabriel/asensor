// Fig. 7.46: persona.cpp
// Definici�n de las funciones miembro para la clase Persona.
#include <iostream>

using std::cout;
using std::endl;

#include "persona.h"  // definici�n de la clase Persona
#include "piso.h"     // definici�n de la clase Piso
#include "elevador.h" // definici�n de la clase Elevador

// inicializa el miembro est�tico cuentaPersona
int Persona::cuentaPersonas = 0;

// constructor
Persona::Persona( int pisoDest )
   : ID( ++cuentaPersonas ), 
     pisoDestino( pisoDest ) 
{
   cout << "persona " << ID << " construida" << endl;

} // fin del constructor Persona

// destructor
Persona::~Persona() 
{ 
   cout << "(persona " << ID << " destructor invocado)" << endl;

} // fin del destructor ~Persona

// devuelve el n�mero de ID de persona
int Persona::obtieneID() const 
{ 
   return ID; 

} // fin de la funci�n obtieneID

// la persona entra al piso
void Persona::entraAlPiso( Piso& piso )  
{
   // notifica al piso que viene la persona
   cout << "la persona " << ID << " entra al piso " 
        << piso.obtieneNumero() << endl;
   piso.llegaPersona( this );

   // presiona bot�n del piso
   cout << "persona " << ID 
        << " presiona el boton de piso en el piso " 
        << piso.obtieneNumero() << endl;
   piso.botonPiso.presionaBoton();

} // fin de la funci�n entraAlPiso

// la persona entra al elevador
void Persona::entraElevador( Elevador &elevador, Piso &piso )
{   
   piso.personaAbordaElevador();     // la persona abandona el piso

   elevador.pasajeroEntra( this );   // la persona entra al elevador

   // presiona bot�n del elevador
   cout << "persona " << ID 
        << " presiona el boton del elevador" << endl;
   elevador.botonElevador.presionaBoton();

} // fin de la funci�n entraElevador

// la persona sale del elevador
void Persona::saleElevador( 
   const Piso &piso, Elevador &elevador ) const
{
   cout << "persona " << ID << " sale del elevador en el piso "
        << piso.obtieneNumero() << endl;
   elevador.pasajeroSale();

} // fin de la funci�n saleElevador

/**************************************************************************
 * (C) Copyright 1992-2003 by Deitel & Associates, Inc. and Prentice      *
 * Hall. All Rights Reserved.                                             *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
