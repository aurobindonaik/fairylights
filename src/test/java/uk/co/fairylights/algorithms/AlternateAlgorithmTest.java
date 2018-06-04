package uk.co.fairylights.algorithms;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by aurobindo on 04/06/2018.
 */
public class AlternateAlgorithmTest extends AlgorithmBaseTest{
    @Before
    public void setUp() throws Exception {
        algorithm = new AlternateAlgorithm(lights, colours, colours, seconds);
    }

    @Test
    public void the_sequence_algorithm_runs_for_30_seconds_then_the_alternate_algorithm_runs_for_30_seconds() throws Exception {
        StringBuilder str = new StringBuilder();
        str.append("Light 1 Red On.").append(NEW_LINE);
        str.append("Light 1 Red Off.").append(NEW_LINE);
        str.append("Light 2 Green On.").append(NEW_LINE);
        str.append("Light 2 Green Off.").append(NEW_LINE);
        str.append("Light 3 White On.").append(NEW_LINE);
        str.append("Light 3 White Off.").append(NEW_LINE);
        str.append("Light 4 Red On.").append(NEW_LINE);
        str.append("Light 4 Red Off.").append(NEW_LINE);
        str.append("Light 5 Green On.").append(NEW_LINE);
        str.append("Light 5 Green Off.").append(NEW_LINE);
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