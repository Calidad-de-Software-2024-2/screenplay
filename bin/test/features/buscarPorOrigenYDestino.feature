# language: es
Característica: Busqueda por origen y destino

  Escenario: Busqueda de vuelos por origen y destino
    Dado que el usuario esta en la pagina de busqueda de vuelos
    Y ha rellenado los demás campos necesarios
    Cuando el usuario selecciona un origen y destino
    Y procede con la búsqueda
    Entonces el sistema muestra los vuelos disponibles para el origen y destino seleccionados

  Escenario: Validacion de que se seleccione un origen y destino
    Dado que el usuario esta en la pagina de busqueda de vuelos
    Y ha rellenado los demás campos necesarios
    Cuando el usuario intenta proceder con la busqueda sin seleccionar un origen y destino
    Entonces el sistema muestra un mensaje de error indicando que se debe seleccionar un origen y destino
