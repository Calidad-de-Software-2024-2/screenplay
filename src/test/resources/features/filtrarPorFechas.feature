# language: es

Característica: Filtrar vuelos por rango de fechas

  Escenario: Buscar vuelos de una aerolinea especifica
    Dado la usuaria se conecta al servicio
    E ingresa el nombre de la aerolinea "JetFly"
    Cuando se realiza la busqueda de vuelos por nombre de aerolinea
    Entonces se muestra una lista de vuelos de "JetFly"

  Escenario: Filtrar por rango de fechas solo si no se seleccionan fechas de vuelo en la busqueda 
    Dado que el usuario esta en la pagina de busqueda de vuelos 
    Y el usuario ha ingresado solo el origen y el destino 
    Cuando el usuario intenta filtrar por rango de fechas 
    Entonces el sistema permite seleccionar un rango de fechas 
    Pero si el usuario ha seleccionado fechas específicas en la búsqueda 
    Entonces el sistema no permite filtrar por rango de fechas

  Escenario: Validación de que la fecha del rango no sea anterior a la fecha actual 
    Dado que el usuario está seleccionando un rango de fechas para la búsqueda 
    Cuando el usuario selecciona una fecha que es anterior a la fecha actual 
    Entonces el sistema muestra un mensaje de error indicando que no se pueden seleccionar fechas pasadas

  Escenario: Validación de que la fecha máxima no sea anterior a la fecha mínima 
    Dado que el usuario está ingresando un rango de fechas 
    Cuando la fecha máxima del rango es anterior a la fecha mínima 
    Entonces el sistema muestra un mensaje de error indicando que la fecha máxima no puede ser anterior a la fecha mínima
  
  Escenario: Mensaje de "no hay vuelos disponibles" si no hay vuelos en el rango seleccionado 
    Dado que el usuario ha ingresado un rango de fechas para la busqueda
    Cuando no hay vuelos disponibles en las fechas seleccionadas
    Entonces el sistema debe mostrar un mensaje indicando "No hay vuelos disponibles en el rango de fechas seleccionado"
