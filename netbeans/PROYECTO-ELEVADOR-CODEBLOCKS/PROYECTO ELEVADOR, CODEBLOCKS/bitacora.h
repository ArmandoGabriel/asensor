// Fig. 7.29: bitacora.h
// Definición de la clase Bitacora.
#ifndef BITACORA_H
#define BITACORA_H

class Piso;                        // declaración forward 

class Bitacora {

public:
   Bitacora( Piso &, Piso & );   // constructor 
   ~Bitacora();                  // destructor
   void tiempoProceso( int );    // establece el tiempo de la bitácora

private:
	// tiempo de la bitácora de llegada a piso
   void programaTiempo( const Piso & );

   // tiempo de retardo de llegada a piso
   void tiempoRetardo( const Piso & );

   // crea nueva persona; la coloca en el piso
   void creaNuevaPersona( Piso & );   
   
   // manipulador de llegada de la persona a un piso
   void manipulaLlegadas( Piso &, int );   

   int tiempoActualDeReloj;

   Piso &refPiso1;
   Piso &refPiso2;

   int tiempoLlegadaPiso1;
   int tiempoLlegadaPiso2;

}; // fin de la clase Bitacora

#endif // BITACORA_H

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
