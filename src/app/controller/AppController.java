package app.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import app.DAO.ClassroomDAO;
import app.DAO.GroupDAO;
import app.DAO.StudentDAO;
import app.DAO.TeacherDAO;
import app.entity.Classroom;
import app.entity.Group;
import app.entity.Student;
import app.entity.Teacher;

@Controller
public class AppController {
	@Autowired
	private StudentDAO students;
	@Autowired
	private GroupDAO groups;
	@Autowired 
	private TeacherDAO teachers;
	@Autowired
	private ClassroomDAO classrooms;
	
	@RequestMapping("/students")
	public String students(Model model) {
		List<Student> studentList = students.getStudents();
		model.addAttribute("students", studentList);
		return "students";
	}
	
	@RequestMapping("/classrooms")
	public String classrooms(Model model) {
		List<Classroom> classroomList = classrooms.getClassrooms();
		model.addAttribute("classrooms",classroomList);
		return "classrooms";
	}
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/login")
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView("login");
		return modelAndView;
	}
	
	@GetMapping("/studentDetails")
	public String studentDetails(@RequestParam("id") int id,Model model) {
		Student student = students.getStudent(id);
		Group group = groups.getGroup(student.getGroupID());
		model.addAttribute("student",student);
		model.addAttribute("group",group);
		return "student_details";
	}
	
	@GetMapping("/deleteStudent")
	public String deleteStudent(@RequestParam("id") int id) {
		students.deleteStudent(id);
		return "redirect:/students";
	}
	
	@GetMapping("/edit_student")
	public String editStudent(@RequestParam("id") int id,Model model) {
		Student student = students.getStudent(id);
		List<Group> groupList = groups.getGroups();
		model.addAttribute("student",student);
		model.addAttribute("groups",groupList);
		return "edit_student";
	}
	
	@PostMapping("/updateStudent")
	public String updateStudent(@ModelAttribute("student") Student student,@RequestParam("old_group_id") int old_group_id) {
		int studentsInTheOldGroup = students.countStudents(old_group_id);
		Group old_group = groups.getGroup(old_group_id);
		if(old_group != null) {
			old_group.setNumberOfStudents(studentsInTheOldGroup);
			groups.updateGroup(old_group);
		}
		
		if(student.getGroupID() == 0) {
			student.setGroupID(null);
		}
		if(student.getGroupID() != 0) {
			Group group = groups.getGroup(student.getGroupID());
			Classroom classroom = classrooms.getClassroom(group.getClassroomID());
			if(classroom != null) {
				if(group.getNumberOfStudents() == classroom.getCapacity()) {
					return "redirect:/edit_student?error_fullgroup&id="+student.getStudentID();
				}
				else {
					students.updateStudent(student);
					int studentsInTheGroup = students.countStudents(student.getGroupID());
					group.setNumberOfStudents(studentsInTheGroup);
					groups.updateGroup(group);
					return "redirect:/studentDetails/?id="+student.getStudentID();
				}
			}
			int studentsInTheGroup = students.countStudents(student.getGroupID());
			group.setNumberOfStudents(studentsInTheGroup);
			groups.updateGroup(group);
			students.updateStudent(student);
			return "redirect:/studentDetails/?id="+student.getStudentID();
		}
		else {
			students.updateStudent(student);
			return "redirect:/studentDetails/?id="+student.getStudentID();
		}
	}
	
	@RequestMapping("/groups")
	public String groups(Model model) {
		List<Group> groupList = groups.getGroups();
		model.addAttribute("groups",groupList);
		return "groups";
	}
	
	@RequestMapping("/groupDetails")
	public String groupDetails(@RequestParam("id") int id,Model model) {
		Group group = groups.getGroup(id);
		List<Student> studentList = students.getStudentsInGroup(id);
		Teacher teacher = teachers.getTeacher(group.getTeacherID());
		Classroom classroom = classrooms.getClassroom(group.getClassroomID());
		model.addAttribute("group", group);
		model.addAttribute("students", studentList);
		model.addAttribute("classroom",classroom);
		if(teacher != null) {
			String teacherName = teacher.getFirstName()+" "+teacher.getLastName();
			model.addAttribute("teacher",teacherName);
		}
		else {
			model.addAttribute("teacher","None");
		}
		if(classroom != null) {
			String classroomName = classroom.getClassroomName();
			model.addAttribute("classroom",classroomName);
		}
		else {
			model.addAttribute("classroom","None");
		}
		return "group_details";
	}
	
	@RequestMapping("/deleteGroup")
	public String deleteGroup(@RequestParam("id") int id) {
		/*
		 * List<Student> studentsInGroup = students.getStudentsInGroup(id); for
		 * (Iterator studentIterator = studentsInGroup.iterator();
		 * studentIterator.hasNext();) { Student student = (Student)
		 * studentIterator.next(); student.setGroupID(0);
		 * students.updateStudent(student); }
		 */
		groups.deleteGroup(id);
		return "redirect:/groups";
	}
	
	@RequestMapping("/add_student")
	public String add_student(Model model) {
		Student student = new Student();
		List<Group> groupList = groups.getGroups();
		model.addAttribute("student",student);
		model.addAttribute("groups",groupList);
		return "add_student";
	}
	
	@RequestMapping("/addStudent")
	public String addStudent(@ModelAttribute("student") Student student) {
		if(student.getGroupID() == 0) {
			student.setGroupID(null);
		}
		if(student.getGroupID() != 0) {
			int studentsInTheGroup = students.countStudents(student.getGroupID());
			Group group = groups.getGroup(student.getGroupID());
			Classroom classroom = classrooms.getClassroom(group.getClassroomID());
			if(classroom != null) {
				if(group.getNumberOfStudents() == classroom.getCapacity()) {
					return "redirect:/add_student?error_fullgroup";
				}
				else {
					students.addStudent(student);
					group.setNumberOfStudents(studentsInTheGroup + 1);
					groups.updateGroup(group);
					return "redirect:students";
				}
			}
			students.addStudent(student);
			group.setNumberOfStudents(studentsInTheGroup + 1);
			groups.updateGroup(group);
			return "redirect:students";
		}
		else {
			students.addStudent(student);
			return "redirect:students";
		}
	}
	
	@RequestMapping("/teachers")
	public String teachers(Model model) {
		List<Teacher> teacherList = teachers.getTeachers();
		model.addAttribute("teachers",teacherList);
		return "teachers";
	}
	
	@RequestMapping("/add_group")
	public String add_group(Model model) {
		Group group = new Group();
		List<Classroom> classroomList = classrooms.getClassrooms();
		List<Teacher> teacherList = teachers.getTeachers();
		model.addAttribute("classrooms",classroomList);
		model.addAttribute("group",group);
		model.addAttribute("teachers",teacherList);
		return "add_group";
	}
	
	@RequestMapping("/addGroup")
	public String addGroup(@ModelAttribute("group") Group group) {
		Group g = groups.getGroup(group.getDay(), group.getTime(),group.getClassroomID());
		if(g != null) {
			return "redirect:/add_group?error_daytime";
		}
		if(group.getClassroomID() == 0) {
			group.setClassroomID(null);
		}
		if(group.getTeacherID() == 0) {
			group.setTeacherID(null);
		}
		groups.addGroup(group);
		return "redirect:groups";
	}
	
	@GetMapping("/edit_group")
	public String editGroup(@RequestParam("id") int id,Model model) {
		Group group = groups.getGroup(id);
		List<Teacher> teacherList = teachers.getTeachers();
		List<Classroom> classroomList = classrooms.getClassrooms();
		model.addAttribute("group",group);
		model.addAttribute("teachers",teacherList);
		model.addAttribute("classrooms",classroomList);
		return "edit_group";
	}
	
	@PostMapping("/updateGroup")
	public String updateGroup(@ModelAttribute("group") Group group) {
		Group g = groups.getGroup(group.getDay(), group.getTime(), group.getClassroomID());
		Classroom c = classrooms.getClassroom(group.getClassroomID());
		if(g != null && (g.getGroupID() != group.getGroupID())){
			return "redirect:/edit_group?error_daytime&id="+group.getGroupID();
		}
		System.out.println(group.getNumberOfStudents());
		System.out.println(c.getCapacity());
		if(group.getNumberOfStudents() > c.getCapacity()) {
			return "redirect:/edit_group?error_capacity&id="+group.getGroupID();
		}
		if(group.getClassroomID() == 0) {
			group.setClassroomID(null);
		}
		if(group.getTeacherID() == 0) {
			group.setTeacherID(null);
		}
		int studentsInTheGroup = students.countStudents(group.getGroupID());
		group.setNumberOfStudents(studentsInTheGroup);
		groups.updateGroup(group);
		return "redirect:/groupDetails/?id="+group.getGroupID();
	}
	
	@RequestMapping("/add_teacher")
	public String add_teacher(Model model) {
		Teacher teacher = new Teacher();
		List<Group> groupList = groups.getGroups();
		model.addAttribute("teacher",teacher);
		model.addAttribute("groups",groupList);
		return "add_teacher";
	}
	
	@PostMapping("/addTeacher")
	public String addTeacher(@ModelAttribute("teacher") Teacher teacher) {
		teachers.addTeacher(teacher);
		return "redirect:teachers";
	}
	
	@RequestMapping("/teacherDetails")
	public String teacherDetails(@RequestParam("id") int id,Model model) {
		Teacher teacher = teachers.getTeacher(id);
		model.addAttribute("teacher",teacher);
		return "teacher_details";
	}
	
	@RequestMapping("/edit_teacher")
	public String edit_teacher(@RequestParam("id") int id,Model model) {
		Teacher teacher = teachers.getTeacher(id);
		List<Group> groupList = groups.getGroups();
		model.addAttribute("teacher",teacher);
		model.addAttribute("groups",groupList);
		return "edit_teacher";
	}
	
	@PostMapping("/updateTeacher")
	public String updateTeacher(@ModelAttribute("teacher") Teacher teacher) {
		teachers.updateTeacher(teacher);
		return "redirect:teachers";
	}
	
	@RequestMapping("/deleteTeacher")
	public String deleteTeacher(@RequestParam("id") int id) {
		teachers.deleteTeacher(id);
		return "redirect:/teachers";
	}
	
	@RequestMapping("/add_classroom")
	public String add_classroom(Model model) {
		Classroom classroom = new Classroom();
		model.addAttribute("classroom",classroom);
		return "add_classroom";
	}
	
	@PostMapping("/addClassroom")
	public String addClassroom(@ModelAttribute("classroom") Classroom classroom) {
		classrooms.addClassroom(classroom);
		return "redirect:/classrooms";
	}
	
	@RequestMapping("/classroomDetails")
	public String classroomDetails(@RequestParam("id") int classroomID,Model model) {
		Classroom classroom = classrooms.getClassroom(classroomID);
		List<Group> groupsInClassroom = groups.getGroupsInClassroom(classroomID);
		model.addAttribute("groups",groupsInClassroom);
		model.addAttribute("classroom",classroom);
		return "classroom_details";
	}
	
	@RequestMapping("/edit_classroom")
	public String editClassroom(@RequestParam("id") int classroomID,Model model) {
		Classroom classroom = classrooms.getClassroom(classroomID);
		model.addAttribute("classroom",classroom);
		return "edit_classroom";
	}
	
	@PostMapping("/updateClassroom")
	public String updateClassroom(@ModelAttribute("classroom") Classroom classroom) {
		classrooms.updateClassroom(classroom);
		return "redirect:/classroomDetails/?id="+classroom.getClassroomID();
	}
	
	@RequestMapping("/deleteClassroom")
	public String deleteClassroom(@RequestParam("id") int classroomID) {
		classrooms.deleteClassroom(classroomID);
		return "redirect:/classrooms";
	}
}


