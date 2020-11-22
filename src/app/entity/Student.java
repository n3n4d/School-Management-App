package app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "student")
@Table(name = "student")
public class Student {
	@Id
	@Column(name = "id")
	private int studentID;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "email")
	private String email;
	@Column(name = "birth_year")
	private int birthYear;
	@Column(name = "phone")
	private String phone;
	@Column(name = "group_id")
	private Integer groupID;
	
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getBirthYear() {
		return birthYear;
	}
	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getGroupID() {
		if(groupID != null) {
			return groupID.intValue();
		}
		else {
			return 0;
		}
		
	}
	public void setGroupID(Integer groupID) {
		if(groupID != null) {
			this.groupID = groupID.intValue();
		}
		else {
			this.groupID = groupID;
		}
	}
	
	@Override
	public String toString() {
		return "Student [studentID=" + studentID + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", birthYear=" + birthYear + ", phone=" + phone + "]";
	}
}
