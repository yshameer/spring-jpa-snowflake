package com.github.yshameer.springjpa.snowflake.service.repository;

import com.github.yshameer.springjpa.snowflake.service.entity.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {

    @Query(value = "SELECT STUDENT_ID as \"student_id\", STUDENT_NAME as \"student_name\", CLASS_ID as \"class_id\" FROM STUDENT WHERE STUDENT_ID = ?", nativeQuery = true)
    Student findStudentById(Long studentId);

}
