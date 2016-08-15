// Fig. 7.33: luz.h
// definición de la clase Luz.
#ifndef LUZ_H
#define LUZ_H

class Luz {

public:
   Luz( int );    // constructor 
   ~Luz();        // destructor

   void enciende(); // enciende la luz
   void apaga();    // apaga la luz

private:
   bool encendida;         // verdadero si está encendida; falso si está apagada
   const int numeroPiso;   // número del piso que contiene la luz

}; // fin de la clase Luz

#endif // LUZ_H

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
