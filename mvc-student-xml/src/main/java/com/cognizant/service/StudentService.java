package com.cognizant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cognizant.dao.StudentDao;
import com.cognizant.model.Student;

@Service
@Qualifier("StudentService")
public class StudentService {
	@Autowired
	StudentDao studentDao;

	public boolean insert(int id, String name, float marks) {
		return studentDao.insert(new Student(id, name, marks));
	}

	public boolean update(int id, String name, float marks) {
		return studentDao.update(new Student(id, name, marks));
	}

	public boolean delete(int id) {
		return studentDao.delete(new Student(id));
	}
	public List<Student> getAll(){
		return studentDao.getAll();
	}
}
