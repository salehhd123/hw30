package com.example.schoolapi.Repository;

import com.example.schoolapi.Dto.StudentDto;
import com.example.schoolapi.Model.Student;
import com.example.schoolapi.Model.Teacher;
import com.example.schoolapi.Model.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;



@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class StudentRepositoryTest {


    @Autowired
    StudentRepository studentRepository;

    Student student1,student2;

    StudentDto studentDto;



@BeforeEach
public void setUp(){
    User user = new User(null, "saleh", "saleh", "1234", "STUDENT",null,null);
     student1 = new Student(null,"saleh","alshehri",true,true,100.00,user,null);
    student2 = new Student(null,"saleh","alshehri",true,true,100.00,user,null);

}


    @Test
    void findStudentById() {
    studentRepository.save(student1);
    Student student =studentRepository.findStudentById(student1.getId());
        Assertions.assertThat(student).isEqualTo(student1);

}

    @Test
    void findAllByAttendIsTrue() {
studentRepository.save(student1);
        List<Student> myList= studentRepository.findAllByAttendIsTrue();
        Assertions.assertThat(myList.get(0).getAttend()).isEqualTo(student1.getAttend());

    }

    @Test
    void avg() {
    studentRepository.save(student1);
    Double student=studentRepository.avg();
        Assertions.assertThat(student).isEqualTo(student1.getGrade());
    }

    @Test
    void higherGrade() {
        studentRepository.save(student1);
        Double student=studentRepository.avg();
        Assertions.assertThat(student).isEqualTo(student1.getGrade());
    }

    @Test
    void lowerGrade() {
        studentRepository.save(student1);
        Double student=studentRepository.avg();
        Assertions.assertThat(student).isEqualTo(student1.getGrade());
    }
}