# language: es
Característica: Filtrar vuelos por rango de precios

  Escenario: Filtrado exitoso de vuelos por rango de precios
    Dado que el usuario ha realizado una busqueda que arroje resultados
    Cuando el usuario filtra por un rango de precios
    Entonces el sistema debe mostrar solo los vuelos que estén dentro del rango de precios seleccionado
  
  Escenario: No hay vuelos disponibles dentro del rango de precios seleccionado
    Dado que el usuario ha realizado una busqueda que arroje resultados
    Cuando el usuario filtra por un rango de precios que no tiene vuelos disponibles
    Entonces el sistema debe mostrar un mensaje indicando que no hay vuelos disponibles en el rango seleccionado