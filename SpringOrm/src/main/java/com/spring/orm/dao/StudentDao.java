package com.spring.orm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.orm.entities.Student;

public class StudentDao {

	private HibernateTemplate hTemplate;

	public HibernateTemplate gethTemplate() {
		return hTemplate;
	}

	public void sethTemplate(HibernateTemplate hTemplate) {
		this.hTemplate = hTemplate;
	}

	// save
	@Transactional
	public int insert(Student student) {

		int i = (int) this.hTemplate.save(student);
		return i;

	}

	// get the single data
	public Student getStudent(int studentId) {
		Student student = hTemplate.get(Student.class, studentId);
		return student;
	}

	// get all students
	public List<Student> getAllStudents() {
		List<Student> listAll = this.hTemplate.loadAll(Student.class);
		return listAll;
	}

	// deleting the student
	@Transactional
	public void deleteStudent(int studentId) {
		Student student = hTemplate.get(Student.class, studentId);
		this.hTemplate.delete(student);
	}

	// update student
	@Transactional
	public void updateStudent(Student student) {
		this.hTemplate.update(student);
	}

}
