package com.vo;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MainTest {
	public static void main(String[] args) {

		Scanner sc;
		int choice;
		List<Employee> empList = new ArrayList<Employee>();
		empList.add(new Employee(1, "G", 100));
		empList.add(new Employee(10, "F", 20000));
		empList.add(new Employee(3, "L", 50000));
		System.out.println("Enter Employee to be sorted \n 1. By Name \n 2. By Id \n 3. By Salary");
		try {
			sc = new Scanner(System.in);
			String tempString = sc.next();
			// if (!ss.equals("1") || ss.equals("2") || ss.equals("3")) {
			if (!(tempString.equals("1") || tempString.equals("2") || tempString.equals("3"))) {
				throw new InputMismatchException();
			} else {
				choice = Integer.parseInt(tempString);
			}

			/*
			 * List<Employee> printemployee = new
			 * MainTest().sortByChoice(choice, empList); if
			 * (printemployee.size() == 0) { System.out.println(
			 * "Exist from System "); System.exit(0); } for (int i = 0; i <
			 * printemployee.size(); i++) {
			 * System.out.println(printemployee.get(i)); }
			 */
			Map<Employee, String> mapEmployee = new TreeMap<Employee, String>();
			mapEmployee.put(empList.get(0), "Google");
			mapEmployee.put(empList.get(1), "FaceBook");
			mapEmployee.put(empList.get(2), "LinkedIn");

			Map<Employee, String> map = new MainTest().sortByChoice(mapEmployee, choice);
			for (Map.Entry<Employee, String> entry : map.entrySet()) {

				Employee employee = entry.getKey();
				String value = entry.getValue();
				System.out.println(employee + " company is " + value);

			}

		} catch (Exception e) {
			System.out.println("Exception found");
			e.printStackTrace();
		}

	}

	public List<Employee> sortByChoice(int choice, List<Employee> empList) throws InputMismatchException {

		Map<Integer, Employee> treeMapByInteger = new TreeMap<Integer, Employee>();
		Map<String, Employee> treeMapByString = new TreeMap<String, Employee>();
		List<Employee> resultEmployee = new ArrayList<Employee>();
		if (choice == 1) {
			for (int i = 0; i < empList.size(); i++)
				treeMapByString.put(empList.get(i).getName(), empList.get(i));

			for (Map.Entry<String, Employee> entry : treeMapByString.entrySet()) {
				Employee empp = entry.getValue();
				resultEmployee.add(empp);

			}

		} else if (choice == 2) {
			for (int i = 0; i < empList.size(); i++)
				treeMapByInteger.put(empList.get(i).getId(), empList.get(i));
			for (Map.Entry<Integer, Employee> entry : treeMapByInteger.entrySet()) {
				Employee empp = entry.getValue();
				resultEmployee.add(empp);

			}

		} else if (choice == 3) {
			for (int i = 0; i < empList.size(); i++)
				treeMapByInteger.put(empList.get(i).getSalary(), empList.get(i));
			for (Map.Entry<Integer, Employee> entry : treeMapByInteger.entrySet()) {
				Employee empp = entry.getValue();
				resultEmployee.add(empp);

			}
		} else {

			System.out.println("invalid choice");

		}
		return resultEmployee;

	}

	public Map<Employee, String> sortByChoice(Map<Employee, String> empList, int choice) {

		if (choice == 1) { // By name

			Map<Employee, String> employeeMap = new TreeMap<Employee, String>(new ComprareByName());

			for (Map.Entry<Employee, String> entry : empList.entrySet()) {
				employeeMap.put(entry.getKey(), entry.getValue());
			}
			return employeeMap;

		} else if (choice == 2) { // By Id

			return empList;

		} else {
			Map<Employee, String> employeeMap = new TreeMap<Employee, String>(new CompareBySalary());
			for (Map.Entry<Employee, String> entry : empList.entrySet()) {
				employeeMap.put(entry.getKey(), entry.getValue());
			}
			return employeeMap;

		}

	}

}