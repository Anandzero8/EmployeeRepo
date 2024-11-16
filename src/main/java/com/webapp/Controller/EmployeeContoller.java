package com.webapp.Controller;

import java.util.List;
import java.util.Map;

import javax.naming.NameAlreadyBoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.Entity.Employee;
import com.webapp.Exceptions.AgeException;
import com.webapp.Exceptions.NameAlreadyRegisteredException;
import com.webapp.Exceptions.NameNotFoundException;
import com.webapp.Service.EmployeeService;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeContoller {

	@Autowired
	EmployeeService es;
	
	@PostMapping("/addemployee")
	public String addEmp(@RequestBody Employee e) {
		return es.addEmp(e);
	}
	
	@PostMapping("/addall")
	public String addAll(@RequestBody List<Employee> e){
		return es.addAll(e);
	}
	@DeleteMapping("/delete/{id}")
	public String deleteEmp(@PathVariable int id) {
		return es.deleteEmp(id);
	}
	@PutMapping("/updateemployee/{id}")
	public String updateEmp(@RequestBody Employee e) {
		return es.updateEmp(e);
	}
	@GetMapping("/getallemployee")
	public List<Employee> getAll(){
		return es.getAll();
	}
	@GetMapping("getEmp/{id}")
	public Employee getEmp(@PathVariable int id) {
		return es.getEmp(id);
	}
	@GetMapping("/get23")
	public List<Employee> get25(){
		return es.get23();
	}
	@GetMapping("/getempCount/{gender}")
	public Long getEmpCount(@PathVariable String gender) {
		return es.getEmpCount(gender);
	}
	@GetMapping("/getMale")
	public List<Employee> getMaleEmp(){
		return es.getMaleEmp();
	}
	//native query
	@GetMapping("/getalls")
	public List<Employee> getAlls(){
		return es.getAlls();
	}
	@GetMapping("/maxSalary")
	public int maxSalary() {
		return es.maxSalary();
	}
	@GetMapping("/gtname")
	public List<String> getNames(){
		return es.getNames();
	}
	@GetMapping("/gtnames")
	public Map<Integer,String> getNamess(){
		return es.getNamess();
	}
	@GetMapping("/getsalary")
		public List<Employee> getSalary(@RequestParam int a,@RequestParam int b){
			return es.getSalary(a, b);
		}
	@GetMapping("/getA")
	public List<Employee> getA(){
		return es.getA();
	}
	@GetMapping("/getAge/{a}")
	public List<Employee> getAge(@PathVariable int a){
		return es.getAge(a);
	}
	@PostMapping("/addAge")
	public String ageNotValid(@RequestBody Employee e) throws AgeException {
		return es.ageNotValid(e); 
	}
	@PostMapping("/addNameException")
	public String nameNotValid(@RequestBody Employee e) throws NameNotFoundException {
		return es.nameNotValid(e);
	}
	@PostMapping("/createEmployee")
	public Employee createEmpWithoutName(@RequestBody Employee e) throws NameAlreadyBoundException, NameAlreadyRegisteredException {
		return es.createEmployee(e);
	}
}
