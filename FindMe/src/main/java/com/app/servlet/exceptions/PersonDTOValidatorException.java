package com.app.servlet.exceptions;

/**
 * Created by apavliuchenkova on 25/11/2016.
 */
public class PersonDTOValidatorException extends Exception implements ExceptionLog {

    public PersonDTOValidatorException(String message) {
        super(message);
    }

    @Override
    public void logException(Exception ex) {
        /*put exception to file of log*/
    }
}
