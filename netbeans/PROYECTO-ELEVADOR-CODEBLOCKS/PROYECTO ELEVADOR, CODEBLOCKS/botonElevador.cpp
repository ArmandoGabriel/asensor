// Fig. 7.38: BotonElevador.cpp:
// Definición de las funciones miembro para la clase BotonElevador.
#include <iostream>

using std::cout;
using std::endl;

#include "botonElevador.h"  // definición de la clase BotonElevador
#include "elevador.h"       // definición de la clase Elevador

// constructor
BotonElevador::BotonElevador( Elevador &manipulaElevador )
   : presionado( false ),
     refElevador( manipulaElevador )
{
   cout << "boton del elevador construido" << endl;

} // fin del constructor BotonElevador

// destructor
BotonElevador::~BotonElevador()
{
   cout << "boton del elevador destruido" << endl;

} // fin del destructor ~BotonElevador

// presiona el botón e indica al elevador que se prepare para abandonar el piso
void BotonElevador::presionaBoton()
{
   presionado = true;
   cout << "el boton del elevador le indica al elevador que se prepare para partir"
        << endl;
   refElevador.preparaParaPartir( true );

} // fin de la función presionaBoton

// restablece el botón
void BotonElevador::restableceBoton()
{
   presionado = false;

} // fin de la función restableceBoton

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
