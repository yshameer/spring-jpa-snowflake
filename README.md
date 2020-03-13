
# Spring JPA Snowflake

Before running the project please update the application.properties under src/main/resources with your snowflake connection details
```
spring.datasource.url=jdbc:snowflake://yourcompany.snowflakecomputing.com/?db=DB_NAME&warehouse=WAREHOUSE_NAME&CLIENT_SESSION_KEEP_ALIVE=true&schema=SCHEMA_NAME
spring.datasource.username=USER_NAME
spring.datasource.password=USER_PWD
```

# In Snowflake create below to test 
```
CREATE TABLE STUDENT (STUDENT_ID NUMBER(4,0), STUDENT_NAME VARCHAR(25), CLASS_ID VARCHAR(10));
INSERT INTO STUDENT VALUES (1, 'RYAN', '6');
INSERT INTO STUDENT VALUES (2, 'MATT', '6');
INSERT INTO STUDENT VALUES (3, 'BILL', '6');
INSERT INTO STUDENT VALUES (4, 'STEVE', '6');
```

## Software required to build and run
```
Java: JDK 1.8+
Maven: Apache Maven 3.6.3+
```

## Package Information
If you are updating the package, please change the references in
```
com.github.yshameer.springjpa.snowflake.service.SpringJpaSnowflakeServiceApplication
   Line 11:  @ComponentScan(basePackages = "com.github.yshameer.springjpa")

com.github.yshameer.springjpa.snowflake.service.configuration.SwaggerDocumentationConfig
   Line 30: RequestHandlerSelectors.basePackage("com.github.yshameer.springjpa.snowflake.service.api")
   
application.properties
   spring.jpa.properties.hibernate.dialect=com.github.yshameer.springjpa.snowflake.service.dialect.SnowflakeDialect
```


## Running Locally

To build and run with maven do the following:

```
mvn clean install
mvn spring-boot:run
```

## Testing Local
```
http://localhost:8080/student?studentId={studentId}

Swagger UI: http://localhost:8080
```

## Snowflake references
https://docs.snowflake.net/manuals/user-guide-intro.html