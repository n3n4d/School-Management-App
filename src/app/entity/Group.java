package app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "group")
@Table(name = "groups")
public class Group {
	@Id
	@Column(name = "id")
	private int groupID;
	@Column(name = "group_name")
	private String groupName;
	@Column(name = "classroom_id")
	private Integer classroomID;
	@Column(name = "teacher_id")
	private Integer teacherID;
	@Column(name = "number_of_students")
	private int numberOfStudents;
	@Column(name = "day")
	private String day;
	@Column(name = "time")
	private String time;
	
	public int getGroupID() {
		return groupID;
	}

	public void setGroupID(int groupID) {
		this.groupID = groupID;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public int getClassroomID() {
		if(classroomID != null) {
			return classroomID.intValue();
		}
		else {
			return 0;
		}
	}

	public void setClassroomID(Integer classroomID) {
		if(classroomID != null) {
			this.classroomID = classroomID.intValue();
		}
		else {
			this.classroomID = classroomID;
		}
	}

	public int getNumberOfStudents() {
		return numberOfStudents;
	}

	public void setNumberOfStudents(int numberOfStudents) {
		this.numberOfStudents = numberOfStudents;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	public int getTeacherID() {
		if(teacherID != null) {
			return teacherID.intValue();
		}
		else {
			return 0;
		}
	}

	public void setTeacherID(Integer teacherID) {
		if(teacherID != null) {
			this.teacherID = teacherID.intValue();
		}
		else {
			this.teacherID = teacherID;
		}
	}

	@Override
	public String toString() {
		return "Group [groupID=" + groupID + ", groupName=" + groupName + ", classroomID=" + classroomID
				+ ", teacherID=" + teacherID + ", numberOfStudents=" + numberOfStudents + ", day=" + day + ", time="
				+ time + "]";
	}

}
