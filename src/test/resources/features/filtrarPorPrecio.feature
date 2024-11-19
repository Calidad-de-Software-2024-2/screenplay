# language: es

Característica: Filtrar vuelos por rango de precios

Escenario: Formato de entrada numérica para el rango de precios 
Dado que el usuario está en la página de búsqueda de vuelos 
Cuando el usuario ingresa un valor en los campos de precio mínimo y precio máximo 
Entonces el sistema debe mostrar campos separados para el precio mínimo y el precio máximo Y debe aceptar solo valores numéricos
