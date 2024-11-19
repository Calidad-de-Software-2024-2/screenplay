# language: es

Característica: Seleccionar clase de vuelo

Escenario: Selección de clase en la interfaz de búsqueda 
  Dado el usuario abre la lista desplegable de clases
  Cuando el usuario selecciona una clase de vuelo "business"
  Entonces el sistema cambia el vuelo a la clase seleccionada

Escenario: Visualización de restricciones y beneficios al seleccionar una clase 
  Dado el usuario abre la lista desplegable de clases
  Cuando el usuario selecciona la opcion de "first class"
  Entonces el sistema muestra los detalles de la clase seleccionada, como restricciones y beneficios

