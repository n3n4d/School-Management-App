package app.DAO;

import java.util.List;

import app.entity.Classroom;

public interface ClassroomDAO {
	public List<Classroom> getClassrooms();

	public void addClassroom(Classroom classroom);

	public Classroom getClassroom(int classroomID);

	public void updateClassroom(Classroom classroom);

	public void deleteClassroom(int classroomID);
}
