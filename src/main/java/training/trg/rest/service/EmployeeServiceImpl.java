package training.trg.rest.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import training.trg.rest.data.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {


	Map<Integer,Employee> employeesByIdMap = new HashMap<>();
	public EmployeeServiceImpl() {
		super();
		employeesByIdMap.put(11,new Employee(11,"Alex",40900,LocalDate.of(2000,10,18)));
		employeesByIdMap.put(22,new Employee(22,"Luke",38845,LocalDate.of(1992,11,24)));
		employeesByIdMap.put(33,new Employee(33,"Manny",29390,LocalDate.of(1998,1,4)));
		employeesByIdMap.put(44,new Employee(44,"Lily",12342,LocalDate.of(2003,5,1)));
	}
	
	public Employee createData(Employee emp) {
		employeesByIdMap.put(emp.getEmpId(), emp);
		return employeesByIdMap.get(emp.getEmpId());
	}

	@Override
	public Employee updateData(Employee emp) {
		employeesByIdMap.put(emp.getEmpId(), emp);
		return employeesByIdMap.get(emp.getEmpId());
	}

	@Override
	public Employee getData(int empId) {
		return employeesByIdMap.getOrDefault(empId, null);
	}

	@Override
	public List<Employee> getAllData() {
		List<Employee> allEmployees = new ArrayList<>();
		for(Employee emp : employeesByIdMap.values()) {
			allEmployees.add(emp);
		}
		return allEmployees;
	}

	@Override
	public void deleteData(int empId) {
		employeesByIdMap.remove(empId);
	}

}
