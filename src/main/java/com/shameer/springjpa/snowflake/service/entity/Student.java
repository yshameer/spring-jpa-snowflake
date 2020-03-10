package com.shameer.springjpa.snowflake.service.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
