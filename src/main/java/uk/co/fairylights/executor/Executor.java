package uk.co.fairylights.executor;

import uk.co.fairylights.algorithms.AbstractAlgorithm;
import uk.co.fairylights.algorithms.AlternateAlgorithm;
import uk.co.fairylights.algorithms.ColourAlgorithm;
import uk.co.fairylights.algorithms.SequenceAlgorithm;
import uk.co.fairylights.exceptions.UnsupportedParameterException;
import uk.co.fairylights.model.Colour;
import uk.co.fairylights.model.ColourFactory;
import uk.co.fairylights.model.Light;
import uk.co.fairylights.model.LightFactory;

import java.util.List;
import java.util.Scanner;

public class Executor {

	private String colourSequence;
	private String displayColourSequence;
	private String numberOfLights;
	private String algorithmName;
	
	boolean keepRunning = true;
	
	public Executor(String colourSequence, String displayColourSequence, String numberOfLights, String algorithmName) {
		super();
		this.colourSequence = colourSequence;
		this.displayColourSequence = displayColourSequence;
		this.numberOfLights = numberOfLights;
		this.algorithmName = algorithmName;
	}
	
	public void execute() throws UnsupportedParameterException {
		//Using the Factory class create the Colour and Light List
		List<Colour> colours = ColourFactory.generateColours(colourSequence);
		List<Colour> displayColourSeq = ColourFactory.createDisplayColourSequence(displayColourSequence, colours);
		List<Light> lights = LightFactory.createLights(numberOfLights, colours);
		
		//Create the Algorithm
		AbstractAlgorithm algorithm = null;
        if(algorithmName.equalsIgnoreCase("sequence")){
        	algorithm = new SequenceAlgorithm(lights, colours, 0.5);
        }else if(algorithmName.equalsIgnoreCase("colour")){
        	algorithm = new ColourAlgorithm(lights, displayColourSeq, 1);
        }else if(algorithmName.equalsIgnoreCase("alternate")){
        	algorithm = new AlternateAlgorithm(lights, colours, displayColourSeq, 30);
        }
        
        checkUserTerminationSignal();
        
		//Start the algorithm.
        while(keepRunning){
        	algorithm.run();
        }
	}
	
	protected void checkUserTerminationSignal()	{
		new Thread(() -> {
            try (Scanner scanner = new Scanner(System.in)) {
                boolean keepWaiting = true;
                while(keepWaiting) {
                    String userInput = scanner.next();
                    if("t".equalsIgnoreCase(userInput)) {
                        stopRunning();
                        keepWaiting = false;
                    }
                }
            }
        }).start();
	}
	
	private synchronized void stopRunning(){
		keepRunning = false;
	}

}
