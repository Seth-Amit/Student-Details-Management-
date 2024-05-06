package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		StudentDao studentDao = (StudentDao) context.getBean("studentDao");
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		boolean go = true;
		while (go) {
			System.out.println("PRESS 1 for add new student");
			System.out.println("PRESS 2 for display all student");
			System.out.println("PRESS 3 for get detail of single student");
			System.out.println("PRESS 4 for delete student");
			System.out.println("PRESS 5 for update student");
			System.out.println("PRESS 6 for Exit");

			try {

				int input = Integer.parseInt(bReader.readLine());

				switch (input) {
				case 1:
					System.out.println("Enter Student Id");
					int id = Integer.parseInt(bReader.readLine());
					System.out.println("Enter Student Name");
					String name = bReader.readLine();
					System.out.println("Enter Student City");
					String city = bReader.readLine();
					Student student = new Student(id, name, city);

					int r = studentDao.insert(student);
					System.out.println(r + " " + "Student Added Succesfully!!");
					System.out.println("**************************************");
					System.out.println();

					break;
				case 2:
					// display all student
					System.out.println("*********************************");
					List<Student> allList = studentDao.getAllStudents();
					for (Student st : allList) {
						System.out.println("Id : " + st.getId());
						System.out.println("Name : " + st.getName());
						System.out.println("City : " + st.getCity());
						System.out.println("___________________________________");
					}
					System.out.println("************************************");

					break;
				case 3:
					// display single student
					System.out.println("Enter Student Id");
					int id1 = Integer.parseInt(bReader.readLine());
					Student st = studentDao.getStudent(id1);
					System.out.println("Id : " + st.getId());
					System.out.println("Name : " + st.getName());
					System.out.println("City : " + st.getCity());
					System.out.println("___________________________________");

					break;
				case 4:
					// add delete student
					System.out.println("Enter Student Id");
					int id2 = Integer.parseInt(bReader.readLine());
					studentDao.deleteStudent(id2);
					System.out.println("student deleted");
					break;
				case 5:
					System.out.println("Enter Student Id");
					int id4 = Integer.parseInt(bReader.readLine());
					Student ss = studentDao.getStudent(id4);
					System.out.println("Id : " + ss.getId());
					System.out.println("Name : " + ss.getName());
					System.out.println("City : " + ss.getCity());
					System.out.println("___________________________________");

					System.out.println("Enter Student Name");
					String name1 = bReader.readLine();
					ss.setName(name1);
					System.out.println("Enter Student City");
					String city1 = bReader.readLine();
					ss.setCity(city1);
					studentDao.updateStudent(ss);
					System.out.println("update succesful");
					System.out.println("****************************************");

					break;
				case 6:
					// add exit student
					go = false;
					break;

				}

			} catch (Exception e) {

				System.out.println("Invalid Input try with another one");
				System.out.println(e.getMessage());
			}

			System.out.println("Thankyou for using my application ");

		}

	}
}
