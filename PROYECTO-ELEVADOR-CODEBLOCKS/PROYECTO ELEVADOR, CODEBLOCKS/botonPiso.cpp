// Fig. 7.40: botonPiso.cpp
// Definición de las funciones miembro para la clase BotonPiso.
#include <iostream>

using std::cout;
using std::endl;

#include "botonPiso.h"
#include "elevador.h"

// constructor
BotonPiso::BotonPiso( int piso, Elevador &manipulaElevador )
   : numeroPiso( piso ), 
     presionado( false ), 
     refElevador( manipulaElevador ) 
{ 
   cout << "boton del piso " << numeroPiso << " construido"
        << endl; 

} // fin del constructor BotonPiso

// destructor
BotonPiso::~BotonPiso() 
{
   cout << "boton del piso " << numeroPiso << " destruido"
        << endl;

} // fin del destructor ~BotonPiso

// presiona el boton
void BotonPiso::presionaBoton()
{
   presionado = true;
   cout << "boton del piso " << numeroPiso 
        << " llama al elevador" << endl;

   // llama al elevador a este piso
   refElevador.llamaElevador( numeroPiso ); 

} //fin de la función presionaBoton

// restablece el botón
void BotonPiso::restableceBoton() 
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
