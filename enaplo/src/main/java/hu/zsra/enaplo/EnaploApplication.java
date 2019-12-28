package hu.zsra.enaplo;

import hu.zsra.enaplo.model.Classroom;
import hu.zsra.enaplo.model.Course;
import hu.zsra.enaplo.model.exam.Exam;
import hu.zsra.enaplo.model.exam.ExamType;
import hu.zsra.enaplo.model.user.Parent;
import hu.zsra.enaplo.model.user.Student;
import hu.zsra.enaplo.model.user.Teacher;
import hu.zsra.enaplo.service.ClassroomService;
import hu.zsra.enaplo.service.CourseService;
import hu.zsra.enaplo.service.ExamService;
import hu.zsra.enaplo.service.user.StudentService;
import hu.zsra.enaplo.service.user.TeacherService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class EnaploApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EnaploApplication.class, args);
	}

	@Autowired
	private StudentService studentService;
	@Autowired
	private ClassroomService classroomService;
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private CourseService courseService;
	@Autowired
	private ExamService examService;

	@Override
	public void run(String... args) throws Exception {
	}

	private void insertData() {
		Parent parent1 = new Parent("parent1", "parent1", "parent1_f", "",
				"parent1_l", LocalDate.parse("1970-01-01"), "parent1@parent1.hu", "22222");
		Parent parent2 = new Parent("parent2", "parent2", "parent2_f", "",
				"parent2_l", LocalDate.parse("1970-01-01"), "parent2@parent2.hu", "33333");
		Parent parent3 = new Parent("parent3", "parent3", "parent3_f", "",
				"parent3_l", LocalDate.parse("1970-01-01"), "parent3@parent3.hu", "44444");
		Parent parent4 = new Parent("parent4", "parent4", "parent4_f", "",
				"parent4_l", LocalDate.parse("1970-01-01"), "parent4@parent4.hu", "55555");

		Set<Parent> parents1 = new HashSet<>();
		parents1.add(parent1);
		parents1.add(parent2);

		Set<Parent> parents2 = new HashSet<>();
		parents2.add(parent3);

		Set<Parent> parents3 = new HashSet<>();
		parents3.add(parent4);

		Teacher teacher1 = new Teacher("teacher1", "teacher1", "teacher1",
				"teacher1", "teacher1", "teacher1", "teacher1");
		Teacher teacher2 = new Teacher("teacher2", "teacher2", "teacher2",
				"teacher2", "teacher2", "teacher2", "teacher2");

		teacherService.create(teacher1);
		teacherService.create(teacher2);

		Classroom classroom = new Classroom(2004, 2009, 9, 'a', teacher1);

		classroom.setHeadTeacher(teacher1);
		classroomService.create(classroom);

		Student student1 = new Student("student1", "student1", "student_f1",
				"", "student_l1", LocalDate.parse("1990-01-02"),"address1", "ddd", "aaa", classroom, parents1);
		Student student2 = new Student("student2", "student2", "student_f2",
				"", "student_l2", LocalDate.parse("1990-01-02"), "address2", "ccc", "uuu", classroom);
		Student student3 = new Student("student3", "student3", "student_f3",
				"", "student_l3", LocalDate.parse("1990-01-02"),"address3", "ggg", "jjj", classroom, parents2);
		Student student4 = new Student("student4", "student4", "student_f4",
				"", "student_l4", LocalDate.parse("1990-01-02"), "address4","hhh", "kkk", classroom, parents3);

		Course course1 = new Course("Magyar", 9, "", teacher1);
		Course course2 = new Course("Nyelvtan", 9, "", teacher1);
		Course course3 = new Course("Matek", 9, "", teacher2);
		Course course4 = new Course("Fizika", 9, "", teacher2);

		courseService.create(course1);
		courseService.create(course2);
		courseService.create(course3);
		courseService.create(course4);

		Set<Course> courseList = new HashSet<>();
		courseList.add(course1);
		courseList.add(course2);
		courseList.add(course3);
		courseList.add(course4);

		List<Student> studentList = new LinkedList<>();
		studentList.add(student1);
		studentList.add(student2);
		studentList.add(student3);
		studentList.add(student4);

		for (Student student: studentList) {
			student.setCourses(courseList);
			studentService.create(student);
		}

		Exam exam1 = new Exam(ExamType.EXAM, 3, course1, student1);
		Exam exam2 = new Exam(ExamType.EXAM, 2, course2, student1);
		Exam exam3 = new Exam(ExamType.EXAM, 3, course1, student2);
		Exam exam4 = new Exam(ExamType.EXAM, 5, course3, student2);
		Exam exam5 = new Exam(ExamType.EXAM, 4, course1, student3);
		Exam exam6 = new Exam(ExamType.EXAM, 4, course4, student3);
		Exam exam7 = new Exam(ExamType.EXAM, 1, course2, student4);
		Exam exam8 = new Exam(ExamType.EXAM, 3, course3, student4);

		examService.create(exam1);
		examService.create(exam2);
		examService.create(exam3);
		examService.create(exam4);
		examService.create(exam5);
		examService.create(exam6);
		examService.create(exam7);
		examService.create(exam8);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
