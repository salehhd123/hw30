package com.example.schoolapi.Controller;

import com.example.schoolapi.Model.Student;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = TeacherController.class , excludeAutoConfiguration = {SecurityAutoConfiguration.class})
class TeacherControllerTest {

    @MockBean
    TeacherService teacherService;
    @Autowired
    MockMvc mockMvc;

List<Teacher> teachers,teacherList;

Teacher teacher1,teacher2;


User user;

    @BeforeEach
    void setUp() {

        User user1= new User(1, "saleh", "saleh", "1234", "TEACHER",null,null);
        teacher1=new Teacher(1,"saleh","Aslehehri",user1,null);
        teacher2=new Teacher(2,"saleh","Aslehehri",user1,null);


       teacherList  = Arrays.asList(teacher1);


    }

    @Test
    public void GetAll() throws Exception {
        Mockito.when(teacherService.getAll()).thenReturn(teacherList);
        mockMvc.perform(get("/teacher/api/v1/get"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(1)));
    }

    @Test
    public void add()throws Exception{
        mockMvc.perform(post("/teacher/api/v1/add-Info")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(teacher1))).andExpect(status().isOk());
    }


    @Test
    public void delete()throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.delete("/teacher/api/v1/delete/{id}",teacher1.getId())).andExpect(status().isOk());

    }
}