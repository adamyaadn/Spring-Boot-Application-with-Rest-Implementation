package training.trg.rest.data;

import java.time.LocalDate;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement 
//need this tag for xml
public class Employee {
	private int empId;
	private String name;
	private int salary;
	private LocalDate dob;

	public int getEmpId() {
		return empId;
	}

	public Employee() {
		super();
	}

	public Employee(int empId, String name, int salary, LocalDate dob) {
		super();
		this.empId = empId;
		this.name = name;
		this.salary = salary;
		this.dob = dob;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

}
