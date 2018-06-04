package uk.co.fairylights.model;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import uk.co.fairylights.exceptions.UnsupportedConfigurationException;
import uk.co.fairylights.exceptions.UnsupportedParameterException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by aurobindo on 03/06/2018.
 */
public class LightFactoryTest {

    private List<Colour> givenColours;
    private List<Light> expectedLightList;

    @Before
    public void setUp() throws Exception {
        givenColours = Arrays.asList(getRandomColour(), getRandomColour(), getRandomColour(),
                getRandomColour(), getRandomColour());
        expectedLightList = Arrays.asList(new Light(0, givenColours.get(0)),
                new Light(1, givenColours.get(1)),
                new Light(2, givenColours.get(2)),
                new Light(3, givenColours.get(3)),
                new Light(4, givenColours.get(4)));
    }

    @Test(expected = UnsupportedParameterException.class)
    public void createLights_does_not_allow_nonNumeric_string_value() throws Exception {
        LightFactory.createLights("three", givenColours);
    }

    @Test(expected = UnsupportedParameterException.class)
    public void createLights_does_not_allow_negative_number() throws Exception {
        LightFactory.createLights("-1", givenColours);
    }

    @Test(expected = UnsupportedParameterException.class)
    public void createLights_does_not_allow_zero() throws Exception {
        LightFactory.createLights("0", givenColours);
    }

    @Test(expected = UnsupportedParameterException.class)
    public void createLights_does_not_allow_empty_list_of_colours() throws Exception {
        LightFactory.createLights("5", new ArrayList<>());
    }

    @Test
    public void createLights_creates_given_number_of_lights() throws Exception {
        List<Light> lights = LightFactory.createLights("5", givenColours);
        assertEquals(expectedLightList.get(0), lights.get(0));
        assertEquals(expectedLightList.get(1), lights.get(1));
        assertEquals(expectedLightList.get(2), lights.get(2));
        assertEquals(expectedLightList.get(3), lights.get(3));
        assertEquals(expectedLightList.get(4), lights.get(4));
    }

    @Test(expected = UnsupportedParameterException.class)
    public void createDefaultNumberOfLights_throws_exceptions_when_given_colours_empty_list() throws Exception {
        LightFactory.createDefaultNumberOfLights("fairylights", new ArrayList<>());
    }

    @Test(expected = UnsupportedConfigurationException.class)
    public void createDefaultNumberOfLights_throws_exceptions_when_wrong_noOfLights_configuration() throws Exception {
        LightFactory.createDefaultNumberOfLights("fairylightsWrongNoOfLightsConfiguration", givenColours);
    }

    @Test
    public void createDefaultNumberOfLights_creates_default_number_of_lights() throws Exception {
        List<Light> lights = LightFactory.createDefaultNumberOfLights("fairylights", givenColours);
        assertEquals(10, lights.size());
        assertEquals(expectedLightList.get(0), lights.get(0));
        assertEquals(expectedLightList.get(1), lights.get(1));
        assertEquals(expectedLightList.get(2), lights.get(2));
        assertEquals(expectedLightList.get(3), lights.get(3));
        assertEquals(expectedLightList.get(4), lights.get(4));
    }

    @Test(expected = UnsupportedConfigurationException.class)
    public void createDefaultNumberOfLightsWithDefaultColours_throws_exceptions_when_wrong_noOfLights_colours_configuration() throws Exception {
        LightFactory.createDefaultNumberOfLightsWithDefaultColours("fairylightsWrongNoOfLightsConfiguration");
        LightFactory.createDefaultNumberOfLightsWithDefaultColours("fairylightsWrongColourConfiguration");
    }

    @Test
    public void createDefaultNumberOfLightsWithDefaultColours_creates_default_number_of_lights_with_default_colours() throws Exception {
        expectedLightList = Arrays.asList(new Light(0, new Colour("Red")),
                new Light(1, new Colour("Green")),
                new Light(2, new Colour("White")),
                new Light(3, new Colour("Red")));

        List<Light> lights = LightFactory.createDefaultNumberOfLightsWithDefaultColours("fairylights");
        assertEquals(10, lights.size());
        assertEquals(expectedLightList.get(0), lights.get(0));
        assertEquals(expectedLightList.get(1), lights.get(1));
        assertEquals(expectedLightList.get(2), lights.get(2));
        assertEquals(expectedLightList.get(3), lights.get(3));
    }

    private Colour getRandomColour() {
        String randomColour = RandomStringUtils.random(6, "ABCDEFGHIJklmnopqrstuvwxyz");
        return new Colour(randomColour);
    }

    public void name() throws Exception {
        for (int i = 0; i < 25; i++) {
            System.out.println(String.format("Index:%d Remainder:%d", i, i % 5));
        }
    }

}