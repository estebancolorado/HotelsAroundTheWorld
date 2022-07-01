package com.ceiba.utilitarian;

public final class Message
{
    private Message()
    {

    }

    public static final String LOWER_NUMBER_OF_GUESTS_INVALID = "El número de huéspedes no puede ser menor o igual que 0.";
    public static final String NUMBER_OF_STARS_INVALID = "El número de estrellas no puede ser menor que o 1 o mayor que 5.";
    public static final String UPPER_NUMBER_OF_GUESTS_INVALID = "El numero de huéspedes no puede ser mayor que ";
    public static final String CITY_CANNOT_BE_EMPTY = "El nombre de la ciudad no puede estar vació.";
    public static final String INVALID_CITY_LENGTH = "La longitud de la ciudad debe estar entre 1 y 89 caracteres.";
    public static final String COUNTRY_CANNOT_BE_EMPTY = "El nombre del pais no puede estar vació.";
    public static final String INVALID_COUNTRY_LENGTH = "La longitud del pais tiene que estar entre 1 y 48 caracteres";
    public static final String INVALID_DATE_PATTERN = "La fecha no cumple el patrón: dd/mm/yyyy";
    public static final String CHECKIN_CANNOT_BE_LESS_THAN_TODAY = "La fecha de llegada no puede ser menor que la fecha actual.";
    public static final String CHECKOUT_CANNOT_BE_LESS_THAN_OR_EQUAL_CHECKIN = "La fecha de salida no puede ser menor o igual que la fecha de llegada.";
    public static final String RESERVATION_DOES_NOT_EXISTS_WITH_ID = "No hay reservaciones con el id ";
    public static final String THERE_IS_NOT_RESERVATIONS = "No hay reservaciones en la aplicación";
}