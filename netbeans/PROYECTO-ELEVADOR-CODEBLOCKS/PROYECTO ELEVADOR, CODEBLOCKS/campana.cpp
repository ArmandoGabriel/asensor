// Fig. 7.32: campana.cpp
// Definición de las funciones miembro para la clase Campana.
#include <iostream>

using std::cout;
using std::endl;

#include "campana.h"  // definición de la clase Campana

// constructor
Campana::Campana() 
{ 
   cout << "campana creada" << endl; 

} // fin del constructor Campana

// destructor
Campana::~Campana() 
{ 
   cout << "campana destruida" << endl; 

} // fin del destructor ~Campana

// suena campana
void Campana::suenaCampana() const 
{ 
   cout << "el elevador suena la campana" << endl; 

} // fin de la función suenaCampana

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
