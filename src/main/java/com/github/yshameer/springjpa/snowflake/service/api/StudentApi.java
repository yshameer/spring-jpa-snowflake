package com.github.yshameer.springjpa.snowflake.service.api;

import com.github.yshameer.springjpa.snowflake.service.entity.Student;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Tag(name = "Student", description = "the Student API")
public interface StudentApi {

    @Operation(summary = "Find Student by ID", description = "Returns a single student")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
            @ApiResponse(responseCode = "404", description = "Student not found")
    })
    @RequestMapping(value = "/student",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<Student> getStudentById(
            @RequestParam("studentId")
                    Long studentId);

}
