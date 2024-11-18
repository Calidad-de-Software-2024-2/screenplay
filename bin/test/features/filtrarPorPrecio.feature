# language: es

Característica: Filtrar vuelos por rango de precios

Escenario: Formato de entrada numérica para el rango de precios 
Dado que el usuario está en la página de búsqueda de vuelos 
Cuando el usuario ingresa un valor en los campos de precio mínimo y precio máximo 
Entonces el sistema debe mostrar campos separados para el precio mínimo y el precio máximo Y debe aceptar solo valores numéricos

Escenario: Validación de que el precio mínimo no sea mayor que el precio máximo 
Dado que el usuario ha ingresado un valor en el campo de precio mínimo 
Y el usuario ha ingresado un valor en el campo de precio máximo 
Cuando el precio mínimo es mayor que el precio máximo 
Entonces el sistema debe mostrar un mensaje de error indicando que el precio mínimo no puede ser mayor que el precio máximo
