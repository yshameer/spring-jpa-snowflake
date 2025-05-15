package com.github.yshameer.springjpa.snowflake.service.api;

import com.github.yshameer.springjpa.snowflake.service.entity.Student;
import com.github.yshameer.springjpa.snowflake.service.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(StudentApiController.class)
class StudentApiControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentRepository studentRepository;

    private Student testStudent;

    @BeforeEach
    void setUp() {
        testStudent = new Student();
        testStudent.setStudentId(5L);
        testStudent.setStudentName("Mark Johnson");
        testStudent.setClassId("10A");
    }

    @Test
    void testGetStudentSuccess() throws Exception {
        // Arrange
        when(studentRepository.findById(testStudent.getStudentId()))
            .thenReturn(Optional.of(testStudent));

        // Act & Assert
        mockMvc.perform(get("/student")
                .param("studentId", testStudent.getStudentId().toString())
                .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.studentId").value(testStudent.getStudentId()))
            .andExpect(jsonPath("$.studentName").value(testStudent.getStudentName()))
            .andExpect(jsonPath("$.classId").value(testStudent.getClassId()));
    }

    @Test
    void testGetStudentNotFound() throws Exception {
        // Arrange
        Long nonExistentStudentId = 999L;
        when(studentRepository.findById(nonExistentStudentId))
            .thenReturn(Optional.empty());

        // Act & Assert
        mockMvc.perform(get("/student")
                .param("studentId", nonExistentStudentId.toString())
                .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isNotFound());
    }

    @Test
    void testGetStudentBadRequest() throws Exception {
        // Act & Assert
        mockMvc.perform(get("/student")
                .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isBadRequest());
    }
}
