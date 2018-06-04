package uk.co.fairylights.model;

import org.junit.Before;
import org.junit.Test;
import uk.co.fairylights.exceptions.UnsupportedConfigurationException;
import uk.co.fairylights.exceptions.UnsupportedParameterException;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by aurobindo on 03/06/2018.
 */
public class ColourFactoryTest {
    private List<Colour> expectedColours;
    private List<Colour> expectedDisplayColourSequence;
    private List<Colour> colours;
    @Before
    public void setUp() throws Exception {
        colours = ColourFactory.generateColours("my,given,colour");
        expectedColours = Arrays.asList(new Colour("my"), new Colour("given"), new Colour("colour"));
        expectedDisplayColourSequence = Arrays.asList(new Colour("colour"), new Colour("my"), new Colour("given"));
    }

    @Test(expected = UnsupportedParameterException.class)
    public void generateColours_does_not_allow_an_empty_string() throws Exception {
        ColourFactory.generateColours("");
    }

    @Test(expected = UnsupportedParameterException.class)
    public void generateColours_does_not_allow_an_blank_string() throws Exception {
        ColourFactory.generateColours("  ");
    }

    @Test(expected = UnsupportedParameterException.class)
    public void createDisplayColourSequence_does_not_allow_an_empty_string() throws Exception {
        ColourFactory.createDisplayColourSequence("", colours);
    }

    @Test(expected = UnsupportedParameterException.class)
    public void createDisplayColourSequence_does_not_allow_an_blank_string() throws Exception {
        ColourFactory.createDisplayColourSequence("  ", colours);
    }

    @Test
    public void generateColours_creates_given_list_of_colours() throws Exception {
        List<Colour> colours = ColourFactory.generateColours("my,given,colour");
        assertEquals(expectedColours.get(0), colours.get(0));
        assertEquals(expectedColours.get(1), colours.get(1));
        assertEquals(expectedColours.get(2), colours.get(2));
    }

    @Test
    public void createDisplayColourSequence_creates_given_display_sequence_of_colours() throws Exception {
        List<Colour> displayColourSequence = ColourFactory.createDisplayColourSequence("colour,my,given", colours);

        assertEquals(expectedDisplayColourSequence.get(0), displayColourSequence.get(0));
        assertEquals(expectedDisplayColourSequence.get(1), displayColourSequence.get(1));
        assertEquals(expectedDisplayColourSequence.get(2), displayColourSequence.get(2));
    }

    @Test
    public void generateColours_creates_given_list_of_colours_with_colour_strings_trimmed() throws Exception {
        expectedColours = Arrays.asList(new Colour("different"), new Colour("set of"), new Colour("colour"));
        List<Colour> colours  = ColourFactory.generateColours("   different, set of ,colour    ");
        assertEquals(expectedColours.get(0), colours.get(0));
        assertEquals(expectedColours.get(1), colours.get(1));
        assertEquals(expectedColours.get(2), colours.get(2));
        assertEquals("different", colours.get(0).getColour());
        assertEquals("set of", colours.get(1).getColour());
        assertEquals("colour", colours.get(2).getColour());
    }

    @Test(expected = UnsupportedConfigurationException.class)
    public void generateDefaultColours_throws_incorrect_configurable_colours_in_property_file_error() throws Exception {
        ColourFactory.generateDefaultColours("fairylightsWrongColourConfiguration");
    }

    @Test
    public void generateDefaultColours_creates_default_colour_list_from_configurable_colours_in_property_file() throws Exception {
        expectedColours = Arrays.asList(new Colour("Red"), new Colour("Green"), new Colour("White"));
        List<Colour> colours  = ColourFactory.generateDefaultColours("fairylights");
        assertEquals(expectedColours.get(0), colours.get(0));
        assertEquals(expectedColours.get(1), colours.get(1));
        assertEquals(expectedColours.get(2), colours.get(2));
    }

    @Test(expected = UnsupportedConfigurationException.class)
    public void createDefaultDisplayColourSequence_throws_incorrect_configurable_colours_in_property_file_error() throws Exception {
        ColourFactory.createDefaultDisplayColourSequence("fairylightsWrongDisplayColourSequenceConfiguration");
    }

    @Test
    public void createDefaultDisplayColourSequence_creates_default_display_colour_sequence_from_configurable_displayColourSequence_in_property_file() throws Exception {
        expectedColours = Arrays.asList(new Colour("White"), new Colour("Green"), new Colour("Red"));
        List<Colour> colours  = ColourFactory.createDefaultDisplayColourSequence("fairylights");
        assertEquals(expectedColours.get(0), colours.get(0));
        assertEquals(expectedColours.get(1), colours.get(1));
        assertEquals(expectedColours.get(2), colours.get(2));
    }
}