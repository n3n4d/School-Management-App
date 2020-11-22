package app.DAO;

import java.util.List;

import app.entity.Group;

public interface GroupDAO {
	public List<Group> getGroups();
	public Group getGroup(int id);
	public void updateGroup(Group group);
	public void deleteGroup(int id);
	public void addGroup(Group group);
	public List<Group> getGroupsInClassroom(int classroomID);
	public Group getGroup(String day,String time,int classroomID);
}
