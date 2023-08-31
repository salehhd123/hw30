package com.example.schoolapi.Dto;


import jakarta.persistence.Column;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    @NotEmpty(message = "can not be empty a")
    private String username;

    @NotEmpty(message = "can not be empty l")
    private String email;

    @NotEmpty(message = "can not be empty n")
    private String password;

    @NotEmpty(message = "can not be empty h")
    @Column(columnDefinition = "varchar(20) not null")
    private String Fname;

    @NotEmpty(message = "can not be empty qq")
    @Column(columnDefinition = "varchar(20) not null")
    private String Lname;

    private Boolean attend=false;

    //the student can not change his status and grade only access by teacher;
    private Boolean Status = false;

    @Min(value = 0 , message = "can not be less than zero")
    @Column(columnDefinition = "float check(grade>=0)")
    private Double grade;


}
