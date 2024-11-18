# language: es

Característica: Seleccionar clase de vuelo

Escenario: Seleccion de clase en la interfaz de busqueda 
Dado que el usuario esta en la pagina de busqueda de vuelos 
Cuando el usuario abre la lista desplegable de clases 
Entonces el sistema permite al usuario elegir entre clase economica, primera clase u otras clases definidas

Escenario: Seleccion de multiples clases 
Dado que el usuario esta en la pagina de busqueda de vuelos 
Cuando el usuario selecciona varias clases en la lista desplegable 
Entonces el sistema permite buscar resultados que incluyan todas las clases seleccionadas

Escenario: Persistencia de la seleccion de clase durante la sesion 
Dado que el usuario ha realizado una busqueda previa y ha seleccionado una clase Cuando el usuario realiza una nueva busqueda durante la misma sesion 
Entonces el sistema recuerda la clase seleccionada anteriormente 
Y agiliza el proceso de busqueda

Escenario: Visualizacion de restricciones y beneficios al seleccionar una clase 
Dado que el usuario esta seleccionando una clase de vuelo 
Cuando el usuario selecciona una opcion de clase 
Entonces el sistema muestra los detalles de la clase seleccionada, como restricciones y beneficios, 
Y los muestra en una seccion de ayuda o en un tooltip
