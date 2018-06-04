package uk.co.fairylights.algorithms;

import org.junit.Before;
import org.junit.Test;
import uk.co.fairylights.model.Colour;
import uk.co.fairylights.model.Light;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by aurobindo on 04/06/2018.
 */
public class AbstractAlgorithmTest {

    private AbstractAlgorithm algorithm;

    @Before
    public void setUp() throws Exception {
        List<Light> lights = new ArrayList<Light>();
        List<Colour> colours = new ArrayList<Colour>();
        double seconds = 0d;
        algorithm = new StubAlgorithm(lights, colours, seconds);
    }

    @Test(timeout = 1080)
    public void delay_should_delay_by_given_milli_seconds() throws Exception {
        long start = System.currentTimeMillis();
        algorithm.delay(1000);
        long end = System.currentTimeMillis();
        assertTrue("Should Sleep for one Sec.", (end - start) > 999);
    }

    class StubAlgorithm extends AbstractAlgorithm{

        public StubAlgorithm(List<Light> lights, List<Colour> colours, double seconds) {
            super(lights, colours, seconds);
        }

        @Override
        public void run() {
            //Just a stub do nothing
        }
    }
}