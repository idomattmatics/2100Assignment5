package Company;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/**
 * Purpose: Create program considering Company UML from Assignment 4
 * Matthew Kachar
 * @author mkachar
 * matthew.kachar@marquette.edu
 * Nov 18, 2014
 */

public class Employee {

	private String name;//employee object variables
	private String ssn;
	private String address;
	private String salary; 
	private String DOB;
	private String supervisor;
	private String department; 
	private double totalHours;
	private ArrayList<String> Assignments = new ArrayList<String>();

	/**
	 * Constructor
	 */
	public Employee(String a, String b, String c, String d, String e, String f, String g){
		name = a;
		ssn = b;
		address = c; 
		salary = d;
		DOB = e;
		supervisor = f;
		department = g;

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
	 * getSsn
	 * @return name
	 */
	public String getSsn() {
		return ssn;
	}

	/**
	 * setSsn
	 * @param ssn
	 */
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	/**
	 * getAddress
	 * @return address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * setAddress
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * getSalary
	 * @return salary
	 */
	public String getSalary() {
		return salary;
	}

	/**
	 * setSalary
	 * @param salary
	 */
	public void setSalary(String salary) {
		this.salary = salary;
	}

	/**
	 * getDOB
	 * @return DOB
	 */
	public String getDOB() {
		return DOB;
	}
	/**
	 * @param s
	 */
	public void addAssignment(String s){
		this.Assignments.add(s);
	}
	/**
	 * setDOB
	 * @param dOB
	 */
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	/**
	 * @param h
	 */
	public void setTotalHours(double h){
		totalHours = h;
	}
	/**
	 * @return
	 */
	public double getTotalHours(){
		return totalHours;
	}

	/**
	 * @return the supervisor
	 */
	public String getSupervisorSSN() {
		return supervisor;
	}

	/**
	 * @param supervisor the supervisor to set
	 */
	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}

	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	public String toString(){
		return "Employee Name : " + this.name + "\nSSN : " + this.ssn;
	}
}

