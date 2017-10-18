package Company;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Purpose: Create program considering Company UML from Assignment 4
 * Matthew Kachar
 * @author mkachar
 * matthew.kachar@marquette.edu
 * Nov 18, 2014
 */

public class Department {

	private String name;//department object variables
	private String number;
	private String manager;
	private String managerDOB;
	private ArrayList<Employee> employeeList = new ArrayList<Employee>(); 
	private ArrayList<Projects> projectList = new ArrayList<Projects>();

	/**
	 * Constructor
	 */
	public Department (String a, String b, String c, String d){
		name = a;
		number = b;
		manager = c;
		managerDOB = d;
	}

	public Department() {
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
	 * setNumber
	 * @param number
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * getManager
	 * @return manager
	 */
	public String getManager() {
		return manager;
	}

	/**
	 * setManager
	 * @param manager
	 */
	public void setManager(String manager) {
		this.manager = manager;
	}

	/**
	 * getManagerDOB
	 * @return
	 */
	public String getManagerDOB() {
		return managerDOB;
	}

	/**
	 * setManagerDOB
	 * @param managerDOB
	 */
	public void setManagerDOB(String managerDOB) {
		this.managerDOB = managerDOB;
	}

	/**
	 * getProjectList
	 * @return projectList
	 */
	public ArrayList getProjectList(){
		return this.projectList;
	}

	/**
	 * @toString()
	 */
	public String toString() {
		return "Department: name = " + name + ", number = " + number + ", manager = " + manager + ", managerDOB = " + managerDOB;
	}

	/**
	 * addEmployee
	 * @param Employee constructor
	 */
	public void addEmployee(String a, String b, String c, String d, String e, String f, String g) {
		this.employeeList.add(new Employee(a, b, c, d, e, f, g)); //employee constructor used in add method for employeeList
	}

	/**
	 * getEmployee
	 * @param String s
	 * @return Employee e
	 */
	public Employee getEmployee(String s){
		for (Employee e : this.employeeList ) {
			if(e.getSsn().equals(s)){
				return e;
			}    
		}
		return null;
	}
	/**
	 * getEmployeeName
	 * @param String s
	 * @return String
	 */
	public String getEmployeeName(String s){
		for (Employee e : this.employeeList){//loop search employees for their corresponding departments
			if (e.getSsn().equals(s)){//if department is found return true
				return e.getName();			  
			}
		}return "";
	}
	
	/**
	 * searchEmployeeList
	 * @param String s
	 * @return boolean
	 */
	public boolean searchEmployeeList(String s){
		for (Employee e : this.employeeList){//loop search employees for their corresponding departments
			if (e.getSsn().equals(s)){//if department is found return true
				return true;			  
			}
		}return false;
	}

	/**
	 * getEmployeeList
	 * @param int n
	 * @return String s
	 */
	public String getEmployeeList(int n){
		 try{
			 return this.employeeList.get(n).getSsn();
		 }catch(IndexOutOfBoundsException ioobe ){
			 return null;
		 }
	 }

	 /**
	  * employeeListToString
	  * @return String s
	  */
	 public String employeeListToString(){
		 String s = "";
		 for(Employee e : this.employeeList){
			 s = s + e.getName() + ", ";
		 }
		 return s;
	 }
}
