package app.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import app.entity.Group;

@Repository
public class GroupDAOImpl implements GroupDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Group> getGroups() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Group> theQuery = currentSession.createQuery("from group", Group.class);
		List<Group> groups = theQuery.getResultList();
		return groups;
	}
	
	@Override
	@Transactional
	public Group getGroup(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Group group = currentSession.get(Group.class, id);
		return group;
	}
	
	@Override
	@Transactional
	public void updateGroup(Group group) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.update(group);
	}
	
	@Override
	@Transactional
	public void deleteGroup(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("delete from group where groupID=:groupID");
		theQuery.setParameter("groupID", id);
		theQuery.executeUpdate();
	}

	@Override
	@Transactional
	public void addGroup(Group group) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(group);
	}

	@Override
	@Transactional
	public List<Group> getGroupsInClassroom(int classroomID) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Group> theQuery = currentSession.createQuery("from group where classroomID=:classroomID",Group.class);
		theQuery.setParameter("classroomID", classroomID);
		List<Group> groups = theQuery.getResultList();
		return groups;
	}
	
	@Override
	@Transactional
	public Group getGroup(String day,String time,int classroomID) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Group> theQuery = currentSession.createQuery("from group where day=:day and time=:time and classroomID=:classroomID");
		theQuery.setParameter("day", day);
		theQuery.setParameter("time", time);
		theQuery.setParameter("classroomID", classroomID);
		List<Group> groups = theQuery.getResultList();
		if(groups.size() > 0) {
			return groups.get(0);
		}
		else {
			return null;
		}
	}
}
