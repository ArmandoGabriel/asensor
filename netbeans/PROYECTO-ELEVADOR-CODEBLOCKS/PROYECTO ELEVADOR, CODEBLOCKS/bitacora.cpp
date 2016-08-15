// Fig. 7.30: bitacora.cpp
// Definición de las funciones miembro de la clase Bitacora.
#include <iostream>

using std::cout;
using std::endl;

#include <new>
#include <cstdlib>
#include <ctime>

#include "bitacora.h"  // definición de la clase Bitacora
#include "piso.h"      // definición de la clase Piso
#include "persona.h"   // definición de la clase Persona

// constructor
Bitacora::Bitacora( Piso &primerPiso, Piso &segundoPiso )
   : tiempoActualDeReloj( 0 ),  
     refPiso1( primerPiso ),
     refPiso2( segundoPiso )
{
   srand( time( 0 ) ); // semilla del generador de números aleatorios
   cout << "bitacora construida" << endl;

   // programa las primeras llegadas para los pisos  1 y 2
   programaTiempo( refPiso1 );
   programaTiempo( refPiso2 );

} // fin del constructor Bitacora

// destructor
Bitacora::~Bitacora() 
{ 
   cout << "bitacora destruida" << endl; 

} // fin del destructor ~Bitacora

// programa llegada al piso
void Bitacora::programaTiempo( const Piso &piso )
{
   int numeroPiso = piso.obtieneNumero();
   int tiempoLlegada = tiempoActualDeReloj + ( 5 + rand() % 16 );

   numeroPiso == Piso::PISO1 ?
	  tiempoLlegadaPiso1 = tiempoLlegada : 
      tiempoLlegadaPiso2 = tiempoLlegada;

   cout << "(la bitacora programa a la siguiente persona para el piso " 
        << numeroPiso << " en tiempo " << tiempoLlegada << ')'
        << endl;

} // fin de la función programaTiempo

// reprograma la llegada al piso
void Bitacora::tiempoRetardo( const Piso &piso )
{
   int numeroPiso = piso.obtieneNumero();

   int tiempoLlegada = ( numeroPiso == Piso::PISO1 ) ? 
      ++tiempoLlegadaPiso1 : ++tiempoLlegadaPiso2;

   cout << "(la bitacora retarda a la siguiente persona para el piso "
        << numeroPiso << " hasta el tiempo " << tiempoLlegada << ')'
        << endl;

} // fin de la función tiempoRetardo

// proporciona el tiempo a la bitácora
void Bitacora::tiempoProceso( int tiempo )
{
   tiempoActualDeReloj = tiempo;   // registra el tiempo
   
   // manipula la llegada al piso 1
   manipulaLlegadas( refPiso1, tiempoActualDeReloj );

   // manipula la llegada al piso 2
   manipulaLlegadas( refPiso2, tiempoActualDeReloj );
    
} // fin de la función tiempoProceso

// crea una nueva persona y la coloca en un piso específico
void Bitacora::creaNuevaPersona( Piso &piso )
{
   int pisoDestino = 
      piso.obtieneNumero() == Piso::PISO1 ?
         Piso::PISO2 : Piso::PISO1;

   // crea una nueva persona
   Persona *ptrNuevaPersona = new Persona( pisoDestino );

   cout << "bitacora crea una persona " 
        << ptrNuevaPersona->obtieneID() << endl;
   
   // coloca a la persona en el piso apropiado
   ptrNuevaPersona->entraAlPiso( piso );
   
   programaTiempo( piso ); // programa la siguiente llegada

} // fin de la función creaNuevaPersona

// manipula las llegadas a un piso específico
void Bitacora::manipulaLlegadas( Piso &piso, int tiempo )
{
   int numeroPiso = piso.obtieneNumero();

   int tiempoLlegada = ( numeroPiso == Piso::PISO1 ) ? 
      tiempoLlegadaPiso1 : tiempoLlegadaPiso2;

   if ( tiempoLlegada == tiempo ) {
      
      if ( piso.estaOcupado() )     // si el piso está ocupado,
         tiempoRetardo( piso );     // retarda la llegada

      else                          // de lo contrario, 
         creaNuevaPersona( piso );  // crea una nueva persona

   } // fin del if externo

} // fin de la función manipulaArribos

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
