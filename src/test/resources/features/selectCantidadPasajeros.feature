# language: es

Característica: Seleccionar cantidad de pasajeros

Escenario: Validacion de al menos un pasajero seleccionado 
Dado que el usuario esta en la pagina de busqueda de vuelos 
Cuando el usuario intenta proceder con la busqueda 
Entonces el sistema valida que al menos un pasajero sea seleccionado

Escenario: Limite de numero maximo de pasajeros 
Dado que el usuario esta seleccionando pasajeros para la busqueda 
Cuando el usuario intenta seleccionar mas de 8 pasajeros en total 
Entonces el sistema no permite seleccionar mas de 8 pasajeros
