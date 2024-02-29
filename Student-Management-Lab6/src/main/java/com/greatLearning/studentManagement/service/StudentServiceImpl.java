package com.greatLearning.studentManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatLearning.studentManagement.entity.Student;
import com.greatLearning.studentManagement.repository.StudentRepository;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;

	public List<Student> findAll() {

		List<Student> students = studentRepository.findAll();
		return students;
	}

	public Student findById(int id) {

		Student student = new Student();
		student = studentRepository.findById(id).get();
		return student;
	}

	public void save(Student theStudent) {

		studentRepository.save(theStudent);
	}

	public void deleteById(int id) {

		studentRepository.deleteById(id);
	}

}