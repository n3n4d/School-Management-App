package app.DAO;

import java.util.List;

import app.entity.Student;

public interface StudentDAO {
	public List<Student> getStudents();
	public Student getStudent(int id);
	public void deleteStudent(int id);
	public void updateStudent(Student student);
	public int countStudents(int groupID);
	public List<Student> getStudentsInGroup(int groupID);
	public void addStudent(Student student);
}
