package com.bludots.assignments.File;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class FileApplication {

	//Array List of names
	public static ArrayList<String> names = new ArrayList<>();
	// Creates a text file
	public static File textFile = new File("names.txt");
	public static File textFile1 = new File("names1.txt");
	public static File textFile2 = new File("names2.txt");
	static File dir = new File(".");
	//array of directory of files
	static String[] files = dir.list();
	
	public static void main(String[] args) {
		putNamesInFile(textFile);
		putNamesInFile(textFile1);
		putNamesInFile(textFile2);
		
		
		deleteFileIfBytesBiggerThan1000(textFile);
		deleteFileIfBytesBiggerThan1000(textFile1);
		deleteFileIfBytesBiggerThan1000(textFile2);

		//Dit zal wijzen de alle files in the root(Als ze zijn delete komen ze niet voor)
		showFiles();
	}
	
	// wijst files binnen the root path met .
	public  static void showFiles() {
		for (String name: files) {
			System.err.println(name);
		}
	}

	// puts some names in the file
	public static void putNamesInFile(File file) {
		// Create random names and add to List
		for (int i = 0; i < 50; i++) {
			Random random = new Random();

			String[] voornamen = { "Jair", "Lisa", "Roy", "Bob", "Jenny" };
			int chooseVoornaam = random.nextInt(voornamen.length);

			String[] achternamen = { " ling", " Ben", " Bro", " Lenny", " Rob" };
			int chooseAchternaam = random.nextInt(achternamen.length);

			String name = voornamen[chooseVoornaam] + achternamen[chooseAchternaam];
			names.add(name);
		}
		//Voeg random namen toe in de file
		try {
			FileWriter writer = new FileWriter(file, true);
			for (String name : names) {
				writer.write(name.toString() + "\n");
			}
			writer.close();
		} catch (IOException io) {
			System.err.println("Something went wrong: " + io.getMessage());
		}
	}
	
	//This method deletes the file if the file is larger than 1000 bytes
	public static void deleteFileIfBytesBiggerThan1000(File file) {
		if(file.length() > 1000) {
			file.delete();
			System.out.println("File ("+file.getName()+") is bigger than a 1000 bytes, so it is deleted");
		} else {
			System.out.println("File ("+file.getName()+") is smaller than a 1000 bytes, so it is not deleted");
		}
	}
}
