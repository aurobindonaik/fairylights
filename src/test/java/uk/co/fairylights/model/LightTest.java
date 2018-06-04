package uk.co.fairylights.model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by aurobindo on 03/06/2018.
 */
public class LightTest {
    @Test
    public void getLightStatus_returns_light_index_colour_on_off_status() throws Exception {
        Light light = new Light(0, new Colour("Green"), true);
        assertEquals("Light 1 Green On.", light.toString());

        light = new Light(1, new Colour("Red"), false);
        assertEquals("Light 2 Red Off.", light.toString());
    }
}