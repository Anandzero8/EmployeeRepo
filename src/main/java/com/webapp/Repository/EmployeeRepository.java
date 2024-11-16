package com.webapp.Repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.webapp.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
	
	boolean existsByName(String name);
	
	@Query(value = "select * from employee_details", nativeQuery=true)
	public List<Employee> getAlls();

	@Query(value = "select salary from employee_details order by(experience) desc limit 1`",
			nativeQuery=true)
	public int maxSalary();
	
	@Query(value = "select name, salary from employee_details where length(name)=5", nativeQuery=true)
	public List<String> getNames();
	
	@Query(value = "select id,name from employee_details", nativeQuery=true)
	public Map<Integer,String> getNamess();
	
	@Query(value = "select * from employee_details where salary > ? and salary < ?", nativeQuery=true)
	public List<Employee> getSalary(int a, int b);
	
	@Query("select a from Employee a")
	public List<Employee> getA();
	
	@Query(value = "select * from Employee where name like 'a%'",nativeQuery=true)
	public List<Employee> getFirst(String a );
	
	@Query(value = ("select a from Employee a where a.age>:x"))
	public List<Employee> getAge(@Param("x") int a);
	
	
	
}
