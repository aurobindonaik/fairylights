package uk.co.fairylights.algorithms;

import uk.co.fairylights.model.Colour;
import uk.co.fairylights.model.Light;

import java.util.List;

/**
 * Created by aurobindo on 04/06/2018.
 */
public class ColourAlgorithm extends AbstractAlgorithm {

    public ColourAlgorithm(List<Light> lights, List<Colour> colours, double seconds) {
        super(lights, colours, seconds);
    }

    @Override
    public void run() {
        for (Colour colour : colours) {
            lights.stream()
                    .filter(light -> colour.equals(light.getColour()))
                    .forEach(light -> light.turnOn());

            delay(new Double(seconds * DELAY_MULTIPLY).longValue());

            lights.stream()
                    .filter(light -> colour.equals(light.getColour()))
                    .forEach(light -> light.turnOff());
        }
    }
}
