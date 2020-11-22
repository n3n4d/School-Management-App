package app.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import app.entity.Classroom;
import app.entity.Student;

@Repository
public class ClassroomDAOImpl implements ClassroomDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Classroom> getClassrooms() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Classroom> theQuery = currentSession.createQuery("from classroom", Classroom.class);
		List<Classroom> classrooms = theQuery.getResultList();
		return classrooms;
	}

	@Override
	@Transactional
	public void addClassroom(Classroom classroom) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(classroom);
	}

	@Override
	@Transactional
	public Classroom getClassroom(int classroomID) {
		Session currentSession = sessionFactory.getCurrentSession();
		Classroom classroom = currentSession.get(Classroom.class, classroomID);
		return classroom;
	}

	@Override
	@Transactional
	public void updateClassroom(Classroom classroom) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.update(classroom);
	}

	@Override
	@Transactional
	public void deleteClassroom(int classroomID) {
		Session currentSession = sessionFactory.getCurrentSession();
		Classroom classroom = currentSession.get(Classroom.class, classroomID);
		currentSession.delete(classroom);
	}
}
