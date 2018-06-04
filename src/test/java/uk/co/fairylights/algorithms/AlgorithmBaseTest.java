package uk.co.fairylights.algorithms;

import org.junit.After;
import org.junit.Before;
import uk.co.fairylights.model.Colour;
import uk.co.fairylights.model.Light;
import uk.co.fairylights.model.LightFactory;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

/**
 * Created by aurobindo on 04/06/2018.
 */
public class AlgorithmBaseTest {

    protected final String NEW_LINE = "\n";
    protected final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    protected PrintStream original = System.out;
    protected List<Light> lights;
    protected List<Colour> colours;
    protected double seconds = 0;

    protected AbstractAlgorithm algorithm;

    @Before
    public void setUpSuper() throws Exception {
        colours = Arrays.asList(new Colour("Red"), new Colour("Green"), new Colour("White"));
        lights = LightFactory.createLights("5", colours);
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void tearDownSuper() throws Exception {
        algorithm = null;
        System.setOut(original);
    }
}
