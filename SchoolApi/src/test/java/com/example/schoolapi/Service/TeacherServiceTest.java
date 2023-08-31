package com.example.schoolapi.Service;

import com.example.schoolapi.Model.Student;
import com.example.schoolapi.Model.Teacher;
import com.example.schoolapi.Model.User;
import com.example.schoolapi.Repository.AuthRepository;
import com.example.schoolapi.Repository.StudentRepository;
import com.example.schoolapi.Repository.TeacherRepository;
import org.hibernate.service.spi.InjectService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TeacherServiceTest {

    @InjectMocks
    TeacherService teacherService;

    @InjectMocks
    StudentService studentService;

    @Mock
    AuthRepository authRepository;
    @Mock
    StudentRepository studentRepository;

    @Mock
    TeacherRepository teacherRepository;


    User user;
    Teacher teacher;

    Student student;

    Teacher teacher1,teacher2,teacher3;

    Student student1,student2;

    List<Teacher>teachers;
    List<Student>students;

    @BeforeEach
    void setUp() {

        User user1= new User(null, "saleh", "saleh", "1234", "TEACHER",null,null);
        teacher1=new Teacher(null,"saleh","Aslehehri",user1,null);
        teacher2=new Teacher(null,"saleh","Aslehehri",user1,null);
        teacher3=new Teacher(null,"saleh","Aslehehri",user1,null);

        User user2 = new User(null, "saleh", "saleh", "1234", "TEACHER",null,null);
        student1 = new Student(null,"saleh","alshehri",true,true,100.00,user2,null);
        student2 = new Student(null,"saleh","alshehri",true,true,100.00,user2,null);


        teachers=new ArrayList<>();
        teachers.add(teacher1);
        teachers.add(teacher2);
        teachers.add(teacher3);

        students=new ArrayList<>();
        students.add(student1);
        students.add(student2);

    }

    @Test
    void getAll() {
        when(teacherRepository.findAll()).thenReturn(teachers);
        List<Teacher> teacherList=teacherService.getAll();
        Assertions.assertEquals(3,teacherList.size());
        verify(teacherRepository,times(1)).findAll();
    }

    @Test
    void add() {
        when(authRepository.findUserById(user.getId())).thenReturn(user);
        teacherService.add(user.getId(),teacher3);
        verify(authRepository,times(1)).findUserById(user.getId());
        verify(teacherRepository,times(1)).save(teacher3);
    }

    @Test
    void getAllStudent() {
        when(studentRepository.findAll()).thenReturn(students);
        List<Student> studentList=teacherService.getAllStudent();
        Assertions.assertEquals(2,studentList.size());
        verify(studentRepository,times(1)).findAll();
    }

    @Test
    void delete(){
    when(teacherRepository.findTeacherById(teacher1.getId())).thenReturn(teacher);
    teacherService.delete(teacher1.getId());
    verify(teacherRepository,times(1)).delete(teacher1);
    verify(teacherRepository,times(1)).findTeacherById(teacher1.getId());
    }


    @Test
    void addStudent() {
        when(authRepository.findUserById(user.getId())).thenReturn(user);
        studentService.add(user.getId(), student1);
        verify(authRepository,times(1)).findUserById(user.getId());
        verify(studentRepository,times(1)).save(student1);

    }

    @Test
    void deleteSTudent() {
        when(studentRepository.findStudentById(teacher1.getId())).thenReturn(student);
        studentService.delete(student1.getId());
        verify(studentRepository,times(1)).delete(student1);
        verify(studentRepository,times(1)).findStudentById(student1.getId());

    }
}