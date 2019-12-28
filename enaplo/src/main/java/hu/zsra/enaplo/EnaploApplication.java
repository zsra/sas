package hu.zsra.enaplo;

import hu.zsra.enaplo.exception.ResourceNotFoundException;
import hu.zsra.enaplo.model.*;
import hu.zsra.enaplo.model.exam.Exam;
import hu.zsra.enaplo.model.exam.ExamType;
import hu.zsra.enaplo.model.user.Admin;
import hu.zsra.enaplo.model.user.Parent;
import hu.zsra.enaplo.model.user.Student;
import hu.zsra.enaplo.model.user.Teacher;
import hu.zsra.enaplo.service.*;
import hu.zsra.enaplo.service.user.AdminService;
import hu.zsra.enaplo.service.user.StudentService;
import hu.zsra.enaplo.service.user.TeacherService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.*;

@SpringBootApplication
public class EnaploApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EnaploApplication.class, args);
	}

	@Autowired
	private AdminService adminService;
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
	@Autowired
	private TimeTableService timeTableService;
	@Autowired
	private ReportService reportService;
	@Autowired
	private RemarkService remarkService;

	@Override
	public void run(String... args) throws Exception {
		//insertData();
	}

	private void insertData() throws ResourceNotFoundException {
		Parent parent1 = new Parent("parent1", "parent1", "Éva", "", "Kiss",
				LocalDate.of(1978, 7, 12), "parent1@gmail.com", "06301112222");
		Parent parent4 = new Parent("parent4", "parent4", "Ádám", "", "Kiss",
				LocalDate.of(1976, 5, 11), "parent4@gmail.com", "06309998888");

		Parent parent2 = new Parent("parent2", "parent2", "Antal", "", "Zsákai",
				LocalDate.of(1979, 2, 5), "parent2@gmail.com", "06201152442");

		Parent parent3 = new Parent("parent3", "parent3", "János", "", "Gulyás",
				LocalDate.of(1977, 12, 20), "parent3@gmail.com", "06307778888");

		Parent parent5 = new Parent("parent5", "parent5", "Kata", "", "Hegedűs",
				LocalDate.of(1980, 1, 25), "parent5@gmail.com", "06304443333");
		Parent parent6 = new Parent("parent6", "parent6", "Viktor", "", "Hegedűs",
				LocalDate.of(1977, 8, 3), "parent6@gmail.com", "06306662222");

		Parent parent7 = new Parent("parent7", "parent7", "Péter", "", "Fazekas",
				LocalDate.of(1980, 5, 17), "parent7@gmail.com", "06309998877");

		Parent parent8 = new Parent("parent8", "parent8", "Vica", "", "Kerekes",
				LocalDate.of(1980, 7, 22), "parent8@gmail.com", "06702323232");

		Teacher teacher1 = new Teacher("teacher1", "teacher1",
				"Péter", "", "Jánosi", "tanar1@gmail.com", "0630111111");
		Teacher teacher2 = new Teacher("teacher2", "teacher2",
				"Katalin", "", "Hegyesi", "tanar2@gmail.com", "0630222222");
		Teacher teacher3 = new Teacher("teacher3", "teacher3",
				"József", "", "Benedek", "tanar3@gmail.com", "0630444444");
		Teacher teacher4 = new Teacher("teacher4", "teacher4",
				"Ilona", "", "Piroska", "tanar4@gmail.com", "0630555555");
		Teacher teacher5 = new Teacher("teacher5", "teacher5",
				"Erika", "", "Szőke", "tanar5@gmail.com", "0630666666");

		teacherService.create(teacher1);
		teacherService.create(teacher2);
		teacherService.create(teacher3);
		teacherService.create(teacher4);
		teacherService.create(teacher5);

		Classroom classroom = new Classroom(2017, 2021, 9, 'a', teacher1);
		classroomService.create(classroom);

		Course course1 = new Course("Magyar nyelvtan", 9, "", teacher1);
		Course course2 = new Course("Magyar irodalom", 9, "", teacher1);
		Course course3 = new Course("Matematika", 9, "", teacher2);
		Course course4 = new Course("Fizika", 9, "", teacher3);
		Course course5 = new Course("Angol", 9, "", teacher4);
		Course course6 = new Course("Kémia", 9, "", teacher5);
		Course course7 = new Course("Történelem", 9, "", teacher4);

		courseService.create(course1);
		courseService.create(course2);
		courseService.create(course3);
		courseService.create(course4);
		courseService.create(course5);
		courseService.create(course6);
		courseService.create(course7);

		Set<Parent> student1_parent = new HashSet<>();
		student1_parent.add(parent1);
		student1_parent.add(parent4);
		Student student1 = new Student("student1", "student1", "Alex", "", "Kiss",
				LocalDate.of(2004, 3, 30), "Virág utca 22.",
				"0123456780", "333/222-444", classroom, student1_parent);
		Set<Parent> student2_parent = new HashSet<>();
		student2_parent.add(parent2);
		Student student2 = new Student("student2", "student2", "Vivien", "", "Zsákai",
				LocalDate.of(2004, 2, 20), "Hős utca 11.",
				"0123456732", "333/555-444", classroom, student2_parent);
		Set<Parent> student3_parent = new HashSet<>();
		student3_parent.add(parent3);
		Student student3 = new Student("student3", "student3", "Loretta", "", "Gulyás",
				LocalDate.of(2004, 1, 21), "Vitéz utca 6.",
				"0123423473", "333/555-666", classroom, student3_parent);
		Set<Parent> student4_parent = new HashSet<>();
		student4_parent.add(parent5);
		student4_parent.add(parent6);
		Student student4 = new Student("student4", "student4", "Dávid", "", "Hegedűs",
				LocalDate.of(2003, 11, 2), "Vajda utca 7.",
				"0128675673", "333/555-777", classroom, student4_parent);
		Set<Parent> student5_parent = new HashSet<>();
		student5_parent.add(parent7);
		Student student5 = new Student("student5", "student5", "Lajos", "", "Fazekas",
				LocalDate.of(2003, 12, 24), "Pillangó utca 36.",
				"0123411732", "333/777-444", classroom, student5_parent);
		Set<Parent> student6_parent = new HashSet<>();
		student2_parent.add(parent8);
		Student student6 = new Student("student6", "student6", "Viktória", "", "Kerekes",
				LocalDate.of(2004, 3, 11), "Kör utca 41.",
				"1123456732", "333/999-444", classroom, student6_parent);

		studentService.create(student1);
		studentService.create(student2);
		studentService.create(student3);
		studentService.create(student4);
		studentService.create(student5);
		studentService.create(student6);

		Admin admin = new Admin("admin", "admin");

		adminService.create(admin);


		Lesson lesson1 = new Lesson(1, 1, "2. emelet 22", course1);
		Lesson lesson2 = new Lesson(1, 2, "2. emelet 21", course2);
		Lesson lesson3 = new Lesson(3, 3, "2. emelet 25", course3);
		Lesson lesson4 = new Lesson(3, 4, "2. emelet 25", course4);
		Lesson lesson5 = new Lesson(5, 5, "2. emelet 22", course5);

		timeTableService.create(lesson1);
		timeTableService.create(lesson2);
		timeTableService.create(lesson3);
		timeTableService.create(lesson4);
		timeTableService.create(lesson5);

		courseService.setCourseToStudent(1L , "student1");
		courseService.setCourseToStudent(1L , "student2");
		courseService.setCourseToStudent(1L , "student3");
		courseService.setCourseToStudent(1L , "student4");
		courseService.setCourseToStudent(1L , "student5");
		courseService.setCourseToStudent(1L , "student6");

		courseService.setCourseToStudent(2L , "student1");
		courseService.setCourseToStudent(2L , "student2");
		courseService.setCourseToStudent(2L , "student3");
		courseService.setCourseToStudent(2L , "student4");
		courseService.setCourseToStudent(2L , "student5");
		courseService.setCourseToStudent(2L , "student6");

		courseService.setCourseToStudent(3L , "student1");
		courseService.setCourseToStudent(3L , "student2");
		courseService.setCourseToStudent(3L , "student3");
		courseService.setCourseToStudent(3L , "student4");
		courseService.setCourseToStudent(3L , "student5");
		courseService.setCourseToStudent(3L , "student6");

		courseService.setCourseToStudent(4L , "student1");
		courseService.setCourseToStudent(4L , "student2");
		courseService.setCourseToStudent(4L , "student3");
		courseService.setCourseToStudent(4L , "student4");
		courseService.setCourseToStudent(4L , "student5");
		courseService.setCourseToStudent(4L , "student6");

		courseService.setCourseToStudent(5L , "student1");
		courseService.setCourseToStudent(5L , "student2");
		courseService.setCourseToStudent(5L , "student3");
		courseService.setCourseToStudent(5L , "student4");
		courseService.setCourseToStudent(5L , "student5");
		courseService.setCourseToStudent(5L , "student6");

		courseService.setCourseToStudent(6L , "student1");
		courseService.setCourseToStudent(6L , "student2");
		courseService.setCourseToStudent(6L , "student3");
		courseService.setCourseToStudent(6L , "student4");
		courseService.setCourseToStudent(6L , "student5");
		courseService.setCourseToStudent(6L , "student6");

		courseService.setCourseToStudent(7L , "student1");
		courseService.setCourseToStudent(7L , "student2");
		courseService.setCourseToStudent(7L , "student3");
		courseService.setCourseToStudent(7L , "student4");
		courseService.setCourseToStudent(7L , "student5");
		courseService.setCourseToStudent(7L , "student6");

		Set<Exam> exams = new HashSet<>();

		List<Student> students = new ArrayList<>(studentService.getAll());
		List<Course> courses = new ArrayList<>(courseService.getAll());

		Random random = new Random();
		for(int i = 0; i < 50; i++) {
			int mark = random.nextInt(5) + 1;
			int rnd_course = random.nextInt(7);
			int rnd_student = random.nextInt(6);
			Exam exam = new Exam(ExamType.EXAM,
					LocalDate.of(2017, 10,11), mark,  courses.get(rnd_course), students.get(rnd_student));
			examService.create(exam);
			mark = random.nextInt(5) + 1;
			rnd_course = random.nextInt(7);
			rnd_student = random.nextInt(6);
			 exam = new Exam(ExamType.EXAM,
					LocalDate.of(2018, 3,11), mark,  courses.get(rnd_course), students.get(rnd_student));
			examService.create(exam);
		}

		Report report1 = new Report(student1, 9, 1, "Matek", 3);
		Report report2 = new Report(student2, 9, 1, "Matek", 2);
		Report report3 = new Report(student1, 9, 1, "Magyar nyelvtan", 4);
		Report report4 = new Report(student1, 9, 1, "Biológia", 5);
		Report report5 = new Report(student2, 9, 2, "Matek", 3);
		Report report6 = new Report(student1, 9, 2, "Matek", 2);
		Report report7 = new Report(student2, 9, 2, "Magyar nyelvtan", 4);
		Report report8 = new Report(student2, 9, 2, "Biológia", 5);

		reportService.create(report1);
		reportService.create(report2);
		reportService.create(report3);
		reportService.create(report4);
		reportService.create(report5);
		reportService.create(report6);
		reportService.create(report7);
		reportService.create(report8);

		Remark remark = new Remark("Szaktanári", student4, teacher2);
		remarkService.create(remark);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
