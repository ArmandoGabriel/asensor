// Fig. 7.27: reloj.h
// Definición de la clase Reloj.
#ifndef RELOJ_H
#define RELOJ_H

class Reloj {

public:
   Reloj();                    // constructor
   ~Reloj();                   // destructor
   void marcaSeg();            // incrementa el reloj un segundo
   int obtieneTiempo() const;  // devuelve el tiempo actual del reloj

private:
   int tiempo;            // tiempo del reloj

}; // fin de la clase Reloj

#endif // RELOJ_H

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
