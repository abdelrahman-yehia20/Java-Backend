import model.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // one to one relation ship
        Account account = new Account();
        account.id = 1L;
        account.username = "ahmed";
        account.password = "123";

        AccountDetails accountDetails = new AccountDetails();
        accountDetails.id = 1L;
        accountDetails.age = 20;
        accountDetails.address = "alex";
        accountDetails.phoneNumber = "12345";

        account.accountDetails = accountDetails;
        accountDetails.account = account;

        // one to many relation ship
        Student student = new Student();
        student.id = 1L;
        student.username = "ahmed";
        student.password = "123";

        Email email1 = new Email();
        email1.id = 1l;
        email1.email = "a@gmail.com";

        Email email2 = new Email();
        email2.id = 1l;
        email2.email = "a@gmail.com";

        Set<Email> emails = new HashSet<>();
        emails.add(email1);
        emails.add(email2);

        // student to mails
        student.emails = emails;
        // emails to student
        email1.student = student;
        email2.student = student;


        // many to many
        Student student1 = new Student();
        student1.id = 1L;
        student1.username = "ahmed1";
        student1.password = "1231";

        Student student2 = new Student();
        student2.id = 2L;
        student2.username = "ahmed2";
        student2.password = "1232";


        Course course1  = new Course();
        course1.id = 1L;
        course1.courseName = "course1";

        Course course2  = new Course();
        course2.id = 2L;
        course2.courseName = "course2";

        List<Course> courses = new ArrayList<>();
        courses.add(course1);
        courses.add(course2);

        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);

        // many students to many courses
        student1.courses = courses;
        student2.courses = courses;

        // many courses to many students
        course1.students = students;
        course2.students = students;








    }
}