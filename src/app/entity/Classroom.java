package app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="classroom")
@Table(name="classrooms")
public class Classroom {
	@Id
	@Column(name="id")
	private int classroomID;
	@Column(name = "classroom_name")
	private String classroomName;
	@Column(name="adress")
	private String adress;
	@Column(name="capacity")
	private int capacity;
	
	public int getClassroomID() {
		return classroomID;
	}
	public void setClassroomID(int classroomID) {
		this.classroomID = classroomID;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	public String getClassroomName() {
		return classroomName;
	}
	public void setClassroomName(String classroomName) {
		this.classroomName = classroomName;
	}
	@Override
	public String toString() {
		return "Classroom [classroomID=" + classroomID + ", adress=" + adress + ", capacity=" + capacity + "]";
	}
	
}
