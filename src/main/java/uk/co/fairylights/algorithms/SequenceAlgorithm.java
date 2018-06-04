package uk.co.fairylights.algorithms;

import uk.co.fairylights.model.Colour;
import uk.co.fairylights.model.Light;

import java.util.List;

/**
 * Created by aurobindo on 04/06/2018.
 */
public class SequenceAlgorithm extends  AbstractAlgorithm {

    public SequenceAlgorithm(List<Light> lights, List<Colour> colours, double seconds) {
        super(lights, colours, seconds);
    }

    @Override
    public void run() {
        for (Light light : lights) {
            light.turnOn();
            delay(new Double(seconds * DELAY_MULTIPLY).longValue());
            light.turnOff();
        }
    }
}
