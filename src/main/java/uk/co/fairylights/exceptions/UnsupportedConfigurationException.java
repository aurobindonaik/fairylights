package uk.co.fairylights.exceptions;

/**
 * Created by aurobindo on 03/06/2018.
 */
public class UnsupportedConfigurationException extends Exception {
    private final String message;

    public UnsupportedConfigurationException(String message) {
        super(message);
        this.message = message;
    }
}
