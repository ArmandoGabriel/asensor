// Fig. 7.28: reloj.cpp
// Definición de las funciones miembro para la clase Reloj
#include <iostream>

using std::cout;
using std::endl;

#include "reloj.h"  // Definición de la clase Reloj

// constructor
Reloj::Reloj()             
   : tiempo( 0 )  // inicializa tiempo en 0
{ 
   cout << "reloj construido" << endl; 

} // fin del constructor Reloj

// destructor
Reloj::~Reloj()            
{ 
   cout << "reloj destruido" << endl; 

} // fin del destructor ~Reloj 

// incrementa el tiempo en 1
void Reloj::marcaSeg()         
{ 
   tiempo++; 

} // fin de la función marcaSeg

// devuelve el tiempo actual
int Reloj::obtieneTiempo() const 
{ 
   return tiempo; 

} // fin de la función obtieneTiempo

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
