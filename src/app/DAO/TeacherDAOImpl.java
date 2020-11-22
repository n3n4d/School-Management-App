package app.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import app.entity.Student;
import app.entity.Teacher;

@Repository
public class TeacherDAOImpl implements TeacherDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Teacher> getTeachers(){
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Teacher> theQuery = currentSession.createQuery("from teacher", Teacher.class);
		List<Teacher> teacherList = theQuery.getResultList();
		return teacherList;
	}
	
	/*
	 * @Override
	 * 
	 * @Transactional public Teacher getGroupTeacher(int groupID){ Session
	 * currentSession = sessionFactory.getCurrentSession(); Query<Teacher> theQuery
	 * = currentSession.createQuery("from teacher where groupID=:groupID",Teacher.
	 * class); theQuery.setParameter("groupID", groupID); List<Teacher> teacherList
	 * = theQuery.getResultList(); Teacher teacher = null;
	 * if(!teacherList.isEmpty()) { teacher = teacherList.get(0); return teacher; }
	 * else { return teacher; } }
	 */

	@Override
	@Transactional
	public void addTeacher(Teacher teacher) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(teacher);
	}

	@Override
	@Transactional
	public Teacher getTeacher(int teacherID) {
		Session currentSession = sessionFactory.getCurrentSession();
		Teacher teacher = currentSession.get(Teacher.class, teacherID);
		return teacher;
	}

	@Override
	@Transactional
	public void updateTeacher(Teacher teacher) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.update(teacher);
	}

	@Override
	@Transactional
	public void deleteTeacher(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("delete from teacher where id=:teacherID");
		theQuery.setParameter("teacherID", id);
		theQuery.executeUpdate();
	}
}
