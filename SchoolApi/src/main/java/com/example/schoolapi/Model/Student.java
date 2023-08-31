package com.example.schoolapi.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Student {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @NotEmpty(message = "can not be empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String Fname;

    @NotEmpty(message = "can not be empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String Lname;

    //the student can not change his attend and grade only access by teacher;

    private Boolean attend=false;


    //the student can not change his status and grade only access by teacher;
    private Boolean Status = false;

    @Min(value = 0 , message = "can not be less than zero")
    @Column(columnDefinition = "float check(grade>=0)")
    private Double grade;


    @OneToOne
    @MapsId
    @JsonIgnore
    private User user;


    @ManyToOne
    @JoinColumn(name = "teacher_id",referencedColumnName = "user_id")
    @JsonIgnore
    private Teacher teacher;



}
