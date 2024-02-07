package training.trg.rest.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import training.trg.rest.data.Employee;
import training.trg.rest.exceptions.DuplicateDataException;
import training.trg.rest.exceptions.NonExistentDataAccess;
import training.trg.rest.service.EmployeeService;

@RestController
@RequestMapping(path="employees")
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	
	@GetMapping(path="{empId}")
	public Employee getEmployee(@PathVariable("empId") int empId) {
		Employee e = service.getData(empId);
		return e;
	}
	
	@GetMapping(path="all")
	public List<Employee> getEmployeeList() {
		List<Employee> e = service.getAllData();
		return e;
	}
	
	@PostMapping
	public String createEmployee(@RequestBody Employee e) {
		try {
			service.createData(e);
			return "Employee created successfully.";
		} catch(DuplicateDataException ex) {
			return ex.getMessage();
		}
	}
	
	@PutMapping
	public String updateEmployee(@RequestBody Employee e) {
		try {
			service.updateData(e);
			return "Employee updated successfully.";
		} catch(NonExistentDataAccess ex) {
			return ex.getMessage();
		}
	}
	
	@DeleteMapping(path="{empId}")
	public String deleteEmployee(@PathVariable("empId") int empId) {
		try {
			service.deleteData(empId);
			return "Employee deleted successfully.";
		} catch(NonExistentDataAccess ex) {
			return ex.getMessage();
		}
	}
}
