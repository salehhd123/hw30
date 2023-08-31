package com.example.schoolapi.Repository;

import com.example.schoolapi.Model.Student;
import com.example.schoolapi.Model.Teacher;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    Student findStudentById(Integer id);

    List<Student> findAllByAttendIsTrue();

    @Query("select avg(grade) from Student")
    Double avg();

    @Query("select MAX (grade) from Student")
    Double higherGrade();

    @Query("select  MIN(grade) from Student")
    Double lowerGrade();

    Student findStudentByGrade(Double grade);

    @Query("select c from Student c order by c.grade desc")
    List<Student> orderBy();

    @Query("select c from Student c where c.Fname=?1 and c.Lname=?2")
    Student findStudentByname(String Fname,String Lname);


}
