package com.example.schoolapi.Controller;

import com.example.schoolapi.Model.Student;
import com.example.schoolapi.Model.Teacher;
import com.example.schoolapi.Model.User;
import com.example.schoolapi.Service.StudentService;
import com.example.schoolapi.Service.TeacherService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.example.schoolapi.Model.Teacher;
import com.example.schoolapi.Model.User;
import com.example.schoolapi.Service.TeacherService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = TeacherController.class , excludeAutoConfiguration = {SecurityAutoConfiguration.class})
class StudentControllerTest {

    @MockBean
    StudentService studentService;
    @Autowired
    MockMvc mockMvc;

    User user;

    List<Student> students,studentList;

    Student student1,student2;


    @BeforeEach
    public void setUp(){
         user = new User(null, "saleh", "saleh", "1234", "STUDENT",null,null);
        student1 = new Student(null,"saleh","alshehri",true,true,100.00,user,null);
        student2 = new Student(null,"saleh","alshehri",true,true,100.00,user,null);

        studentList  = Arrays.asList(student1);
    }



    @Test
    void add() throws Exception {
      mockMvc.perform(post("/student/api/v1/add-Info").contentType(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(student1))).andExpect(status().isOk());
    }

    @Test
    void delete() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/student/api/v1/delete/{id}",student1.getId())).andExpect(status().isOk());

    }
}