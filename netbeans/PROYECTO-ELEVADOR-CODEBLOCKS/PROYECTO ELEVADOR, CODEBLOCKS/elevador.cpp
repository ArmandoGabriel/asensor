// Fig. 7.42: elevador.cpp
// Definición de las funciones miembro para la clase Elevador.
#include <iostream>

using std::cout;
using std::endl;

#include "elevador.h"  // definición de la clase Elevador
#include "persona.h"   // definición de la clase Persona
#include "piso.h"      // definición de la clase Piso

// constantes que representan el tiempo que se requiere para viajar
// entre pisos y direcciones del elevador
const int Elevador::TIEMPO_VIAJE_ELEVADOR = 5;
const int Elevador::ARRIBA = 0;
const int Elevador::ABAJO = 1;

// constructor
Elevador::Elevador( Piso &primerPiso, Piso &segundoPiso )
   : botonElevador( *this ),
     tiempoActualRelojDelEdificio( 0 ),
     enMovimiento( false ),
     direccion( ARRIBA ),
     pisoActual( Piso::PISO1 ),
     tiempoLlegada( 0 ),
     piso1NecesitaServicio( false ),
     piso2NecesitaServicio( false ),
     refPiso1( primerPiso ),
     refPiso2( segundoPiso ),
     ptrPasajero( 0 )
{
   cout << "elevador construido" << endl;

} // fin del constructor Elevador

// destructor
Elevador::~Elevador()
{
   delete ptrPasajero;
   cout << "elevador destruido" << endl;

} // fin del destructor ~Elevador

// da tiempo al elevador
void Elevador::tiempoProceso( int tiempo )
{
   tiempoActualRelojDelEdificio = tiempo;

   if ( enMovimiento )  // elevador en movimiento
      procesaPosibleLlegada();

   else           // elevador detenido
      procesaPosiblePartida();

   if ( !enMovimiento )
      cout << "el elevador descansa en el piso "
           << pisoActual << endl;

} // fin de la función tiempoProceso

// cuando el elevador se encuentra en movimiento, determina si se debe detener
void Elevador::procesaPosibleLlegada()
{
   // si el elevador llega al piso de destino
   if ( tiempoActualRelojDelEdificio == tiempoLlegada ) {

      pisoActual =   // actualiza el piso actual
         ( pisoActual == Piso::PISO1 ?
           Piso::PISO2 : Piso::PISO1 );

      direccion =      // actualiza dirección
         ( pisoActual == Piso::PISO1 ? ARRIBA : ABAJO );

      cout << "el elevador llega al piso "
           << pisoActual << endl;

      // procesa la llegada a pisoActual
      llegaAlPiso( pisoActual == Piso::PISO1 ?
         refPiso1 : refPiso2 );

      return;

   } // fin de if

   // el elevador sigue en movimiento
   cout << "elevador en movimiento "
        << ( direccion == ARRIBA ? "arriba" : "abajo" ) << endl;

} // fin de la función procesaPosibleLlegada

// determina si el elevador debe moverse
void Elevador::procesaPosiblePartida()
{
   // ¿Este piso necesita servicio?
   bool pisoActualNecesitaServicio =
      pisoActual == Piso::PISO1 ?
         piso1NecesitaServicio : piso2NecesitaServicio;

   // ¿el otro piso necesita servicio?
   bool otroPisoNecesitaServicio =
      pisoActual == Piso::PISO1 ?
         piso2NecesitaServicio : piso1NecesitaServicio;

   // servicio en este piso (si es necesario)
   if ( pisoActualNecesitaServicio ) {
      llegaAlPiso( pisoActual == Piso::PISO1 ?
         refPiso1 : refPiso2 );

      return;
   }

   // servicio en el otro piso (si es necesario)
   if ( otroPisoNecesitaServicio )
      preparaParaPartir( true );

} // fin de la función procesaPosiblePartida

// llega a un piso en particular
void Elevador::llegaAlPiso( Piso& llegaAlPiso )
{
   enMovimiento = false;   // restablece el estado

   cout << "el elevador restablece su boton" << endl;
   botonElevador.restableceBoton();

   campana.suenaCampana();

   // notifica al piso que el elevador llegó
   Persona *ptrPisoPersona = llegaAlPiso.llegaElevador();

   puerta.abrePuerta(
      ptrPasajero, ptrPisoPersona, llegaAlPiso, *this );

   // ¿este piso necesita servicio?
   bool pisoActualNecesitaServicio =
      pisoActual == Piso::PISO1 ?
         piso1NecesitaServicio : piso2NecesitaServicio;

   // ¿el otro piso necesita servicio?
   bool otroPisoNecesitaServicio =
      pisoActual == Piso::PISO1 ?
         piso2NecesitaServicio : piso2NecesitaServicio;

   // si este piso no necesita servicio
   // se prepara para partir hacia el otro piso
   if ( !pisoActualNecesitaServicio )
      preparaParaPartir( otroPisoNecesitaServicio );

   else  // de lo contrario, restablece la bandera de servicio
      pisoActual == Piso::PISO1 ?
         piso1NecesitaServicio = false: piso2NecesitaServicio = false;

} // fin de la función llegaAlPiso

// solicita servicio del elevador
void Elevador::llamaElevador( int piso )
{
   // establece la bandera de servicio apropiada
   piso == Piso::PISO1 ?
      piso1NecesitaServicio = true : piso2NecesitaServicio = true;

} // fin de la función llamaElevador

// acepta un pasajero
void Elevador::pasajeroEntra( Persona * const ptrPersona )
{
   // el pasajero aborda
   ptrPasajero = ptrPersona;

   cout << "persona " << ptrPasajero->obtieneID()
        << " entra al elevador desde el piso "
        << pisoActual << endl;

} // fin de la función pasajeroEntra

// notifica al elevador que el pasajero va a salir
void Elevador::pasajeroSale()
{
   ptrPasajero = 0;

} // fin de la función pasajeroSale

// se prepara para abandonar el piso
void Elevador::preparaParaPartir( bool parte )
{
   // obtiene la referencia al piso actual
   Piso &estePiso =
      pisoActual == Piso::PISO1 ? refPiso1 : refPiso2;

   // notifica al piso que el elevador puede partir
   estePiso.elevadorParte();

   puerta.cierraPuerta( estePiso );

   if ( parte )  // parte, si es necesario
      mover();

} // fin de la función preparaParaPartir

// va al otro piso
void Elevador::mover()
{
   enMovimiento = true;  // cambiar estado

   // programa tiempo llegada
   tiempoLlegada = tiempoActualRelojDelEdificio +
      TIEMPO_VIAJE_ELEVADOR;

   cout << "el elevador comienza a moverse "
        << ( direccion == ABAJO ? "abajo " : "arriba " )
        << "al piso "
        << ( direccion == ABAJO ? '1' : '2' )
        << " (llega a tiempo " << tiempoLlegada << ')'
        << endl;

} // fin de la función mueve

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
