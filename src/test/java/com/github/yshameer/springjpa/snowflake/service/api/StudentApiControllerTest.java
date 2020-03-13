package com.github.yshameer.springjpa.snowflake.service.api;

import com.github.yshameer.springjpa.snowflake.service.entity.Student;
import com.github.yshameer.springjpa.snowflake.service.repository.StudentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(StudentApiController.class)
public class StudentApiControllerTest {

    @MockBean
    StudentRepository studentRepository;

    @Autowired
    private MockMvc mvc;


    @Test
    public void testStudentMockData() throws Exception {
        Student student = new Student();
        student.setStudentId(1L);
        student.setStudentName("Ryan");
        student.setClassId("6");
        when((studentRepository).findStudentById(1L)).thenReturn(student);


        mvc.perform(get("/student")
                .param("studentId", "1")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON));
    }

}