package com.example.schoolapi.Controller;


import com.example.schoolapi.Api.ApiResponse;
import com.example.schoolapi.Model.Student;
import com.example.schoolapi.Model.Teacher;
import com.example.schoolapi.Model.User;
import com.example.schoolapi.Service.StudentService;
import jakarta.validation.Valid;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student/api/v1")
public class StudentController {

    private final StudentService studentService;




    @PostMapping("/add-Info")
    public ResponseEntity add(@AuthenticationPrincipal User user, @RequestBody @Valid Student student){
        studentService.add(user.getId(), student);
        return ResponseEntity.status(200).body(new ApiResponse("added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable Integer id,@RequestBody @Valid  Student student){
        studentService.update(id,student);
        return ResponseEntity.status(200).body(new ApiResponse("updated"));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        studentService.delete(id);
        return ResponseEntity.status(200).body(new ApiResponse("deleted"));
    }


    @GetMapping("/myGrade/{id}")
    public ResponseEntity myGrade(@PathVariable Integer id){
        return ResponseEntity.status(200).body("your grade is : "+studentService.myGrade(id));
    }

}
