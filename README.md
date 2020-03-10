
# Spring JPA Snowflake

Before running the project please update the application.properties under resources with the snowflake connection details

spring.datasource.url=jdbc:snowflake://CONNECTION_URL/?db=DATABASENAME&warehouse=WAREHOUSENAME&CLIENT_SESSION_KEEP_ALIVE=true&schema=SCHEMANAME
spring.datasource.username=
spring.datasource.password=

# In Snowflake create below to test 
CREATE TABLE STUDENT (STUDENT_ID NUMBER(4,0), STUDENT_NAME VARCHAR(25), CLASS_ID VARCHAR(10));
INSERT INTO STUDENT VALUES (1, 'RYAN', '6');
INSERT INTO STUDENT VALUES (2, 'MATT', '6');
INSERT INTO STUDENT VALUES (3, 'BILL', '6');
INSERT INTO STUDENT VALUES (4, 'STEVE', '6');


## Running Locally

To build and run with maven do the following:

```
mvn clean install
mvn spring-boot:run
```

## Testing Local
http://localhost:8080/student?studentId={studentId}