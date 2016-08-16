// Fig. 7.34: luz.cpp
// Definición de las funciones miembro para la clase Luz.
#include <iostream>

using std::cout;
using std::endl;

#include "luz.h"  // definición de la clase Luz

// constructor
Luz::Luz( int numero ) 
   : encendida( false ), 
     numeroPiso( numero )
{ 
   cout << "piso " << numeroPiso << " luz construida" 
        << endl;

} // fin del constructor Luz

// destuctor
Luz::~Luz() 
{ 
   cout << "piso " << numeroPiso 
        << " luz destruida" << endl;

} // fin del destructor ~Luz

// enciende la luz
void Luz::enciende() 
{ 
   if ( !encendida ) {  // si la luz no está encendida, la enciende
      encendida = true; 
      cout << "piso " << numeroPiso 
           << " se enciende la luz" << endl;

   } // fin de if

} // fin de la función enciende

// apaga la luz
void Luz::apaga() 
{ 
   if ( encendida ) {  // si la luz está encendida, la apaga
      encendida = false; 
      cout << "piso " << numeroPiso 
           << " se apaga la luz" << endl;

   } // fin de if

} // fin de la función apaga

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
