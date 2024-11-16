package com.student.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.Dao.StudentDao;
import com.student.Entity.Student;
import com.student.Exceptions.AgeException;

@Service
public class StudentService {
	
	@Autowired
	StudentDao sd;

	public String addStudents(List<Student> slist){
		return sd.addStudents(slist);
	}
	public List<Student> getAllStudent(){
		return sd.getAllStudent();
	}
	
	public Student getStu(int id) {
		return sd.getStu(id);
	}
	public String updateStu(Student s) {
		s.setName(s.getName());
		s.setAge(s.getAge());
		s.setAttendance(s.getAttendance());
		s.setCourse(s.getCourse());
		s.setGender(s.getGender());
		s.setRoll_number(s.getRoll_number());
		return sd.updateStu(s);
	}
	public String deleteStu(int id) {
		return sd.deleteStu(id);
	}
	public String addStu(Student s) throws AgeException {
		if(s.getAge()<18) {
			throw new AgeException();
		}
		return sd.addStu(s);
	}
}
