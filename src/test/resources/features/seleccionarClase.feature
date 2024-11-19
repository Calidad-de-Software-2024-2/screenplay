# language: es

Característica: Seleccionar clase de vuelo

Escenario: Seleccion de clase en la interfaz de busqueda 
Dado que el usuario esta en la pagina de busqueda de vuelos 
Cuando el usuario abre la lista desplegable de clases 
Entonces el sistema permite al usuario elegir entre clase economica, primera clase u otras clases definidas

Escenario: Visualizacion de restricciones y beneficios al seleccionar una clase 
Dado que el usuario esta seleccionando una clase de vuelo 
Cuando el usuario selecciona una opcion de clase 
Entonces el sistema muestra los detalles de la clase seleccionada, como restricciones y beneficios, 
Y los muestra en una seccion de ayuda o en un tooltip
