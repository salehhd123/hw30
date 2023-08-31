package com.example.schoolapi.Service;


import com.example.schoolapi.Api.ApiException;
import com.example.schoolapi.Model.Student;
import com.example.schoolapi.Model.Teacher;
import com.example.schoolapi.Model.User;
import com.example.schoolapi.Repository.AuthRepository;
import com.example.schoolapi.Repository.StudentRepository;
import com.example.schoolapi.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final AuthRepository authRepository;
    private final StudentRepository studentRepository;

    public List<Teacher> getAll(){
        return teacherRepository.findAll();
    }
    public void add(Integer id,Teacher teacher){
        User user = authRepository.findUserById(id);
        teacher.setUser(user);
        teacherRepository.save(teacher);
    }

    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }

    public void update(Integer id,Teacher teacher){
        Teacher teacher1=teacherRepository.findTeacherById(id);
        if (teacher1==null){
            throw new ApiException("wrong id");
        }
        teacher1.setFname(teacher.getFname());
        teacher1.setLname(teacher.getLname());
        teacherRepository.save(teacher1);
    }

    public void delete(Integer id){
        Teacher teacher = teacherRepository.findTeacherById(id);
        if (teacher==null){
            throw new ApiException("wrong id");
        }
        teacherRepository.delete(teacher);
    }

    public void assignStudent(Integer Teacher_id,Integer Student_Id){
        User user = authRepository.findUserById(Teacher_id);
        Teacher teacher = user.getTeacher();
        Student student = studentRepository.findStudentById(Student_Id);
        if (student==null){
            throw new ApiException("wrong id");
        }
        if (student.getTeacher()!=null){
            throw new ApiException("already assigned to another teacher !");
        }
        student.setTeacher(teacher);
        studentRepository.save(student);
    }


    public void attendStudent(Integer id){
        Student student= studentRepository.findStudentById(id);
        if (student==null){
            throw new ApiException("wrong id");
        }
        student.setAttend(true);
        studentRepository.save(student);
    }


    public List<Student> allAttend(){
        List<Student> students = studentRepository.findAllByAttendIsTrue();
        if (students.isEmpty()){
            throw new ApiException("no one attend");
        }
        return students;
    }

    public void submitStudentGrade(Integer id,Double grade){
        Student student = studentRepository.findStudentById(id);
        if (student==null){
            throw new ApiException("wrong id");
        }
        student.setGrade(grade);
        studentRepository.save(student);
    }

    public Double gradeAvg(){
        Double avg = studentRepository.avg();
        return avg;
    }

    public Student higherStudentGrade(){
        Student student1= studentRepository.findStudentByGrade(studentRepository.higherGrade());
        return student1;
    }

    public Student lowerStudentGrade(){
        Student student1= studentRepository.findStudentByGrade(studentRepository.lowerGrade());
        return student1;
    }

    public List<Student> orderByGrade(){
        List<Student> g = studentRepository.orderBy();
        return g;
    }

    public Student findStudentById(Integer id){
        Student student= studentRepository.findStudentById(id);
        if (student==null){
            throw new ApiException("wrong id");
        }
        return student;
    }

    public Student findStudentByName(String n,String m){
        Student student= studentRepository.findStudentByname(n, m);
        if (student==null){
            throw new ApiException("wrong name");
        }
        return student;
    }

}
