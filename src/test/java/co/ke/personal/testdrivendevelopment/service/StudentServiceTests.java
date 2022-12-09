package co.ke.personal.testdrivendevelopment.service;

import co.ke.personal.testdrivendevelopment.controller.StudentController;
import co.ke.personal.testdrivendevelopment.repository.StudentRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
public class StudentServiceTests {

    @Autowired
    private StudentRepository studentRepository;

    @AfterEach
    void tearDown(){
        studentRepository.deleteAll();
    }
}
