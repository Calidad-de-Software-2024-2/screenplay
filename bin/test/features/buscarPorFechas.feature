# language: es
Característica: Buscar vuelos por rango de fechas

  Escenario: Validación de que la fecha máxima no sea anterior a la fecha mínima
    Dado que el usuario está ingresando un rango de fechas para la búsqueda donde la fecha maxima es anterior a la fecha mínima
    Cuando el usuario hace clic en buscar
    Entonces el sistema muestra un mensaje de error indicando que la fecha máxima no puede ser anterior a la fecha mínima

  Escenario: Mensaje de "no hay vuelos disponibles" si no hay vuelos en el rango seleccionado
    Dado que el usuario ha ingresado un rango de fechas para la búsqueda
    Cuando el usuario hace clic en buscar
    Entonces el sistema debe mostrar un mensaje indicando que no hay vuelos disponibles en el rango de fechas seleccionado
