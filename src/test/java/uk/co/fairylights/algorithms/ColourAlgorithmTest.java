package uk.co.fairylights.algorithms;

import org.junit.Before;
import org.junit.Test;
import uk.co.fairylights.model.Colour;
import uk.co.fairylights.model.ColourFactory;
import uk.co.fairylights.model.Light;
import uk.co.fairylights.model.LightFactory;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by aurobindo on 04/06/2018.
 */
public class ColourAlgorithmTest extends AlgorithmBaseTest{

    @Before
    public void setUp() throws Exception {
        algorithm = new ColourAlgorithm(lights, colours, seconds);
    }

    @Test
    public void all_red_colour_lights_are_on_for_1sec_followed_by_green_and_then_white() throws Exception {
        StringBuilder str = new StringBuilder();
        str.append("Light 1 Red On.").append(NEW_LINE);
        str.append("Light 4 Red On.").append(NEW_LINE);
        str.append("Light 1 Red Off.").append(NEW_LINE);
        str.append("Light 4 Red Off.").append(NEW_LINE);
        str.append("Light 2 Green On.").append(NEW_LINE);
        str.append("Light 5 Green On.").append(NEW_LINE);
        str.append("Light 2 Green Off.").append(NEW_LINE);
        str.append("Light 5 Green Off.").append(NEW_LINE);
        str.append("Light 3 White On.").append(NEW_LINE);
        str.append("Light 3 White Off.").append(NEW_LINE);

        algorithm.run();

        assertEquals(str.toString(), outContent.toString());
    }
}