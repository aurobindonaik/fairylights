How To Run:

Copy FairyLightsController.jar to a local folder and type the following command.
java -jar FairyLightsController.jar Sequence
or 
java -jar FairyLightsController.jar Colour

To run with given noOfLights
java -jar FairyLightsController.jar <algorithm> noOfLights=10

To run with given set of Colours
java -jar FairyLightsController.jar <algorithm> noOfLights=10 colours=Yellow,Green,Purple

To run with given set of Colours and display colours

java -jar FairyLightsController.jar <algorithm> noOfLights=10 colours=Yellow,Green,Purple displayColourSequence=Purple,Green,Yellow

How to modify:

Add colour:
Simply add another colour in the comma separated list of colours parameter 

OR

add another colour in the fairylights.properties file colours configurable property

e.g. to add a new colour 'yellow'
colours=Red,Green,White,Yellow

Add additional lights
provide additional command line argument for a different length of fairy lights e.g.  
java -jar FairyLightsController.jar Colour 30

java -jar FairyLightsController.jar Colour 15

Add new Algorithm/Strategy
This involves two steps:
Create a new algorithm by extending AbstractAlgorithm e.g. RandomDisplayAlgorithm.java
Add algorithm to the available algorithm configuration inside fairylights.properties

Clone the project and then run 'mvn clean package' to get the packaged executable jar. 


