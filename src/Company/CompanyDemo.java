package Company;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 * Purpose: Create program considering Company UML from Assignment 4
 * Matthew Kachar
 * @author mkachar
 * matthew.kachar@marquette.edu
 * Nov 18, 2014
 */

public class CompanyDemo {

	public static void main (String[] args){

		HashMap <Integer, Department> companyMap = new HashMap<Integer, Department>();//department number, department object

		try{
			Scanner inputStream1 = new Scanner(new FileReader("DEPARTMENT.csv"));//read file
			int i = 0;
			while (inputStream1.hasNextLine()){
				String dept = inputStream1.nextLine();
				if (i > 0){
					String[] details = dept.split(","); //split file line

					companyMap.put(Integer.parseInt(details[1]), new Department(details[0], details[1], details[2], details[3]));//construct department object
				}
				i++;
			}
			inputStream1.close();
		}catch(IOException e){//catch file errors
			System.out.println("Error " + e.getMessage());
		}

		try{
			Scanner inputStream2 = new Scanner(new FileReader("EMPLOYEE.csv"));//read file
			int i = 0;
			while (inputStream2.hasNextLine()){
				String emp = inputStream2.nextLine();
				if (i > 0){
					String[] details2 = emp.split(","); //split file lines
					companyMap.get(Integer.parseInt(details2[9])).addEmployee(details2[0] + " " + details2[1], details2[2], details2[3], //construct employee object
							details2[4] + " " + details2[5] + ", " + details2[6], details2[7], details2[8], details2[9]);
				}
				i++;
			}
			inputStream2.close();
		}catch(IOException e){//catch file errors
			System.out.println("Error " + e.getMessage());
		}
		Scanner keyboard = new Scanner(System.in);
		Scanner run = new Scanner(System.in);
		String quit = "Y";//create a run variable for the do/while loop
		
		do{//user prompts 
			System.out.println("Please consider the following choices : ");
			System.out.println("(1)   Given a department number as input, list the names of employees who work for the given department.");
			System.out.println("(2)   Employees working on one project but not the other");
			System.out.println("(3)   Quit");
			System.out.println("Please select a choice : ");

			int n = run.nextInt();

			switch (n){
			case 1 ://get names of employees in the department
				System.out.println("Please enter the department number :");
				int key = keyboard.nextInt();
				System.out.println("The names of employees whom work for department" + companyMap.get(key).getName() +" are :");
				System.out.println(companyMap.get(key).employeeListToString());
				break;
			case 2://get employees that work on one project but not the other
				System.out.println("Please enter project #A :");
				int a = keyboard.nextInt();
				System.out.println("Please enter project #B :");
				int b = keyboard.nextInt();
				System.out.println("The names of employees who work on project # " + a + " " + getProjectName(a) + " but NOT on project # " + b + " " + getProjectName(b) + " are :");
				for (String s : worksOnAButNotB(a,b)){
					String[] ssn = s.split(","); 
					for (Integer keys : companyMap.keySet()) {//run loop to check each department object for the employee
						System.out.print(companyMap.get(keys).getEmployeeName(ssn[0]) + " ");//the method returns boolean then prints the employee info
					}
				}
				break;
			case 3://exit
				System.out.println("Goodbye");
				quit = "quit";
				break;
			default:
				System.out.println("Invalid choice, please re enter");
				break;
			}
			System.out.println();
			System.out.println();
			System.out.println("**********************");
			System.out.println();
		}while(!quit.equals("quit"));
	}
	
	/**
	 * getProjectName
	 * @param n
	 * @return String name
	 */
	public static String getProjectName(int n){
		String name = "";
		try{
			Scanner inputStream = new Scanner(new FileReader("PROJECT.csv"));//read file
			int i = 0;
			while (inputStream.hasNextLine()){
				String s = inputStream.nextLine();
				if (i > 0){
					String[] s2 = s.split(",");// get project name
					if(Integer.parseInt(s2[1]) == n){
						name = s2[0];
					}
				}
				i++;
			}
		}catch(IOException e){//catch file errors
			System.out.println("Error " + e.getMessage());
		}
		return name;
	}
	
	/**
	 * worksOnAButNotB
	 * @param int a, int b
	 * @return ArrayList worksonList
	 */
	public static ArrayList<String> worksOnAButNotB(int a, int b){
		ArrayList<String> worksonList = new ArrayList<String>();
		try{
			Scanner inputStream = new Scanner(new FileReader("WORKS_ON.csv"));//read file
			int i = 0;
			while (inputStream.hasNextLine()){
				String s = inputStream.nextLine();
				if (i > 0){
					worksonList.add(s);
				}
				i++;
			}
		}catch(IOException e){//catch file errors
			System.out.println("Error " + e.getMessage());
		}
		for(int i = 0; i < worksonList.size(); i++){ // 
			String[] s2 = worksonList.get(i).split(",");
			if (Integer.parseInt(s2[1]) != a && Integer.parseInt(s2[1]) != b){
				worksonList.remove(i);
				i = -1;//reset loop to compensate for remove operation
			}
		}
		for(int i = 0; i < worksonList.size(); i++){
			String[] s2 = worksonList.get(i).split(",");
			if (Integer.parseInt(s2[1]) == b){
				worksonList.remove(i);
				i = -1;
			}
		}
		return worksonList;
	}
}
