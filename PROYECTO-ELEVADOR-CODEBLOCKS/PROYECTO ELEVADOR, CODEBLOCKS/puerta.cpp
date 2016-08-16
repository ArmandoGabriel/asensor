// Fig. 7.36: puerta.cpp
// Definici�n de las funciones miembro para la clase Puerta.
#include <iostream>

using std::cout;
using std::endl;

#include "puerta.h"    // definici�n de la clase Puerta
#include "persona.h"   // definici�n de la clase Persona
#include "piso.h"      // definici�n de la clase Piso
#include "elevador.h"  // definici�n de la clase Elevador

// constructor
Puerta::Puerta() 
   : abierta( false )  // inicializa abierto en falso
{ 
   cout << "puerta construida" << endl; 

} // fin del constructor Puerta

// destructor
Puerta::~Puerta() 
{
   cout << "puerta destruida" << endl; 

} // fin del destructor ~Puerta

// abre la puerta
void Puerta::abrePuerta( Persona * const ptrPasajero, 
   Persona * const ptrSiguientePasajero, Piso &pisoActual, 
   Elevador &elevador ) 
{ 
   if ( !abierta ) {  // si la puerta no est� abierta, abre la puerta
      abierta = true; 
   
      cout << "el elevador abre su puerta en el piso "
           << pisoActual.obtieneNumero() << endl;

      // si el psajero est� en el elevador, le indica que salga
      if ( ptrPasajero != 0 ) {
         ptrPasajero->saleElevador( pisoActual, elevador );
         delete ptrPasajero; // el pasajero abandona el elevador

      } // fin de if

      // si el pasajero est� esperando el elevador
      // le indica que entre
      if ( ptrSiguientePasajero != 0 )
         ptrSiguientePasajero->entraElevador( 
            elevador, pisoActual );

   } // fin del if externo

} // fin de la funci�n abrePuerta

// cierra la puerta
void Puerta::cierraPuerta( const Piso &pisoActual ) 
{
   if ( abierta ) {  // si la puerta est� abierta, la cierra
      abierta = false; 
      cout << "el elevador cierra sus puertas en el piso "
           << pisoActual.obtieneNumero() << endl;

   } // fin de if

} // fin de la funci�n cierraPuerta

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
