// Fig. 7.26: edificio.cpp
// Definición de las funciones miembro para la clase Edificio.
#include <iostream>

using std::cout;
using std::cin;
using std::endl;

#include "edificio.h"  // Definición de la clase Edificio

// constructor
Edificio::Edificio() 
   : piso1( Piso::PISO1, elevador ), 
     piso2( Piso::PISO2, elevador ),
     elevador( piso1, piso2 ), 
     bitacora( piso1, piso2 )
{ 
   cout << "edificio construido" << endl; 

} // fin del constructor Edificio

// destructor
Edificio::~Edificio() 
{ 
   cout << "edificio destruido" << endl; 

} // fin del destructor ~Edificio

// función para controlar la simulación
void Edificio::ejecutaSimulador( int tiempoTotal )
{
   int tiempoActual = 0;

   while ( tiempoActual < tiempoTotal ) {
      reloj.marcaSeg();                      // incrementa el tiempo  
      tiempoActual = reloj.obtieneTiempo();  // obtiene tiempo nuevo
      cout << "TIEMPO: " << tiempoActual << endl;   
      
      // procesa la llegada de personas para tiempoActual
      bitacora.tiempoProceso( tiempoActual );

      // procesa los eventos del elevador para tiempoActual
      elevador.tiempoProceso( tiempoActual );

      // espera a que se digite una tecla, de manera que el usuario vea la salida
      cin.get(); 

   } // fin de while

} // fin de la función ejecutaSimulador

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
