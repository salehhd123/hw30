package com.example.schoolapi.Dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.*;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TecherDto {

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

}
