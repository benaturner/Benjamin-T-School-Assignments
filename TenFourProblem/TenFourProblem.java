/*
 *   Program to provide user with a lookup for "10 codes" used in CB radio communications
*/

package tenfourproblem;

/**
 *
 * @author Benjamin Turner and Jack Skywalker
 * checklist:
 *  Documentation
 *  Split array of strings into key (Integer) value (String) pairs
 *  Build Map object from data
 *  Prompt user for "10 code" (key) and display corresponding meaning (value)
 *  Cleanly terminate program when user enters "quit"
 *  Respond appropriately if entered key not in map
 */

//Imports

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class TenFourProblem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // Commonly used "10 Codes" at your trucking company:
        String[] codes = { "10-1 - Receiving Poorly", 
            "10-2 - Receiving Well", 
            "10-3 - Stop Transmitting", 
            "10-4 - Ok, Message Received", 
            "10-5 - Relayomg Message", 
            "10-6 - Busy, Stand By",
            "10-7 - Leaving/Off - Air", 
            "10-8 - In Service, subject to call", 
            "10-9 - Please Repeat", 
            "10-10 - Standing By", 
            "10-11 - Talking too Rapidly", 
            "10-12 - Visitors Present", 
            "10-13 - Advise weather and road conditions", 
            "10-16 - Make pickup at _____",
            "10-17 - Urgent Business", 
            "10-18 - Anything for us?", 
            "10-19 - Nothing for you, return to base", 
            "10-20 - My Location is / What's your Location?", 
            "10-21 - Call by Landline", 
            "10-22 - Report in Person too _____", 
            "10-23 - Stand by", 
            "10-24 - Completed last assignment", 
            "10-25 - Can you Contact _____",
            "10-26 - Disregard Last Information/Cancel Last Message",
            "10-27 - I am moving to Channel _____",
            "10-28 - Identify your station", 
            "10-29 - Time is up for contact", 
            "10-30 - Does not conform to FCC Rules", 
            "10-32 - I will give you a radio check", 
            "10-33 - Emergency Traffic at this station", 
            "10-34 - Trouble at this station, help is needed", 
            "10-35 - Confidential Information", 
            "10-36 - Need correct time",
            "10-37 - Wrecker needed at _____",
            "10-38 - Ambulance needed at _____", 
            "10-39 - Your message delivered", 
            "10-41 - Please tune to channel _____",
            "10-42 - Traffic Accident at _____", 
            "10-43 - Traffic tied up at _____", 
            "10-44 - I have a message for you", 
            "10-45 - All units within range please report", 
			"10-46 - Touchdown Liberty!",
            "10-50 - Break Channel",
            "10-60 - What is next message number?", 
            "10-62 - Unable to copy, use phone", 
            "10-65 - Awaiting your next message or assignment", 
            "10-67 - All units comply", 
            "10-70 - Fire at _____ ",
            "10-71 - Proceed with transmission in sequence",
            "10-73 - Speed Trap at _____",
            "10-75 - You are causing interference", 
            "10-77 - Negative Contact", 
            "10-84 - My telephone number is _____",
            "10-85 - My address is ­­_____", 
			"10-86 - War Eagle!",
            "10-91 - Talk closer to the mic",
            "10-92 - Your transmitter is out of adjustment", 
            "10-93 - Check my frequency on this channel", 
            "10-94 - Please give me a long count", 
            "10-95 - Transmit dead carrier for 5 seconds",
            "10-99 - Mission completed, all units secure",
            "10-100 - Taking a potty break",
            "10-200 - Police Needed",
            "10-400 - Drop Dead" };
        
        // Read each code and insert them into a Map Object where the code is
        // the key and the meaning is the value. For example, the key value pair for
        // 10-200 would be key: 200, value: "Police Needed"
        // Note that the key should be an Integer and the value a String.
        
        // Build Map Instance Here
        Map<Integer, String> map = new HashMap<>();
        for (String code : codes)
        {
            // Split up string to get needed parts building map one entry at a time
            String subStr = code.substring(3);
            String[] tempArr = subStr.split(" - ");
            int key = Integer.parseInt(tempArr[0]);
            String value = tempArr[1];
            map.put(key, value);
        }
        
        // Enter While Loop To Prompt For Code To Display Meaning
        // Terminate loop on 'quit' entry
        // Notify user of unknown code

        while (true)
        {
            // Prompt user for code
            System.out.print("Enter Code 10-");
            
            // Read entry
            Scanner s = new Scanner(System.in);
            String input = s.next();
            int inputKey = 0;
            // Check for "quit"
            if (input.equals("quit")) {
                System.exit(0);
            }
            // Convert response to an integer
            try {
                inputKey = Integer.parseInt(input);
            }
            catch(Exception e){
            System.out.println("Invalid input");
            continue;
        }
            // Check for presence of key in map and output message is not
            String output = map.get(inputKey);
            if (output == null) {
                System.out.println("No meaning for entered code");
            }
            // Output meaning of entered code:
            else {
                System.out.printf("Meaning for 10-%d is %s%n", inputKey, output);
            }
        }
    }    
}
