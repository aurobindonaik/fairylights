package uk.co.fairylights.algorithms;

import uk.co.fairylights.model.Colour;
import uk.co.fairylights.model.Light;

import java.util.List;

/**
 * Created by aurobindo on 04/06/2018.
 */
public abstract class AbstractAlgorithm {
    protected final long DELAY_MULTIPLY = 1000;

    protected List<Light> lights;
    protected List<Colour> colours;
    protected double seconds;

    public abstract void run();

    public AbstractAlgorithm(List<Light> lights, List<Colour> colours, double seconds) {
        super();
        this.lights = lights;
        this.colours = colours;
        this.seconds = seconds;
    }

    public void delay(long delayMilliSeconds){
        try{
            Thread.sleep(delayMilliSeconds);
        }catch (InterruptedException ex){
            Thread.currentThread().interrupt();
        }
    }
}
