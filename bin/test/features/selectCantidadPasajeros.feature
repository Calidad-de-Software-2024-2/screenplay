# language: es

Característica: Seleccionar cantidad de pasajeros

Escenario: Seleccion de la cantidad de pasajeros por tipo 
Dado que el usuario está en la pagina de búsqueda de vuelos 
Cuando el usuario selecciona la cantidad de pasajeros para cada tipo (adulto, menor de edad y/o otros definidos) 
Entonces el sistema debe permitir al usuario seleccionar la cantidad de pasajeros por cada tipo definido

Escenario: Validacion de al menos un pasajero seleccionado 
Dado que el usuario esta en la pagina de busqueda de vuelos 
Cuando el usuario intenta proceder con la busqueda 
Entonces el sistema valida que al menos un pasajero sea seleccionado

Escenario: Limite de numero maximo de pasajeros 
Dado que el usuario esta seleccionando pasajeros para la busqueda 
Cuando el usuario intenta seleccionar mas de 8 pasajeros en total 
Entonces el sistema no permite seleccionar mas de 8 pasajeros entre todas las categorias definidas

Escenario: Persistencia de seleccion de pasajeros durante la sesion 
Dado que el usuario ha seleccionado la cantidad de pasajeros 
Cuando el usuario navega a otra parte del proceso de busqueda 
Y el usuario regresa a la seleccion de pasajeros
