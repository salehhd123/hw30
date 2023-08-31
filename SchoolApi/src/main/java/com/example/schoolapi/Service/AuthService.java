package com.example.schoolapi.Service;


import com.example.schoolapi.Dto.StudentDto;
import com.example.schoolapi.Dto.TecherDto;
import com.example.schoolapi.Model.Student;
import com.example.schoolapi.Model.Teacher;
import com.example.schoolapi.Model.User;
import com.example.schoolapi.Repository.AuthRepository;
import com.example.schoolapi.Repository.StudentRepository;
import com.example.schoolapi.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AuthService {
    private final AuthRepository authRepository;
    private final TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;


    public void register(TecherDto techerDto){
        User user = new User(null, techerDto.getUsername(), techerDto.getEmail(), techerDto.getPassword(), "TEACHER",null,null);
        Teacher teacher= new Teacher(null, techerDto.getFname(), techerDto.getLname(),user,null);
        String hash=new BCryptPasswordEncoder().encode(techerDto.getPassword());
        user.setPassword(hash);
        teacherRepository.save(teacher);
    }



    public void registerUser(StudentDto studentDto){
        User user = new User(null, studentDto.getUsername(), studentDto.getEmail(), studentDto.getPassword(), "STUDENT",null,null);
        Student student = new Student(null,studentDto.getFname(),studentDto.getLname(),studentDto.getAttend(),studentDto.getStatus(),studentDto.getGrade(),user,null);
        String hash=new BCryptPasswordEncoder().encode(studentDto.getPassword());
        user.setPassword(hash);
        studentRepository.save(student);
    }


    public List<User> getAll(){
        return authRepository.findAll();
    }


}
