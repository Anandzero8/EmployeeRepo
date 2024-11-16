package com.webapp.Dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.webapp.Entity.Employee;
import com.webapp.Repository.EmployeeRepository;

@Repository
public class EmployeeDao {

	@Autowired
	EmployeeRepository er;
	
	public String addEmp(Employee e) {
		er.save(e);
		return "saved successfully";
	}
	
	public String addAll(List<Employee> e){
		er.saveAll(e);
		return "all saved successfully";
	}
	
	public String deleteEmp(int id) {
		er.deleteById(id);
		return "Deleted";
	}
	
	public String updateEmp(Employee e) {
		er.save(e);
		return "updated";
	}
	public List<Employee> getAll(){
		return er.findAll();
	}
	public Employee getEmp(int id) {
		return er.findById(id).get();
	}
	public List<Employee> get23(){
		return er.findAll();
	}
	public Long getEmpCount(String gender) {
		return er.count();
	}
	public List<Employee> getMaleEmp(){
		return er.findAll();
	}
	
	//native query
	public List<Employee> getAlls(){
		return er.findAll();
	}
	public int maxSalary() {
		return er.maxSalary();
	}
	public List<String> getNames(){
		return er.getNames();
	}
	public Map<Integer,String> getNamess(){
		return er.getNamess();
	}
	public List<Employee> getSalary(int a, int b){
		return er.getSalary(a, b);
	}
	public List<Employee> getA(){
		return er.findAll();
	}
	public List<Employee> getAge(int a){
		return er.getAge(a);
	}
	public String ageNotValid(Employee e) {
		 er.save(e);
		 return "success";
	}
	public String NameNotValid(Employee e) {
		er.save(e);
		return "employee created success";
	}
}
