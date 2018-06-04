package uk.co.fairylights.model;

/**
 * Created by aurobindo on 03/06/2018.
 */
public class Light {
    private int index;
    private Colour colour;
    private boolean on;


    public Light(int index, Colour colour, boolean on) {
        this.index = index;
        this.colour = colour;
        this.on = on;
    }

    public Light(int index, Colour colour) {
        this.index = index;
        this.colour = colour;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Colour getColour() {
        return colour;
    }

    public void setColour(Colour colour) {
        this.colour = colour;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public void turnOn() {
        setOn(true);
        System.out.println(this);
    }

    public void turnOff() {
        setOn(false);
        System.out.println(this);
    }

    @Override
    public String toString() {
        return String.format("Light %s %s %s", getIndex()+1, getColour().getColour(), (isOn()?"On.":"Off."));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Light light = (Light) o;

        if (index != light.index) return false;
        if (on != light.on) return false;
        return colour.equals(light.colour);
    }

    @Override
    public int hashCode() {
        int result = index;
        result = 31 * result + colour.hashCode();
        result = 31 * result + (on ? 1 : 0);
        return result;
    }
}
