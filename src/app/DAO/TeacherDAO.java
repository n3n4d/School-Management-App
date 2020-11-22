package app.DAO;

import java.util.List;

import app.entity.Teacher;

public interface TeacherDAO {
//	public Teacher getGroupTeacher(int groupID);
	public List<Teacher> getTeachers();
	public void addTeacher(Teacher teacher);
	public Teacher getTeacher(int teacherID);
	public void updateTeacher(Teacher teacher);
	public void deleteTeacher(int id);
}
