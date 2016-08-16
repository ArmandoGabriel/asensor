// Fig. 7.39: BotonPiso.h
// Definición de la clase BotonPiso.
#ifndef BOTONPISO_H
#define BOTONPISO_H

class Elevador;  // declaración forward

class BotonPiso {

public:
    BotonPiso( int, Elevador & );  // constructor
   ~BotonPiso();                   // destructor

   void presionaBoton();   // presiona el botón
   void restableceBoton(); // restablece el botón

private:
   const int numeroPiso;  // número de piso del botón
   bool presionado;       // estado del botón 
   
   // referencia al elevador utilizado para llamar
   // al elevado al piso
   Elevador &refElevador;

}; // fin de la clase botonPiso

#endif // BOTONPISO_H

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
