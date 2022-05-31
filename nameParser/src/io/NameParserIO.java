package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import nameParser.Student;


public class NameParserIO {
	/**
	 * Here, we print out the given list to filename in CSV format
	 * which can then be read into Excel or some other spreadsheet software
	 * @param list The list of Students to write to a file
	 * @param filename The file to write the Students to
	 */
	public static void writeToFile(ArrayList<Student> list, String filename) {
		
	}
	
	/**
	 * Here, we read in a CSV file 
	 * @param filename The filename that 
	 * @return
	 */
	public static ArrayList<Student> createMasterStudentList(String filename) {
		if (filename == null) {
			throw new IllegalArgumentException("Selected File was null");
		}
		Scanner fileReader;
		Scanner lineReader;
		try {
			fileReader = new Scanner(new File(filename));
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("Given File could not be found");
		}
		ArrayList<Student> masterList = new ArrayList<Student>();
		while (fileReader.hasNextLine()) {
			lineReader = new Scanner(fileReader.nextLine());
			// parse the first name
			// parse the last name
			// create a new student
			// add it to the list
		}
		fileReader.close();
		return masterList;
	}
}
