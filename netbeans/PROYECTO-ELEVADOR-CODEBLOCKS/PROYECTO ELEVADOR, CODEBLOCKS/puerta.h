// Fig. 7.35: puerta.h
// Definición de la clase Puerta.
#ifndef PUERTA_H
#define PUERTA_H

class Persona;  // declaración forward
class Piso;     // declaración forward
class Elevador; // declaración forward

class Puerta {

public:
   Puerta();       // constructor
   ~Puerta();      // destructor
  
   void abrePuerta( Persona * const,             // abre la puerta
		Persona * const, Piso &, Elevador & );
   void cierraPuerta( const Piso & );           // cierra la puerta
   
private:
   bool abierta;    // abierto o cerrado

};

#endif // PUERTA_H

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
