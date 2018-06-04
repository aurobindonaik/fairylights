package uk.co.fairylights.model;

import org.apache.commons.lang3.StringUtils;
import uk.co.fairylights.exceptions.UnsupportedConfigurationException;
import uk.co.fairylights.exceptions.UnsupportedParameterException;
import uk.co.fairylights.utils.ConfigUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.apache.commons.lang3.StringUtils.isBlank;

/**
 * Created by aurobindo on 31/05/2018.
 */
public class LightFactory {

    public static List<Light> createLights(String noOfLightsStrParam, List<Colour> colours)
            throws UnsupportedParameterException {

        if(!StringUtils.isNumeric(noOfLightsStrParam)){
            throw new UnsupportedParameterException("Number of lights should be a numeric value");
        }

        int noOfLights = Integer.parseInt(noOfLightsStrParam);
        if(noOfLights <= 0 || colours.isEmpty()){
            throw new UnsupportedParameterException("Number of lights and colours should be more than 0");
        }
        List<Light> lights = new ArrayList<>();
        final int noOfColours = colours.size();
        for (int i = 0; i < noOfLights; i++) {
            Colour reqColour = colours.get(i % noOfColours);
            lights.add(new Light(i, reqColour));
        }
        return lights;
    }

    public static List<Light> createDefaultNumberOfLights(String configFileName, List<Colour> colours)
            throws UnsupportedParameterException, UnsupportedConfigurationException, IOException {
        if(colours.isEmpty()){
            throw new UnsupportedParameterException("Colour list should have at least one colour");
        }

        Properties appProps = ConfigUtil.readConfig(configFileName);
        final String noOfLightsConfigValue = appProps.getProperty("noOfLights");
        if(isBlank(noOfLightsConfigValue)){
            throw new UnsupportedConfigurationException("Make sure noOfLights configuration is correct");
        }

        return createLights(noOfLightsConfigValue, colours);
    }

    public static List<Light> createDefaultNumberOfLightsWithDefaultColours(String configFileName)
            throws IOException, UnsupportedConfigurationException, UnsupportedParameterException {
        Properties appProps = ConfigUtil.readConfig(configFileName);
        final String noOfLightsConfigValue = appProps.getProperty("noOfLights");
        final String coloursConfigValue = appProps.getProperty("colours");

        if(isBlank(noOfLightsConfigValue) || isBlank(coloursConfigValue)){
            throw new UnsupportedConfigurationException("Make sure noOfLights and or colours configuration is correct");
        }

        return createLights(noOfLightsConfigValue, ColourFactory.generateDefaultColours(configFileName));
    }
}




