package com.vo;

public class Employee implements Comparable<Employee> {

	private int id;
	private int salary;
	private String name;

	public Employee(int id, String name, int salary)  {

		this.id = id;
		this.salary = salary;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuffer s1 = new StringBuffer();
		s1.append("Employee name : ");
		s1.append(this.name);
		s1.append(" Id is: ");
		s1.append(Integer.toString(this.id));
		s1.append(" salary is ");
		s1.append(Integer.toString(this.salary));
		return s1.toString();

	}

	@Override
	public int compareTo(Employee o) {
		if(o.id>this.id)
			return -1;
		else
			return 1;
	}

}
