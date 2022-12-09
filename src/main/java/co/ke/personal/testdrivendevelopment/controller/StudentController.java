package co.ke.personal.testdrivendevelopment.controller;

import co.ke.personal.testdrivendevelopment.payload.StudentRequest;
import co.ke.personal.testdrivendevelopment.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.ke.personal.testdrivendevelopment.model.Student;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public record StudentController(StudentService studentService) {

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents(){
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(StudentRequest studentRequest){
        return new ResponseEntity<>(studentService.createStudent(studentRequest), HttpStatus.CREATED);
    }
}
