
# Spring JPA Snowflake

Before running the project, create a `.env` file in the project root directory with your Snowflake connection details:
```
SNOWFLAKE_ACCOUNT=your_account_name
SNOWFLAKE_USERNAME=your_username
SNOWFLAKE_PASSWORD=your_password
SNOWFLAKE_WAREHOUSE=your_warehouse
SNOWFLAKE_SCHEMA=your_schema
SNOWFLAKE_DATABASE=your_database
```

**Note:** Do not commit the `.env` file to version control. It is already added to `.gitignore`.

# In Snowflake create below to test 
```
CREATE TABLE STUDENT (STUDENT_ID NUMBER(4,0), STUDENT_NAME VARCHAR(25), CLASS_ID VARCHAR(10));
INSERT INTO STUDENT VALUES (1, 'RYAN', '6');
INSERT INTO STUDENT VALUES (2, 'MATT', '6');
INSERT INTO STUDENT VALUES (3, 'BILL', '6');
INSERT INTO STUDENT VALUES (4, 'STEVE', '6');
```

## Software Requirements

### Development Environment
- **Java**: JDK 21 (LTS)
- **Maven**: Apache Maven 3.9.x
- **IDE**: IntelliJ IDEA or VS Code with Java extensions

### Compatibility
- Minimum Java Version: JDK 17
- Recommended Java Version: JDK 21
- Spring Boot: 3.x
- Snowflake JDBC Driver: Latest version

### Prerequisites
- Snowflake account
- Maven installed
- Java Development Kit (JDK) installed

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