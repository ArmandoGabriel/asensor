// Fig. 7.37: botonElevador.h
// definición de la clase BotonElevador.
#ifndef BOTONELEVADOR_H
#define BOTONELEVADOR_H

class Elevador;  // declaración forward

class BotonElevador {

public:
   BotonElevador( Elevador & );  // constructor
   ~BotonElevador();             // destructor

   void presionaBoton();         // presiona el botón
   void restableceBoton();       // restablece el botón

private:
   bool presionado;                  // estado del botón

   // referencia al elevador que contiene este botón
   Elevador &refElevador;  

}; // fin de la clase BotonElevador

#endif // BOTONELEVADOR_H

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
