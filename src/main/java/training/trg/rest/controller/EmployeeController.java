package training.trg.rest.controller;

import java.awt.PageAttributes.MediaType;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import training.trg.rest.data.Employee;
import training.trg.rest.service.EmployeeService;

@RestController
@RequestMapping(path="employees")
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	
	@RequestMapping(path="{empId}", method = RequestMethod.GET)
	public Employee getEmployee(@PathVariable("empId") int empId) {
		Employee e = service.getData(empId);
		return e;
	}
	
	@RequestMapping(path="all", method = RequestMethod.GET)
	public List<Employee> getEmployeeList() {
		List<Employee> e = service.getAllData();
		return e;
	}
}
