package com.github.yshameer.springjpa.snowflake.service;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.yshameer.springjpa.snowflake.service.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringJpaSnowflakeServiceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class})
@TestPropertySource("classpath:application-test.properties")
public class SpringJpaSnowflakeServiceApplicationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @DatabaseSetup(value = "/data/student.xml")
    @ExpectedDatabase("/data/student.xml")
    public void shouldReturnStudentSuccessfully() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
        Map<String, Long> params = new HashMap<>();
        params.put("studentId", 5L);
        ResponseEntity<Student> responseEntity = restTemplate.exchange("/student?studentId={studentId}", HttpMethod.GET, entity, Student.class, params);
        assertEquals("Mark", responseEntity.getBody().getStudentName());
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

}