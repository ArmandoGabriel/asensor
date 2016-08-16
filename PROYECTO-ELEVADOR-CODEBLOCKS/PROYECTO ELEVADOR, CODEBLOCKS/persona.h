// Fig. 7.45: persona.h
// Definición de la clase Persona.
#ifndef PERSONA_H
#define PERSONA_H

class Piso;     // declaración forward
class Elevador; // declaración forward

class Persona {

public:
   Persona( int );      // constructor
   ~Persona();          // destructor
   int obtieneID() const;  // devuelve el ID de la persona

   void entraAlPiso( Piso & );
   void entraElevador( Elevador &, Piso & ); 
   void saleElevador( const Piso &, Elevador & ) const;

private:
    static int cuentaPersonas;  // número total de gente
	const int ID;               // Número de ID único de la persona
    const int pisoDestino;      // número de piso de destino

}; // fin de la clase Persona

#endif // PERSONA_H

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
