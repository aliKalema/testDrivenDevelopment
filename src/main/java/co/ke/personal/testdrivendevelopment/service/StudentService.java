package co.ke.personal.testdrivendevelopment.service;

import co.ke.personal.testdrivendevelopment.payload.StudentRequest;
import co.ke.personal.testdrivendevelopment.repository.StudentRepository;
import co.ke.personal.testdrivendevelopment.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import co.ke.personal.testdrivendevelopment.model.Student;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public List<Student> getAllStudents(){
        return StreamSupport.stream(studentRepository.findAll().spliterator(),false).collect(Collectors.toList());
    }

    public Student createStudent(StudentRequest studentRequest){
        Student student =  new Student();
        student.setFirstName(studentRequest.getFirstName());
        student.setLastName(studentRequest.getLastName());
        String refId =  StringUtils.generateRefId();
        student.setRefId(StringUtils.generateRefId());
        return studentRepository.save(student);
    }
}
