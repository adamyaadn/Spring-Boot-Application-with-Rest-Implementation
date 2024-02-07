package training.trg.rest.service;

import java.util.List;

import training.trg.rest.data.Employee;

public interface EmployeeService {
	void createData(Employee emp);
	Employee updateData(Employee emp);
	Employee getData(int empId);
	List<Employee> getAllData();
	void deleteData(int empId);
}
