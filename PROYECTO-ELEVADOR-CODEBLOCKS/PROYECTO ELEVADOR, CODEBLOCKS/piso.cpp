// Fig. 7.44: piso.cpp
// Definición de las funciones miembro para la clase Piso.
#include <iostream>

using std::cout;
using std::endl;

#include "piso.h"     // definición de la clase Piso
#include "persona.h"  // definición de la clase Persona
#include "elevador.h" // definición de la clase Elevador
#include "puerta.h"   // definición de la clase Puerta

// constantes estáticas que representan los números de los pisos
const int Piso::PISO1 = 1;
const int Piso::PISO2 = 2;

// constructor
Piso::Piso(int numero, Elevador &manipulaElevador ) //HASTA AQUI REVISE GABRIEL
   : botonPiso( numero, manipulaElevador ),
     numeroPiso( numero ),
     refElevador( manipulaElevador ),
     ptrOcupante ( 0 ),
     luz( numeroPiso )
{
   cout << "piso " << numeroPiso << " construido" << endl;

} // fin del constructor Piso

// destructor
Piso::~Piso()
{
   delete ptrOcupante;
   cout << "piso " << numeroPiso << " destruido" << endl;

} // fin del destrcutor ~Piso

// determina si el piso está ocupado
bool Piso::estaOcupado() const
{
   return ( ptrOcupante != 0 );

} // fin de la función estaOcupado

// devuelve el número de este piso
int Piso::obtieneNumero() const
{
   return numeroPiso;

} // fin de la función obtieneNumero

// la persona llega al piso
void Piso::llegaPersona( Persona * const ptrPersona )
{
   ptrOcupante = ptrPersona;

} // fin de la función llegaPersona

// notifica al piso que el elevador llegó
Persona *Piso::llegaElevador()
{
   cout << "piso " << numeroPiso
        << " restablece su boton" << endl;

   botonPiso.restableceBoton();
   luz.enciende();

   return ptrOcupante;

} // fin de la función llegaElevador

// indica al piso que el elevador parte
void Piso::elevadorParte()
{
   luz.apaga();

} // fin de la función elevadorParte

// notifica al piso que la persona se va
void Piso::personaAbordaElevador()
{
   ptrOcupante = 0;  // la persona ya no se encuentra en el piso

} // fin de la función personaAbordaElevador

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
