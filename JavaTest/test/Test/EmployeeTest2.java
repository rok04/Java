package Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.vo.Employee;
import com.vo.MainTest;

public class EmployeeTest2 {

	MainTest maintest;

	@Before
	public void initilise() {
		maintest = new MainTest();
	}

	@Test
	public void testByIdPass() {

		Map<Employee, String> empListTest = new TreeMap<Employee, String>(new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {

				if (o1.getId() >= o2.getId())
					return 1;
				else
					return -1;

			}

		});

		empListTest.put(new Employee(1, "G", 100), "Google");
		empListTest.put(new Employee(10, "F", 20000), "Facebook");
		empListTest.put(new Employee(3, "L", 50000), "LinkedIn");
		int choice = 2; // For Id

		// List<Employee> empTestOrignal = maintest.sortByChoice(choice,
		// empListTest);
		Set<Employee>ss= maintest.sortByChoice(empListTest, choice).keySet();
		
		@SuppressWarnings("unchecked")
		List<Employee> empTestOrignal = (List<Employee>) maintest.sortByChoice(empListTest, choice).keySet();
		for(int i=0;i<empTestOrignal.size();i++){
			System.out.println(empTestOrignal.get(i));
		}
		Assert.assertEquals(empListTest.keySet(), empListTest.keySet());

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
