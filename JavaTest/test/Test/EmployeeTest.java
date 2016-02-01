package Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.vo.Employee;
import com.vo.MainTest;

public class EmployeeTest {
	MainTest maintest;

	@Before
	public void initilise() {
		maintest = new MainTest();
	}

	@Test
	public void testByIdPass() {

		List<Employee> empListTest = new ArrayList<Employee>();
		empListTest.add(new Employee(1, "A", 100));
		empListTest.add(new Employee(10, "X", 20000));
		empListTest.add(new Employee(3, "M", 50000));
		int choice = 2; // For Id
		Collections.sort(empListTest, new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				if (o1.getId() > o2.getId()) {
					return 1;
				} else {
					return -1;
				}
			}

		});

		// List<Employee> empTestOrignal = maintest.sortByChoice(choice,
		// empListTest);
		List<Employee> empTestOrignal = maintest.sortByChoice(choice, empListTest);
		Assert.assertEquals(empListTest, empTestOrignal);

	}

	@Test(expected = AssertionError.class)
	public void testByIdFail() {

		List<Employee> empListTest = new ArrayList<Employee>();
		empListTest.add(new Employee(1, "A", 100));
		empListTest.add(new Employee(10, "X", 20000));
		empListTest.add(new Employee(3, "M", 50000));
		int choice = 3; // Wrong Id is given
		Collections.sort(empListTest, new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				if (o1.getId() > o2.getId()) {
					return 1;
				} else {
					return -1;
				}
			}

		});

		List<Employee> empTestOrignal = maintest.sortByChoice(choice, empListTest);
		Assert.assertEquals(empListTest, empTestOrignal);

	}

	@Test
	public void testByNamePass() {

		List<Employee> empListTest = new ArrayList<Employee>();
		empListTest.add(new Employee(1, "A", 100));
		empListTest.add(new Employee(10, "X", 20000));
		empListTest.add(new Employee(3, "M", 50000));
		int choice = 1; // for Name
		Collections.sort(empListTest, new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				if (o1.getName().compareTo(o2.getName()) > 0) {
					return 1;
				} else {
					return -1;
				}
			}

		});

		List<Employee> empTestOrignal = maintest.sortByChoice(choice, empListTest);
		Assert.assertEquals(empListTest, empTestOrignal);

	}

	@Test
	public void testbySalaryPass() {

		List<Employee> empListTest = new ArrayList<Employee>();
		empListTest.add(new Employee(1, "A", 100));
		empListTest.add(new Employee(10, "X", 20000));
		empListTest.add(new Employee(3, "M", 50000));
		int choice = 3; // For salary
		Collections.sort(empListTest, new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				if (o1.getSalary() > o2.getSalary()) {
					return 1;
				} else {
					return -1;
				}
			}

		});

		List<Employee> empTestOrignal = maintest.sortByChoice(choice, empListTest);
		Assert.assertEquals(empListTest, empTestOrignal);

	}

	@Test(expected = AssertionError.class)
	public void testbySalaryFail() {

		List<Employee> empListTest = new ArrayList<Employee>();
		empListTest.add(new Employee(1, "A", 100));
		empListTest.add(new Employee(10, "X", 20000));
		empListTest.add(new Employee(3, "M", 50000));
		int choice = 2; // For salary
		Collections.sort(empListTest, new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				if (o1.getSalary() > o2.getSalary()) {
					return 1;
				} else {
					return -1;
				}
			}

		});

		List<Employee> empTestOrignal = maintest.sortByChoice(choice, empListTest);
		Assert.assertEquals(empListTest, empTestOrignal);

	}

	@Test(expected = AssertionError.class)
	public void testByNameFail() {

		List<Employee> empListTest = new ArrayList<Employee>();
		empListTest.add(new Employee(1, "A", 100));
		empListTest.add(new Employee(10, "X", 20000));
		empListTest.add(new Employee(3, "M", 50000));
		List<Employee> empTestOrignal;
		int choice = 3; // for Id Wrong choice is here

		Collections.sort(empListTest, new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				if (o1.getName().compareTo(o2.getName()) > 0) {
					return 1;
				} else {
					return -1;
				}
			}

		});

		empTestOrignal = maintest.sortByChoice(choice, empListTest);
		Assert.assertEquals(empListTest, empTestOrignal);

		// assertTrue("Passed", Assert.assertEquals(empListTest,
		// empTestOrignal));

	}

}
