package com.student.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.Entity.Student;
import com.student.Exceptions.AgeException;
import com.student.Service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentService ss;
	
	@PostMapping("/addAllStudents")
	public String addStudents(@RequestBody List<Student> slist){
		return ss.addStudents(slist);
	}
	
	@GetMapping("/getAllStudent")
	public List<Student> getAllStudentDetails() {
		return ss.getAllStudent();
	}
	
	@GetMapping("/getStudent/{id}")
	public Student getStu(@PathVariable int id) {
		return ss.getStu(id);
	}
	@PutMapping("/updateStu")
	public String updateStu(@RequestBody Student s) {
		return ss.updateStu(s);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteStu(@PathVariable int id) {
	return ss.deleteStu(id);
}
	@PostMapping("/addStudent")
	public String addStudentWithExc(@RequestBody Student s) throws AgeException{
		return ss.addStu(s);
	}
}
