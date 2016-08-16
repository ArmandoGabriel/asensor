// Fig. 7.43: piso.h
// Definici�n de la clase Piso.
#ifndef PISO_H
#define PISO_H

#include "botonPiso.h"
#include "luz.h"

class Elevador;   // declaraci�n forward 
class Persona;    // declaraci�n forward

class Piso {

public:
   Piso( int, Elevador & ); // constructor
   ~Piso();                 // destructor
   bool estaOcupado() const;  // devuelve verdadero si el piso esta ocupado
   int obtieneNumero() const;    // devuelve el n�mero de piso

   // pasa un manipulador a la una nueva persona que entra al piso
   void llegaPersona( Persona * const );

   // notifica al piso que el elevador lleg�
   Persona *llegaElevador();

   // notifica al piso que el elevador parte
   void elevadorParte();

   // notifica al piso que la persona abandona el piso
   void personaAbordaElevador();

   // constantes est�ticas que representan los n�meros de piso
   static const int PISO1;
   static const int PISO2;

   // objeto p�blico BotonPiso accesible para
   // cualquier c�digo cliente con acceso a un Piso
   BotonPiso botonPiso;   

private:
   const int numeroPiso;  // los n�meros de piso
   Elevador &refElevador; // referencia al elevador
   Persona *ptrOcupante;  // apuntador a la persona en el piso
   Luz luz;               // objeto luz
   
}; // fin de la clase Piso

#endif // PISO_H

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
