package com.github.yshameer.springjpa.snowflake.service.entity;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "STUDENT")
@Getter
@Setter
public class Student {
    @Id
    @Column(name = "STUDENT_ID")
    private Long studentId;

    @Column(name = "STUDENT_NAME")
    private String studentName;

    @Column(name = "CLASS_ID")
    private String classId;

}
