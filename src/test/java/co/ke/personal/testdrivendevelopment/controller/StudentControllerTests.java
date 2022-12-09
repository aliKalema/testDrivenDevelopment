package co.ke.personal.controller;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@WebMvcTest(controllers = StudentController.class)
@ExtendWith(SpringExtension.class)
public class StudentControllerTests {

}
