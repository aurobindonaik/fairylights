package uk.co.fairylights.model;

import uk.co.fairylights.exceptions.UnsupportedConfigurationException;
import uk.co.fairylights.exceptions.UnsupportedParameterException;
import uk.co.fairylights.utils.ConfigUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.apache.commons.lang3.StringUtils.isBlank;

/**
 * Created by aurobindo on 03/06/2018.
 */
public class ColourFactory {
    public static List<Colour> generateColours(String colourArrayString) throws UnsupportedParameterException {
        if(isBlank(colourArrayString)){
            throw new UnsupportedParameterException("Colours parameter string length must be greater than zero");
        }
        return Stream.of(colourArrayString.split(","))
                .map(colourString -> new Colour(colourString.trim()))
                .collect(Collectors.toList());
    }

    public static List<Colour> generateDefaultColours(String fileName) throws
            IOException, UnsupportedConfigurationException, UnsupportedParameterException {

        Properties appProps = ConfigUtil.readConfig(fileName);
        final String coloursConfigValue = appProps.getProperty("colours");
        if(isBlank(coloursConfigValue)){
            throw new UnsupportedConfigurationException("Make sure colours configuration is correct");
        }

        return generateColours(coloursConfigValue);
    }

    public static List<Colour> createDisplayColourSequence(String displayColourSequence, List<Colour> colours)
            throws UnsupportedParameterException {

        if(isBlank(displayColourSequence)){
            throw new UnsupportedParameterException("Display Colour Sequence parameter string length must be greater than zero");
        }

        List<Colour> displayColourSequenceList = new ArrayList<>();
        for (String colourString : displayColourSequence.split(",")) {
            for (Colour colour : colours){
                if(colour.getColour().equalsIgnoreCase(colourString)){
                    displayColourSequenceList.add(colour);
                }
            }
        }
        return displayColourSequenceList;
    }

    public static List<Colour> createDefaultDisplayColourSequence(String fileName) throws UnsupportedParameterException, IOException, UnsupportedConfigurationException {
        Properties appProps = ConfigUtil.readConfig(fileName);
        final String displayColourSeqConfigValue = appProps.getProperty("displayColourSequence");
        if(isBlank(displayColourSeqConfigValue)){
            throw new UnsupportedConfigurationException("Make sure displayColourSequence configuration is correct");
        }

        return generateColours(displayColourSeqConfigValue);
    }
}
