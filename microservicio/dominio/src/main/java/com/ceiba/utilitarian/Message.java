package com.ceiba.utilitarian;

public final class Message
{
    private Message()
    {

    }

    public static final String LOWER_NUMBER_OF_GUESTS_INVALID = "Number of guests cannot be less than or equal to zero.";
    public static final String NUMBER_OF_STARS_INVALID = "Number of stars cannot be less than one or greater than five.";
    public static final String UPPER_NUMBER_OF_GUESTS_INVALID = "Number of guests cannot be greater than ";
    public static final String CITY_CANNOT_BE_EMPTY = "Name of city cannot be empty.";
    public static final String INVALID_CITY_LENGTH = "Length of city has to be between 1 and 89 characters";
    public static final String COUNTRY_CANNOT_BE_EMPTY = "Name of country cannot be empty.";
    public static final String INVALID_COUNTRY_LENGTH = "Length of country has to be between 1 and 48 characters";
    public static final String INVALID_DATE_PATTERN = "Date has not the pattern dd/mm/yyyy";
    public static final String CHECKIN_CANNOT_BE_LESS_THAN_TODAY = "Check in date cannot be lees than current date";
    public static final String CHECKOUT_CANNOT_BE_LESS_THAN_OR_EQUAL_CHECKIN = "Check out date cannot be lees than or equal check in date";
    public static final String RESERVATION_DOES_NOT_EXISTS_WITH_ID = "There is no reservation on id ";
    public static final String THERE_IS_NOT_RESERVATIONS = "There is no reservations on app ";
}