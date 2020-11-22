package app.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import app.entity.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Student> getStudents() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Student> theQuery = currentSession.createQuery("from student", Student.class);
		List<Student> students = theQuery.getResultList();
		return students;
	}
	
	@Override
	@Transactional
	public Student getStudent(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Student student = currentSession.get(Student.class,id);
		return student;
	}
	
	@Override
	@Transactional
	public void deleteStudent(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("delete from student where id=:studentID");
		theQuery.setParameter("studentID", id);
		theQuery.executeUpdate();
	}
	@Override
	@Transactional
	public void updateStudent(Student student) {
		Session session = sessionFactory.getCurrentSession();
		session.update(student);
	}
	
	@Override
	@Transactional
	public int countStudents(int groupID) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Student> theQuery = currentSession.createQuery("from student where groupID=:groupID", Student.class);
		theQuery.setParameter("groupID", groupID);
		List<Student> students = theQuery.getResultList();
		return students.size();
	}
	
	@Override
	@Transactional
	public List<Student> getStudentsInGroup(int groupID){
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Student> theQuery = currentSession.createQuery("from student where groupID=:groupID",Student.class);
		theQuery.setParameter("groupID", groupID);
		List<Student> students = theQuery.getResultList();
		return students;
	}
	
	@Override
	@Transactional
	public void addStudent(Student student) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(student);
	}

}
