package training.trg.rest.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import training.trg.rest.data.ResponseMessageCustom;
import training.trg.rest.exceptions.DuplicateDataException;
import training.trg.rest.exceptions.NonExistentDataAccess;
import training.trg.rest.service.EmployeeService;

@RestController
@RequestMapping(path="employees")
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	
	@GetMapping(path="{empId}")
	public ResponseEntity<Object> getEmployee(@PathVariable("empId") int empId) {
		Employee e = service.getData(empId);
		if(e!=null) {
			return ResponseEntity.ok().body(e);
		} else {
			ResponseMessageCustom resp = new ResponseMessageCustom("Employee not found.",LocalDateTime.now());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resp);
		}
	}
	
	@GetMapping(path="all")
	public List<Employee> getEmployeeList() {
		List<Employee> e = service.getAllData();
		return e;
	}
	
	@PostMapping
	public ResponseEntity<Object> createEmployee(@RequestBody Employee e) {
		try {
			Employee emp = service.createData(e);
			return ResponseEntity.ok().body(emp);
		} catch(DuplicateDataException ex) {
			ResponseMessageCustom resp = new ResponseMessageCustom("Employee already exists.",LocalDateTime.now());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resp);
		}
	}
	
	@PutMapping
	public ResponseEntity<Object> updateEmployee(@RequestBody Employee e) {
		try {
			Employee emp = service.updateData(e);
			return ResponseEntity.ok().body(emp);
		} catch(NonExistentDataAccess ex) {
			ResponseMessageCustom resp = new ResponseMessageCustom("Employee doesn't exist.",LocalDateTime.now());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resp);
		}
	}
	
	@DeleteMapping(path = "{empId}")
	public ResponseEntity<?> deleteEmployee(@PathVariable("empId") int empId) {
	    try {
	        service.deleteData(empId);
	        return ResponseEntity.ok().build();
	    } catch (NonExistentDataAccess ex) {
	        ResponseMessageCustom resp = new ResponseMessageCustom("Employee doesn't exist.", LocalDateTime.now());
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resp);
	    }
	}
}
