package com.example.schoolapi.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Teacher {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @NotEmpty(message = "can not be empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String Fname;

    @NotEmpty(message = "can not be empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String Lname;


    @OneToOne
    @MapsId
    @JsonIgnore
    private User user;


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "teacher")
    private Set<Student> students;


}
