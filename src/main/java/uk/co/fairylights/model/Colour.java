package uk.co.fairylights.model;

/**
 * Created by aurobindo on 03/06/2018.
 */
public class Colour {
    private String colour;

    public Colour(String colour) {
        this.colour = colour;
    }

    public String getColour() {
        return colour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Colour colour1 = (Colour) o;

        return colour.equals(colour1.colour);
    }

    @Override
    public int hashCode() {
        return colour.hashCode();
    }
}
