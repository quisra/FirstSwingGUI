/** 
 * Reads input from GUI
 */

import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;

public class FileHandler {

	private String surveyFile;
	private FileWriter fileOutput;
	private PrintWriter printWriter;
	
	
	/** 
     * Constructor for FileHandler which overwrites files once open 
     * 
     */ 
	public FileHandler() {
		try {
			this.surveyFile = "survey_results.csv";
			this.fileOutput = new FileWriter(surveyFile, false);
			this.printWriter = new PrintWriter(fileOutput);
			
			
			
			//writes data to the log
			printWriter.println( "DateTime,FirstName,LastName,PhoneNumber,Email,Sex,Water,Meals,Wheat,Sugar,Dairy,Miles,Weight");
			
			printWriter.close();
		}catch(Exception e) {
			e.getStackTrace();
		}
		
	}
	
	/** 
     * Appends data to the file 
     * @param surveyData The string being appended. 
     * 
     */ 
	public void writeResults(String surveyData) {
		try {
			this.surveyFile = "survey_results.csv";
			this.fileOutput = new FileWriter(surveyFile, true);
			this.printWriter = new PrintWriter(fileOutput);
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyy/MM/dd HH:mm:ss");
			Date date = new Date();
			String current = dateFormat.format(date);
			
			printWriter.println(current + "," + surveyData);
			printWriter.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
