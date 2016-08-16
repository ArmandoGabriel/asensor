// Fig. 7.24: simuladorElevador.cpp
// Controlador del simulador.
#include <iostream>

using std::cout;
using std::cin;
using std::endl;

#include "edificio.h"  // Definición de la clase Edificio

int main()
{
   int duracion;  // longitud de la simulación en segundos

   cout << "Introduzca tiempo de ejecucion: ";
   cin >> duracion;
   cin.ignore();       // ignora el carácter devuelto

   Edificio edificio;  // crea el edificio

   cout << endl << "*** COMIENZA LA SIMULACION DEL ELEVADOR ***"
        << endl << endl;

   edificio.ejecutaSimulador( duracion );  // comienza la simulación

   cout << "*** TERMINA LA SIMULACION DEL ELEVADOR ***" << endl;

   return(0);
} // fin de main

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
