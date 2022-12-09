package co.ke.personal.testdrivendevelopment.controller;

import co.ke.personal.testdrivendevelopment.payload.StudentRequest;
import co.ke.personal.testdrivendevelopment.repository.StudentRepository;
import co.ke.personal.testdrivendevelopment.service.StudentService;
import co.ke.personal.testdrivendevelopment.model.Student;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(controllers = StudentController.class)
@ExtendWith(SpringExtension.class)
public class StudentControllerTests {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    StudentService studentService;

    @Test
    public void shouldGetAllStudentsTest() throws Exception {
        when(studentService.getAllStudents()).thenReturn(List.of(new Student(1L,"Ali","Baraza","HT82390j3","HDB212-c005-0096/2017"),
                                                                 new Student(2L,"Harun","Rashid","HB82390j3","HDB212-c005-0095/2017")));
        mockMvc.perform(get("/api/v1/students").contentType(MediaType.APPLICATION_JSON))
               .andExpect(status().is2xxSuccessful())
               .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(2))).andDo(print());
    }

    @Test
    public void shouldCreateStudent() throws Exception {
        StudentRequest studentRequest =  new StudentRequest("Harun", "Rashid");
        ObjectMapper objectMapper = new ObjectMapper();
        String studentRequestJson = objectMapper.writeValueAsString(studentRequest);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/students")
                                                    .contentType(MediaType.APPLICATION_JSON)
                                                    .content(studentRequestJson))
                    .andExpect(status().isCreated());

        verify(studentService).createStudent(any(StudentRequest.class));
    }
}
