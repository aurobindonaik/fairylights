package uk.co.fairylights.algorithms;

import uk.co.fairylights.model.Colour;
import uk.co.fairylights.model.Light;

import java.util.List;

/**
 * Created by aurobindo on 04/06/2018.
 */
public class AlternateAlgorithm extends AbstractAlgorithm {
    private List<Colour> displayColours;
    public AlternateAlgorithm(List<Light> lights, List<Colour> colours, List<Colour> displayColours, double seconds) {
        super(lights, colours, seconds);
        this.displayColours = displayColours;
    }

    @Override
    public void run() {
        //Run the sequence algorithm for 30 seconds
        AbstractAlgorithm seqAlg = new SequenceAlgorithm(lights, colours, 0.5);
        seqAlg.run();

        //Sleep for the duration till this task is running.
        delay(new Double(seconds*DELAY_MULTIPLY).longValue());

        //Run the Colour algorithm for 30 seconds
        AbstractAlgorithm colAlg = new ColourAlgorithm(lights, displayColours, 1);
        colAlg.run();
    }
}
