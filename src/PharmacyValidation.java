package com.dataengineering;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class PharmacyValidation {

	public static void printToText(ArrayList<PharmacyObject> outputArray) {

		//String outputFile="C:\\Users\\c0806\\Desktop\\Data Engineering project Java and Python\\Pharmacy Counting Java\\Data Engineering project_from insight\\output\\top_cost_drug.txt";  // Location of the output file.
		String outputFile="./output/top_cost_drug.txt";

		try {
			PrintWriter outputStream= new PrintWriter(outputFile);
			outputStream.println("drug_name,num_prescriber,total_cost");
			for (int i = outputArray.size()-1; i >=0; i--) {
				outputStream.println(outputArray.get(i).getMedicine()+","
						+outputArray.get(i).getName()+","
						+(int)outputArray.get(i).getCost());
			}
			outputStream.close();

		} catch (FileNotFoundException e) {
			System.out.println(
					"Unable to find file '" +
							outputFile + "'");
			e.printStackTrace();
		}
	}


	public static void  arrayValidation(ArrayList<PharmacyObject> array) {

		String comparableMedicineName,medicineName,comparableName,name;
		ArrayList<String> drugNames=new ArrayList<>();
		ArrayList<String> prescriberNames=new ArrayList<>();
		ArrayList<PharmacyObject> outputValues=new ArrayList<>();

		for (int i = 0; i <array.size(); i++) {

			double cost=0.00;
			int count=1;
			comparableMedicineName=array.get(i).getMedicine().trim();
			comparableName=array.get(i).getName().trim();
			cost=array.get(i).getCost();

			if(drugNames.contains(comparableMedicineName)) {
				continue;
			}

			for (int j = i+1; j < array.size(); j++) {

				medicineName=array.get(j).getMedicine().trim();
				name=array.get(j).getName().trim();

				if(comparableMedicineName.equalsIgnoreCase(medicineName)){
					if(comparableName.equalsIgnoreCase(name)) {
						cost+=array.get(j).getCost();
					}
					else {
						cost+=array.get(j).getCost();
						if(prescriberNames.contains(name)) {
							continue;
						}
						count++;
					}
					prescriberNames.add(comparableName);
					prescriberNames.add(name);
				}
				else { //(comparableMedicineName!=medicineName)
					continue;
				}
			}

			outputValues.add(new PharmacyObject(""+count,comparableMedicineName,cost));
			Collections.sort(outputValues);   // For sorting the cost of each medicine
			drugNames.add(comparableMedicineName);
			printToText(outputValues);

		}
	}


	public static void main(String[] args) {

		System.out.println("Commit check message");
		//String path="C:\\Users\\c0806\\Desktop\\Data Engineering project Java and Python\\Pharmacy Counting Java\\Data Engineering project_from insight\\input\\itcont.txt"; // Location of input file
		String path="./input/itcont.txt"; //./input/itcont.txt
		String line=null;

		try {

			FileReader fileReader=new FileReader(path);
			BufferedReader bufferedReader=new BufferedReader(fileReader);
			line=bufferedReader.readLine();
			String completeName,medicineName=null;
			ArrayList<PharmacyObject> array= new ArrayList<>();

			while ((line=bufferedReader.readLine())!=null) {
				try {
					String[] words=line.split(",");
					completeName=words[1]+words[2];
					if(words[3].startsWith("\"")) {
						medicineName=words[3].substring(1, words[3].length());
					}else {
						medicineName=words[3];
					}

					array.add(new PharmacyObject(completeName,medicineName,Double.parseDouble(words[4])));
				}
				catch (Exception e) {
					System.out.println(
							"Exception Occured");
					continue;

				}
			}

			System.out.println("Total number of records in the input file: "+array.size());
			arrayValidation(array);
			bufferedReader.close();

		}
		catch (FileNotFoundException e) {
			System.out.println(
					"Unable to open file '" +
							path + "'");
		}

		catch (IOException e) {
			System.out.println(
					"Error reading file '"
							+ path + "'");
		}
	}

}
