package com.webapp.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.Dao.EmployeeDao;
import com.webapp.Entity.Employee;
import com.webapp.Exceptions.AgeException;
import com.webapp.Exceptions.NameAlreadyRegisteredException;
import com.webapp.Exceptions.NameNotFoundException;
import com.webapp.Repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeDao ed;
	
	@Autowired
	EmployeeRepository employeeRespository;
	
	public String addEmp(Employee e) {
		return ed.addEmp(e);
	}
	
	public String addAll(List<Employee> e){
		return ed.addAll(e);
	}
	
	public String deleteEmp(int id) {
		return ed.deleteEmp(id);
	}
	public String updateEmp(Employee e) {
		e.setName(e.getName());
		e.setAge(e.getAge());
		e.setGender(e.getGender());
		e.setSalary(e.getSalary());
		e.setExperience(e.getExperience());
		e.setId(e.getId());
		return ed.updateEmp(e);
	}
	public List<Employee> getAll(){
		return ed.getAll();
	}
	public Employee getEmp(int id) {
		return ed.getEmp(id);
	}
	public List<Employee> get23(){
		List<Employee> emps = ed.getAll().stream().filter(r->r.getAge()>23).collect(Collectors.toList());
		//List<Employee> a = emps.stream().filter(e->e.getAge()>23).collect(Collectors.toList());
		return emps;
	}
	public Long getEmpCount(String gender) {
		Long c = ed.getAll().stream().filter(a->a.getGender().equals(gender)).count();
		return c;
	}
	
	public List<Employee> getMaleEmp(){
		return ed.getAll().stream().filter(i->i.getGender().equals("male")).collect(Collectors.toList());
	}
	// native query
	public List<Employee> getAlls(){
		return ed.getAlls();
	}
	public int maxSalary() {
		return ed.maxSalary();
	}
	public List<String> getNames(){
		return ed.getNames();
	}
	public Map<Integer,String> getNamess(){
		return ed.getNamess();
	}
	public List<Employee> getSalary(int a, int b){
		return ed.getSalary(a, b);
	}
	public List<Employee> getA(){
		return ed.getA();
	}
	public List<Employee> getAge(int a){
		return ed.getAge(a);
	}
	public String ageNotValid(Employee e) throws AgeException {
		if(e.getAge() < 18) {
			throw new AgeException("age is not valid");
		}
		return ed.ageNotValid(e);
	}
	public String nameNotValid(Employee e) throws NameNotFoundException {
		if(e.getName().isEmpty()) {
			throw new NameNotFoundException("user should enter employee Name");
		}
		return ed.NameNotValid(e);
	}
	public Employee createEmployee(Employee e) throws NameAlreadyRegisteredException {
		if(employeeRespository.existsByName(e.getName())) {
			throw new NameAlreadyRegisteredException("User with name '" + e.getName() + "' is already registered.");
		}
		return employeeRespository.save(e);
	}
}
