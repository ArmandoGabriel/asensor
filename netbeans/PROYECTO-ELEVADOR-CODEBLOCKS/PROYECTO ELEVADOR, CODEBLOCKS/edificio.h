// Fig. 7.25: edificio.h
// Definición de la clase Edificio.
#ifndef EDIFICIO_H
#define EDIFICIO_H

#include "elevador.h"  // definición de la clase Elevador
#include "piso.h"      // definición de la clase Piso
#include "reloj.h"     // definición de la clase Reloj
#include "bitacora.h"  // definición de la clase Bitacora

class Edificio {

public:
   Edificio();                   // constructor
   ~Edificio();                  // destructor
   void ejecutaSimulador( int ); // controla la simulación

private:
   Piso piso1;               // objeto piso1
   Piso piso2;               // objeto piso2
   Elevador elevador;        // objeto elevador
   Reloj reloj;              // objeto  reloj
   Bitacora bitacora;        // objeto bitacora

}; // fin de la clase Edificio

#endif // EDIFICIO_H

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

