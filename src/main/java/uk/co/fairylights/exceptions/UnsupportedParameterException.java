package uk.co.fairylights.exceptions;

/**
 * Created by aurobindo on 03/06/2018.
 */
public class UnsupportedParameterException extends Exception {
    private String message;
    public UnsupportedParameterException(String message) {
        super(message);
        this.message = message;
    }
}
