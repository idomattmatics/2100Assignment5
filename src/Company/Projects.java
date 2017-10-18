package Company;

import java.io.FileReader;
import java.util.Scanner;

/**
 * Purpose: Create program considering Company UML from Assignment 4
 * Matthew Kachar
 * @author mkachar
 * matthew.kachar@marquette.edu
 * Nov 18, 2014
 */

public class Projects {
	private String name;//project object variables
	private String number;
	private String location;
	private String deptNum;

	/**
	 * Constructor
	 */
	public Projects(String a, String b, String c, String d){
		name = a;
		number = b;
		location = c;
		deptNum = d;
	}

	/**
	 * getName
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * setName 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * getNumber
	 * @return number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * getNumber
	 * @param number
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * getLocation
	 * @return location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * setLocation
	 * @param location
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * getDeptNum
	 * @return the deptNum
	 */
	public String getDeptNum() {
		return deptNum;
	}

	/**
	 * setDeptNum
	 * @param deptNum 
	 */
	public void setDeptNum(String deptNum) {
		this.deptNum = deptNum;
	}

	/**
	 * toString
	 * @toString() project
	 */
	public String toString() {
		return "Projects: name = " + name + ", number = " + number + ", location = " + location;
	}

	/**
	 * @param n
	 * @return
	 */
	public String getProjectDetails(int n){
		String projectRequested = "";
		try{
			Scanner inputStream = new Scanner(new FileReader("Project.txt"));//read file
			while (inputStream.hasNextLine()){
				String p = inputStream.nextLine();//split file lines
				String[] details = p.split(","); 
				if(n == Integer.parseInt(details[1])){
					projectRequested = p;
				}
			}
		}catch(Exception e){

		}return projectRequested;
	}
}