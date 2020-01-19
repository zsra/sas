package hu.zsra.enaplo;

import hu.zsra.enaplo.dto.AttendanceDTO;
import hu.zsra.enaplo.dto.StudentResponseDTO;
import hu.zsra.enaplo.dto.TeacherResponseDTO;
import hu.zsra.enaplo.dto.UserResponseDTO;
import hu.zsra.enaplo.model.*;
import hu.zsra.enaplo.model.user.UserRoleName;
import hu.zsra.enaplo.model.user.group.Student;
import hu.zsra.enaplo.model.user.group.Teacher;
import hu.zsra.enaplo.service.auth.impl.AuthorityServiceImpl;
import hu.zsra.enaplo.service.auth.impl.UserServiceImpl;
import hu.zsra.enaplo.service.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@Service
public class InitData {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private TeacherServiceImpl teacherService;

    @Autowired
    private ClassroomServiceImpl classroomService;

    @Autowired
    private StudentServiceImp studentService;

    @Autowired
    private CourseServiceImpl courseService;

    @Autowired
    private TimeTableServiceImpl timeTableService;

    @Autowired
    private ExamServiceImpl examService;

    @Autowired
    private ReportServiceImpl reportService;

    @Autowired
    private AttendanceServiceImpl attendanceService;

    @Autowired
    private AuthorityServiceImpl authorityService;

    public void Init() {

        authorityService.save(UserRoleName.ROLE_ADMIN);
        authorityService.save(UserRoleName.ROLE_STUDENT);
        authorityService.save(UserRoleName.ROLE_TEACHER);
        authorityService.save(UserRoleName.ROLE_HEADTEACHER);

        UserResponseDTO admin = new UserResponseDTO("admin", "admin", "admin", "ROLE_ADMIN");
        userService.save(admin);

        testData();
    }

    public void testData() {
        UserResponseDTO user1 = new UserResponseDTO("student1", "student1", "Student1 Student1", "ROLE_STUDENT");
        UserResponseDTO user2 = new UserResponseDTO("student2", "student2", "Student2 Student2", "ROLE_STUDENT");
        UserResponseDTO user3 = new UserResponseDTO("student3", "student3", "Student3 Student3", "ROLE_STUDENT");
        UserResponseDTO user4 = new UserResponseDTO("student4", "student4", "Student4 Student4", "ROLE_STUDENT");
        UserResponseDTO user5 = new UserResponseDTO("student5", "student5", "Student5 Student5", "ROLE_STUDENT");
        UserResponseDTO user6 = new UserResponseDTO("student6", "student6", "Student6 Student6", "ROLE_STUDENT");
        UserResponseDTO user7 = new UserResponseDTO("student7", "student7", "Student7 Student7", "ROLE_STUDENT");
        UserResponseDTO user8 = new UserResponseDTO("student8", "student8", "Student8 Student8", "ROLE_STUDENT");
        UserResponseDTO user9 = new UserResponseDTO("student9", "student9", "Student9 Student9", "ROLE_STUDENT");
        UserResponseDTO user10 = new UserResponseDTO("student10", "student10", "Student10 Student10", "ROLE_STUDENT");

        UserResponseDTO user11 = new UserResponseDTO("teacher1", "teacher1", "teacher1 teacher1", "ROLE_TEACHER");
        UserResponseDTO user12 = new UserResponseDTO("teacher2", "teacher2", "teacher2 teacher2", "ROLE_TEACHER");
        UserResponseDTO user13 = new UserResponseDTO("teacher3", "teacher3", "teacher3 teacher3", "ROLE_TEACHER");
        UserResponseDTO user14 = new UserResponseDTO("teacher4", "teacher4", "teacher4 teacher4", "ROLE_TEACHER");
        UserResponseDTO user15 = new UserResponseDTO("teacher5", "teacher5", "teacher5 teacher5", "ROLE_TEACHER");
        UserResponseDTO user16 = new UserResponseDTO("teacher6", "teacher6", "teacher6 teacher6", "ROLE_TEACHER");
        UserResponseDTO user17 = new UserResponseDTO("teacher7", "teacher7", "teacher7 teacher7", "ROLE_TEACHER");

        userService.save(user1);
        userService.save(user2);
        userService.save(user3);
        userService.save(user4);
        userService.save(user5);
        userService.save(user6);
        userService.save(user7);
        userService.save(user8);
        userService.save(user9);
        userService.save(user10);

        userService.save(user11);
        userService.save(user12);
        userService.save(user13);
        userService.save(user14);
        userService.save(user15);
        userService.save(user16);
        userService.save(user17);

        TeacherResponseDTO teacher1 = new TeacherResponseDTO("teacher1", "teacher1",
                "teacher1@school.com", "0123456", "teacher1 teacher1");
        TeacherResponseDTO teacher2 = new TeacherResponseDTO("teacher2", "teacher2",
                "teacher1@school.com", "0123456", "teacher2 teacher2");
        TeacherResponseDTO teacher3 = new TeacherResponseDTO("teacher3", "teacher3",
                "teacher1@scool.com", "0123456", "teacher3 teacher3");
        TeacherResponseDTO teacher4 = new TeacherResponseDTO("teacher4", "teacher4",
                "teacher1@school.com", "0123456", "teacher4 teacher4");
        TeacherResponseDTO teacher5 = new TeacherResponseDTO("teacher5", "teacher5",
                "teacher1@school.com", "0123456", "teacher5 teacher5");
        TeacherResponseDTO teacher6 = new TeacherResponseDTO("teacher6", "teacher6",
                "teacher1@school.com", "0123456", "teacher6 teacher6");
        TeacherResponseDTO teacher7 = new TeacherResponseDTO("teacher7", "teacher7",
                "teacher1@school.com", "0123456", "teacher7 teacher7");

        teacherService.save(teacher1);
        teacherService.save(teacher2);
        teacherService.save(teacher3);
        teacherService.save(teacher4);
        teacherService.save(teacher5);
        teacherService.save(teacher6);
        teacherService.save(teacher7);

        Teacher cls_teacher1 =teacherService.findById(1l);
        Teacher cls_teacher2 =teacherService.findById(2l);
        Teacher cls_teacher3 =teacherService.findById(3l);
        Teacher cls_teacher4 =teacherService.findById(4l);
        Teacher cls_teacher5 =teacherService.findById(5l);
        Teacher cls_teacher6 =teacherService.findById(6l);
        Teacher cls_teacher7 =teacherService.findById(7l);

        Classroom classroom1 = new Classroom(2016, 2019, 9, 'a', cls_teacher1);
        Classroom classroom2 = new Classroom(2016, 2019, 9, 'b', cls_teacher2);

        classroomService.create(classroom1);
        classroomService.create(classroom2);

        StudentResponseDTO student1 = new StudentResponseDTO("student1", LocalDate.of(2002, 3,03),
                2016, "Messze utca 1.",
                "12345", "123456", "parent1 name", "parent2 name",
                1l, "student1 student1", "student1");
        StudentResponseDTO student2 = new StudentResponseDTO("student2", LocalDate.of(2002, 4,22),
                2016, "Messze utca 2.",
                "12345", "123456", "parent1 name", "parent2 name",
                1l, "student2 student2", "student2");
        StudentResponseDTO student3 = new StudentResponseDTO("student3", LocalDate.of(2002, 5,11),
                2016, "Messze utca 3.",
                "12345", "123456", "parent1 name", "parent2 name",
                1l, "student3 student3", "student3");
        StudentResponseDTO student4 = new StudentResponseDTO("student4", LocalDate.of(2002, 6,12),
                2016, "Messze utca 4.",
                "12345", "123456", "parent1 name", "parent2 name",
                1l, "student4 student4", "student4");
        StudentResponseDTO student5 = new StudentResponseDTO("student5", LocalDate.of(2002, 7,30),
                2016, "Messze utca 5.",
                "12345", "123456", "parent1 name", "parent2 name",
                1l, "student5 student5", "student5");
        StudentResponseDTO student6 = new StudentResponseDTO("student6", LocalDate.of(2002, 8,1),
                2016, "Messze utca 6.",
                "12345", "123456", "parent1 name", "parent2 name",
                2l, "student6 student6", "student6");
        StudentResponseDTO student7 = new StudentResponseDTO("student7", LocalDate.of(2002, 9,3),
                2016, "Messze utca 7.",
                "12345", "123456", "parent1 name", "parent2 name",
                2l, "student7 student7", "student7");
        StudentResponseDTO student8 = new StudentResponseDTO("student8", LocalDate.of(2002, 10,4),
                2016, "Messze utca 8.",
                "12345", "123456", "parent1 name", "parent2 name",
                2l, "student8 student8", "student8");
        StudentResponseDTO student9 = new StudentResponseDTO("student9", LocalDate.of(2002, 11,9),
                2016, "Messze utca 9.",
                "12345", "123456", "parent1 name", "parent2 name",
                2l, "student9 student9", "student9");
        StudentResponseDTO student10 = new StudentResponseDTO("student10", LocalDate.of(2002, 12,11),
                2016, "Messze utca 10.",
                "12345", "123456", "parent1 name", "parent2 name",
                2l, "student10 student10", "student10");

        studentService.save(student1);
        studentService.save(student2);
        studentService.save(student3);
        studentService.save(student4);
        studentService.save(student5);
        studentService.save(student6);
        studentService.save(student7);
        studentService.save(student8);
        studentService.save(student9);
        studentService.save(student10);


        Course course1 = new Course("Irodalom", 9, cls_teacher1);
        Course course2 = new Course("Nyelvtan", 9, cls_teacher1);
        Course course3 = new Course("Biológia", 9, cls_teacher2);
        Course course4 = new Course("Kémia", 9, cls_teacher3);
        Course course5 = new Course("Történelem", 9, cls_teacher4);
        Course course6 = new Course("Fizika", 9, cls_teacher5);
        Course course7 = new Course("Matematika", 9, cls_teacher6);
        Course course8 = new Course("Testnevelés", 9, cls_teacher7);
        Course course9 = new Course("Ének", 9, cls_teacher4);
        Course course10 = new Course("Angol", 9, cls_teacher5);

        courseService.create(course1);
        courseService.create(course2);
        courseService.create(course3);
        courseService.create(course4);
        courseService.create(course5);
        courseService.create(course6);
        courseService.create(course7);
        courseService.create(course8);
        courseService.create(course9);
        courseService.create(course10);

        TimeTableEntity timeTableEntity1 = new TimeTableEntity(1, 1, course1, "2. emelet 22.", classroom1);
        TimeTableEntity timeTableEntity2 = new TimeTableEntity(1, 2, course2, "2. emelet 22.", classroom1);
        TimeTableEntity timeTableEntity3 = new TimeTableEntity(1, 3, course3, "2. emelet 22.", classroom1);
        TimeTableEntity timeTableEntity4 = new TimeTableEntity(1, 4, course4, "2. emelet 22.", classroom1);
        TimeTableEntity timeTableEntity5 = new TimeTableEntity(2, 3, course5, "2. emelet 21.", classroom1);
        TimeTableEntity timeTableEntity6 = new TimeTableEntity(2, 4, course6, "2. emelet 24.", classroom1);
        TimeTableEntity timeTableEntity7 = new TimeTableEntity(2, 5, course7, "2. emelet 22.", classroom1);
        TimeTableEntity timeTableEntity8 = new TimeTableEntity(3, 1, course1, "2. emelet 24.", classroom2);
        TimeTableEntity timeTableEntity9 = new TimeTableEntity(3, 3, course2, "2. emelet 23.", classroom2);
        TimeTableEntity timeTableEntity10 = new TimeTableEntity(3, 4, course8, "Tornacsarnok", classroom2);
        TimeTableEntity timeTableEntity11 = new TimeTableEntity(4, 1, course4, "2. emelet 21.", classroom2);
        TimeTableEntity timeTableEntity12 = new TimeTableEntity(4, 2, course5, "2. emelet 21.", classroom2);
        TimeTableEntity timeTableEntity13 = new TimeTableEntity(5, 3, course6, "2. emelet 22.", classroom2);
        TimeTableEntity timeTableEntity14 = new TimeTableEntity(5, 4, course7, "2. emelet 22.", classroom2);

        timeTableService.create(timeTableEntity1);
        timeTableService.create(timeTableEntity2);
        timeTableService.create(timeTableEntity3);
        timeTableService.create(timeTableEntity4);
        timeTableService.create(timeTableEntity5);
        timeTableService.create(timeTableEntity6);
        timeTableService.create(timeTableEntity7);
        timeTableService.create(timeTableEntity8);
        timeTableService.create(timeTableEntity9);
        timeTableService.create(timeTableEntity10);
        timeTableService.create(timeTableEntity11);
        timeTableService.create(timeTableEntity12);
        timeTableService.create(timeTableEntity13);
        timeTableService.create(timeTableEntity14);

        classroomService.setCourse(1l, 1l);
        classroomService.setCourse(1l, 2l);
        classroomService.setCourse(1l, 3l);
        classroomService.setCourse(1l, 4l);
        classroomService.setCourse(1l, 5l);
        classroomService.setCourse(1l, 6l);
        classroomService.setCourse(1l, 7l);

        classroomService.setCourse(2l, 1l);
        classroomService.setCourse(2l, 2l);
        classroomService.setCourse(2l, 3l);
        classroomService.setCourse(2l, 4l);
        classroomService.setCourse(2l, 5l);
        classroomService.setCourse(2l, 6l);
        classroomService.setCourse(2l, 7l);

        List<Student> students = studentService.findAll();
        List<Course> courses = courseService.findAll();

        for(int i = 0; i < 400; i++) {
            Random rand = new Random();
            int mark = rand.nextInt(5) + 1;
            Student student = students.get(rand.nextInt(students.size()));
            Course course = courses.get(rand.nextInt(courses.size()));
            int year = rand.nextInt(2) + 2016;
            int month = rand.nextInt(12) + 1;
            int day = rand.nextInt(28) + 1;
            Exam exam = new Exam(mark, LocalDate.of(year, month, day), course, student);
            examService.create(exam);
        }

        Report report1 = new Report(students.get(1), 9, 1, "Testnevelés", 5);
        Report report2 = new Report(students.get(1), 9, 1, "Irodalom", 2);
        Report report3 = new Report(students.get(1), 9, 1, "Biológia", 3);
        Report report4 = new Report(students.get(1), 9, 1, "Matematika", 4);
        Report report5 = new Report(students.get(1), 9, 2, "Irodalom", 2);
        Report report6 = new Report(students.get(1), 9, 2, "Biológia", 3);
        Report report7 = new Report(students.get(1), 9, 2, "Matematika", 4);

        reportService.create(report1);
        reportService.create(report2);
        reportService.create(report3);
        reportService.create(report4);
        reportService.create(report5);
        reportService.create(report6);
        reportService.create(report7);

        for(int i = 0; i < 20; i++) {
            List<AttendanceDTO> attendanceDTOS = attendanceService.getForm(1l);
            for(AttendanceDTO attendanceDTO : attendanceDTOS) {
                attendanceDTO.setMiss(true);
            }
            Random rand = new Random();
            int lesson = rand.nextInt(7) + 1;
            int year = rand.nextInt(2017) + 2016;
            int month = rand.nextInt(12) + 1;
            int day = rand.nextInt(28) + 1;
            attendanceService.create(attendanceDTOS, lesson, LocalDate.of(year, month,day));
        }
    }
}
