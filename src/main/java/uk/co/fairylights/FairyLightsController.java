package uk.co.fairylights;

import uk.co.fairylights.exceptions.UnsupportedParameterException;
import uk.co.fairylights.executor.Executor;
import uk.co.fairylights.utils.ConfigUtil;

import java.io.IOException;
import java.util.Properties;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * Created by aurobindo on 31/05/2018.
 */
public class FairyLightsController {
    public static void main(String[] args) throws IOException, UnsupportedParameterException {
        if(args.length<1){
            System.out.println("Please Provide the Algorithm to Run:sequence OR colour or alternate.");
            System.out.println("Also you can pass optional parameter noOfLights, colours, displayColourSequence as below.");
            System.out.println("noOfLights=10 colours=a,b,c, displayColourSequence=e,f,g");
            return;
        }

        String algorithmName = args[0];

        //Load properties from property file in classpath
        final Properties properties = ConfigUtil.readConfig("fairylights");;

        //Check whether the requested algorithm exists if not exit the program.
        String algorithmListStr = properties.getProperty("algorithms");
        algorithmListStr = algorithmListStr.toUpperCase();

        if(!algorithmListStr.contains(algorithmName.toUpperCase())){
            System.out.println("Sorry requested Algorithm not recognized. Please provide one of: "+algorithmListStr);
            return;
        }

        //Read no of lights from the property file.
        String noOfLights = properties.getProperty("noOfLights");
        if(args.length >= 2 && isNotBlank(args[1]) && args[1].contains("noOfLights")){
            //Use the supplied number of lights over the configured one
            String noOfLightsParam = args[1];
            noOfLights = noOfLightsParam.substring(noOfLightsParam.indexOf("=")+1, noOfLightsParam.length());
        }
        //Read colour sequence from the property file
        String colourSequence = properties.getProperty("colours");
        if(args.length >= 3 && isNotBlank(args[2]) && args[2].contains("colours")){
            //Use the supplied colour sequence over the configured one
            String coloursParam = args[2];
            colourSequence = coloursParam.substring(coloursParam.indexOf("=")+1, coloursParam.length());
        }
        /*
         * Read the display colour sequence from the property file;
         * This can be used to change the display colour sequence from the original colour sequence
         */
        String displayColourSequence = properties.getProperty("displayColourSequence");
        if(args.length >= 4 && isNotBlank(args[3]) && args[1].contains("displayColourSequence")){
            //Use the supplied display colour sequence over the configured one
            String displayColourSequenceParam = args[3];
            displayColourSequence = displayColourSequenceParam
                    .substring(displayColourSequenceParam.indexOf("=")+1, displayColourSequenceParam.length());
        }

        //Now Give the task to the Executor to Run
        Executor executor = new Executor(colourSequence, displayColourSequence, noOfLights, algorithmName);
        executor.execute();
    }
}
