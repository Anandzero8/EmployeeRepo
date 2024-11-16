package com.student.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.student.Entity.Student;
import com.student.Repository.StudentRepo;

@Repository
public class StudentDao {

	@Autowired
	StudentRepo sr;
	
	public String addStudents(List<Student> slist){
		 sr.saveAll(slist);
		 return "Saved successfully";
	}
	public List<Student> getAllStudent(){
		return sr.findAll();
	}
	public Student getStu(int id) {
		return sr.findById(id).get();
	}
	public String updateStu(Student s) {
		sr.save(s);
		return "updated successfully";
	}
	public String deleteStu(int id) {
		sr.deleteById(id);
		return "student deleted";
	}
	public String addStu(Student s) {
		sr.save(s);
		return "created successfully";
	}
}
