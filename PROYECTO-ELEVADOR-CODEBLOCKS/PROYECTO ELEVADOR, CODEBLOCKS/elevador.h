// Fig. 7.41: elevador.h
// Definici�n de la clase Elevador.
#ifndef ELEVADOR_H
#define ELEVADOR_H

#include "botonElevador.h"
#include "puerta.h"
#include "campana.h"

class Piso;     // declaraci�n forward
class Persona;  // declaraci�n forward

class Elevador {

public:
   Elevador( Piso &, Piso & );    // constructor
   ~Elevador();                   // destructor

   void llamaElevador( int );     // solicitud de servicio al piso
   void preparaParaPartir( bool ); // prepara para partir
   void tiempoProceso( int );      // indica el tiempo actual al elevador
   void pasajeroEntra( Persona * const ); // aborda un pasajero
   void pasajeroSale();          // sale un pasaero

   // objeto p�blico accesible al c�digo cliente
   // con acceso al objeto Elevador
   BotonElevador botonElevador;

private:

   // funciones de utilidad
   void procesaPosibleLlegada();
   void procesaPosiblePartida();
   void llegaAlPiso( Piso & );
   void mover();

   // constantes est�ticas que representan el tiempo requerido para viajar
   // entre los pisos y las direcciones del elevador
   static const int TIEMPO_VIAJE_ELEVADOR;  
   static const int ARRIBA;                    
   static const int ABAJO;                  

   // datos miembros
   int tiempoActualRelojDelEdificio;  // tiempo actual
   bool enMovimiento;                 // estado del elevador
   int direccion;                     // direcci�n actual
   int pisoActual;                    // ubicaci�n actual
   int tiempoLlegada;                  // tiempo de llegada al piso
   bool piso1NecesitaServicio;        // bandera de servicio del piso1
   bool piso2NecesitaServicio;        // bandera de servicio del piso1

   Piso &refPiso1;                // referencia al piso 1
   Piso &refPiso2;                // referencia al piso 2

   Persona *ptrPasajero;

   Puerta puerta;                     // objeto puerta
   Campana campana;                   // objeto campana

}; // fin de la clase Elevador

#endif // ELEVADOR_H

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
